import java.io.*;
import java.util.*;

public class Main {

	public static class Monkey {
		int r, c, s,jumpcnt;

		Monkey(int r, int c,int s, int jumpcnt) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.jumpcnt = jumpcnt;
		}
	}

	static int K;
	static int N;
	static int M;
	static int[][] map = new int[201][201];
	static boolean[][][] visited = new boolean[201][201][31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());// 원숭이의 점프가능횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(ans);
	}

	static int[] mdr = { -1, 1, 0, 0 };
	static int[] mdc = { 0, 0, -1, 1 };

	static int[] hdr = { -1, -2, 1, 2, -1, -2, 2, 1 };
	static int[] hdc = { -2, -1, 2, 1, 2, 1, -1, -2 };

	static int ans=-1;
	public static void bfs() {
		Queue<Monkey> monkeyQueue = new LinkedList<>();
		monkeyQueue.add(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!monkeyQueue.isEmpty()) {
			Monkey cur = monkeyQueue.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cs = cur.s;
			int jumpCnt = cur.jumpcnt;
			
			if(cr == N-1 && cc == M-1)
			{
				ans=cs;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cr + mdr[i];
				int nc = cc + mdc[i];
				if(nr <0 || nc <0 || nr >=N || nc>=M)continue;
				if(!visited[nr][nc][jumpCnt] && map[nr][nc]!=1) {
					visited[nr][nc][jumpCnt]= true;
					monkeyQueue.add(new Monkey(nr, nc, cs+1,jumpCnt));
				}
			}
			if(jumpCnt==K) continue;
			
			for(int i=0; i<8;i++) {
				int nr = cr + hdr[i];
				int nc = cc + hdc[i];
				if(nr <0 || nc <0 || nr >=N || nc>=M)continue;
				if(!visited[nr][nc][jumpCnt+1] && map[nr][nc]!=1) {
					visited[nr][nc][jumpCnt+1]= true;
					monkeyQueue.add(new Monkey(nr, nc, cs+1,jumpCnt+1));
				}
			}
		}
	}

}
