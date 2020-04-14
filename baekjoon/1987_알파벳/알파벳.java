package pro;

import java.io.*;
import java.util.*;

public class 알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];

		for (int r = 1; r <= R; r++) {
			String str = br.readLine();
			for (int c = 1; c <= C; c++) {
				map[r][c] = str.charAt(c - 1);
			}
		}
		DFS(1, 1);
		
		System.out.println(ans);
	}

	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static boolean[] visited = new boolean[26];
	static char[][] map;
	static int R, C;
	static int ans = 1;
	static int cnt = 1;

	public static void DFS(int r, int c) {
		int alpha = map[r][c] - 65;
		visited[alpha] = true;

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr < 1 || nc < 1 || nr > R || nc > C)continue;

			int nextAlpha = map[nr][nc] - 65;
			if (!visited[nextAlpha]) {
				cnt++;
				ans = Math.max(ans, cnt);
				DFS(nr, nc);				
			}

		}
		cnt--;
		visited[alpha] = false;
	}
}