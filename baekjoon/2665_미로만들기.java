import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int map[][];
	static int visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
				visited[r][c] = 987654321;
			}
		}

		bfs(0, 0);
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<N; c++) {
//				System.out.print(visited[r][c]);
//			}
//			System.out.println();
//		}
		System.out.println(visited[N - 1][N - 1]);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(r, c));
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			int cc = cur.c;
			int cr = cur.r;
			for (int i = 0; i < 4; i++) {
				int nc = cc + dc[i];
				int nr = cr + dr[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)continue;
				if (visited[nr][nc] <= visited[cr][cc])
					continue;
				if (map[nr][nc] == 1) {
					queue.add(new Pair(nr, nc));
					visited[nr][nc] = visited[cr][cc];
				} else {
					queue.add(new Pair(nr, nc));
					visited[nr][nc] = visited[cr][cc] + 1;
				}

			}
		}
	}

}
