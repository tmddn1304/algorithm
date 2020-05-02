package pro;

import java.io.*;
import java.util.*;

public class 움직이는미로탈출 {
	public static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static char[][] map = new char[8][8];
	static boolean[][] visited = new boolean[8][8];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				char a = str.charAt(j);
				map[i][j] = a;
				if (map[i][j] == '#') {
					cnt++;
				}
			}
		}
		if (cnt == 0)
			System.out.println(1);
		else {
			bfs();
		}

	}

	static int[] dr = { -1, 1, 0, 0,1,-1,1,-1,0 };
	static int[] dc = { 0, 0, -1, 1,1,-1,-1,1,0 };

	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(7, 0));

		while (!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				Pair cur = queue.poll();
				size--;
				
				int cc = cur.c;
				int cr = cur.r;
				if(map[cr][cc]== '#') continue;
				if (cc == 7 && cr == 0) {
					System.out.println(1);
					return;
				}

				for (int i = 0; i < 9; i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];

					
					if (isOk(nr, nc)) {
						if(visited[nr][nc]) continue;
						visited[nr][nc]= true;
						queue.add(new Pair(nr, nc));
					}
				}
			}
			if(cnt == 0) {
				System.out.println(1);
				return;
			}
			downMap();			
		}
		System.out.println(0);
	}
	public static void downMap() {
		Queue<Character> helper = new LinkedList<>();
		if(cnt !=0) {
			for (int c = 0; c < 8; c++) {
				if (map[7][c] == '#') {
					map[7][c] = '.';
					cnt--;
				}
			}
			for (int c = 0; c < 8; c++) {
				for (int r = 6; r >= 0; r--) {
					helper.add(map[r][c]);
					map[r][c] = '.';
				}
			}
			while (!helper.isEmpty()) {
				for (int c = 0; c < 8; c++) {
					for (int r = 7; r >= 1; r--) {
						map[r][c] = helper.poll();
					}
				}
			}			
		}
	}

	public static boolean isOk(int r, int c) {
		if (r < 0 || c < 0 || r >= 8 || c >= 8 || map[r][c] == '#')
			return false;
		return true;
	}

}
