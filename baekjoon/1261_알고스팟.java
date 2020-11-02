import java.io.*;
import java.util.*;

public class Main {
	public static class Pair implements Comparable<Pair>{
		int r, c,dist;

		Pair(int r, int c,int dist) {
			this.r = r;
			this.c = c;
			this.dist =dist;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
	}
	
	static int N;
	static int M;
	static int map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c]=str.charAt(c)-'0';

			}
		}
		bfs(0, 0);
		System.out.println(ans);
	}
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans=987654321;
	public static void bfs(int r, int c) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();

		queue.add(new Pair(r, c,0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			int cc = cur.c;
			int cr = cur.r;
			int cdist = cur.dist;
			if(cr==N-1 && cc==M-1) {
				ans = Math.min(ans, cdist);
                break;
            }
			
			for (int i = 0; i < 4; i++) {
				int nc = cc + dc[i];
				int nr = cr + dr[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)continue;
				if (visited[nr][nc])continue;
				visited[nr][nc] =true;
				if (map[nr][nc] == 0) {
					queue.add(new Pair(nr, nc,cdist));
				} else {
					queue.add(new Pair(nr, nc,cdist+1));
				}

			}
		}
	}

}
