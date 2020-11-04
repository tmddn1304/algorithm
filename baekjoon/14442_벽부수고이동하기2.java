import java.io.*;
import java.util.*;

public class Main {

	public static class Person {
		int r, c, s,cnt;

		Person(int r, int c,int s, int cnt) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.cnt = cnt;
		}
	}

	static int K;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		K = Integer.parseInt(st.nextToken());// 부수기 가능한 횟수

		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) -'0';
			}
		}
		bfs();
		System.out.println(ans);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int ans=-1;
	public static void bfs() {
		Queue<Person> queue = new LinkedList<>();
		queue.add(new Person(0, 0, 0, K));
		visited[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			Person cur = queue.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cs = cur.s;
			int cCnt = cur.cnt;
			
			if(cr == N-1 && cc == M-1)
			{
				ans=cs+1;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr <0 || nc <0 || nr >=N || nc>=M)continue;
				
				if(map[nr][nc]==1 && cCnt>0 && !visited[nr][nc][cCnt-1]) {
					visited[nr][nc][cCnt-1]= true;
					queue.add(new Person(nr, nc, cs+1,cCnt-1));
				}
				
				if(map[nr][nc]==0 && !visited[nr][nc][cCnt]) {
					visited[nr][nc][cCnt]= true;
					queue.add(new Person(nr, nc, cs+1,cCnt));
				}
			}
		}
	}

}
