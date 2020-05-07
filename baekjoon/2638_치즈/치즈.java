import java.io.*;
import java.util.*;

public class Main {

	public static class pair {
		int r, c;
		pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		System.out.println("sss");
		map = new int[n][m];
		copy = new int[n][m];
		visited = new boolean[n][m];
		day = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
				if (map[i][j] == 0)
					count++;
			}
		}
//		System.out.println("test");
//		System.out.println(count+","+n*m);
		if (count >= n * m) {
			System.out.println(day);
			return;
		}
		while (true) {
			day++;
			count = 0;
			edge_bfs();
			// 녹을거 찾기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						if (search(i, j)) {
							copy[i][j] = 3;
						}
					}
				}
			}
			
			// 녹이기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (copy[i][j] == 3) {
						map[i][j] = 2;
						copy[i][j] = 2;
					}
					if (map[i][j] == 2 || map[i][j] == 0)
						count++;
					visited[i][j] = false;
				}
			}

//			System.out.println(count);
			if (count >= n * m) {
				System.out.println(day);
				break;
			}
			
//			for (int i = 0; i < n; n++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	static int[][] copy;
	static int day;

	public static void edge_bfs() {
		Queue<pair> queue = new LinkedList<>();
		queue.add(new pair(0, 0));
		queue.add(new pair(n - 1, m - 1));
		queue.add(new pair(0, m - 1));
		queue.add(new pair(n - 1, 0));
		while (!queue.isEmpty()) {
			pair cur = queue.poll();
			int cr = cur.r;
			int cc = cur.c;
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if (nr < 0 || nc< 0 || nr >= n || nc >= m)
					continue;

				if (!visited[nr][nc] && (map[nr][nc] == 0 || map[nr][nc] == 2)) {
					visited[nr][nc] = true;
					map[nr][nc] = 2;
					copy[nr][nc] = 2;
					queue.add(new pair(nr, nc));
				}
			}
		}
	}

	public static boolean search(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= n || nc >= m)
				continue;
			if (map[nr][nc] == 2) {
				count++;
				if(count > 1)
					return true;
			}
		}
		if (count > 1)
			return true;
		else
			return false;
	}

}
