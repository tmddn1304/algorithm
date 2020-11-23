import java.io.*;
import java.util.*;

public class Main {
	public static class pair {
		int r, c;

		public pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		StringTokenizer st = null;
		int ans = 0, ansr = 0, ansc = 0;
		for (int r = 0; r < 19; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 19; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		loop: for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if (map[r][c] != 0) {
					int color = map[r][c];
					int count = 0;

					// 오른쪽 체크
					for (int i = 0; i < 6; i++) {
						int nc = c + i;
						if (nc >= 19)
							break;
						if (map[r][nc] != color) {
							break;
						}
						count++;
					}

					// 시작의 왼쪽점 체크용
					int tempc = c - 1;
					if (count == 5) {
						if (tempc >= 0) {
							if (map[r][tempc] == color) {
								count++;
							}
						}
					}

					if (count == 5) {
						ans = color;
						ansr = r;
						ansc = c;
						break loop;
					} else if (count > 5) {
						ans = 0;
					}

					// 아래쪽 체크용
					// 여기까지 왔는데 브레이크 안됬으면 5개가 없다는 뜻
					count = 0;
					for (int i = 0; i < 6; i++) {
						int nr = r + i;
						if (nr >= 19)
							break;
						if (map[nr][c] != color) {
							break;
						}
						count++;
					}
					// 시작의 위쪽 체크
					int tempr = r - 1;
					if (count == 5) {
						if (tempr >= 0) {
							if (map[tempr][c] == color) {
								count++;
							}
						}
					}

					if (count == 5) {
						ans = color;
						ansr = r;
						ansc = c;
						break loop;
					} else if (count > 5) {
						ans = 0;
					}

					// 좌하 체크용
					// 여기까지 왔는데 브레이크 안됬으면 5개가 없다는 뜻
					count = 0;
					for (int i = 0; i < 6; i++) {
						int nc = c - i;
						int nr = r + i;
						if (nr >= 19 || nc < 0)
							break;
						if (map[nr][nc] != color) {
							break;
						}
						count++;
					}
					// 시작점의 우상 체크용
					int temprr = r - 1;
					int tempcc = c + 1;
					if (count == 5) {
						if (temprr >= 0 && tempcc < 19) {
							if (map[temprr][tempcc] == color) {
								count++;
							}
						}
					}
					if (count == 5) {
						ans = color;
						ansr = r + 4;
						ansc = c - 4;
						break loop;
					} else if (count > 5) {
						ans = 0;
					}
					// 여기까지 왔는데 브레크 안됬으면 5개가 없다는 뜻

					// 우하 체크용
					count = 0;
					for (int i = 0; i < 6; i++) {
						int nc = c + i;
						int nr = r + i;
						if (nr >= 19 || nc >= 19)
							break;
						if (map[nr][nc] != color) {
							break;
						}
						count++;
					}
					// 시작점의 좌 상 체크용
					int temprrr = r - 1;
					int tempccc = c - 1;
					if (count == 5) {
						if (temprr >= 0 && tempcc >= 0) {
							if (map[temprrr][tempccc] == color) {
								count++;
							}
						}
					}

					if (count == 5) {
						ans = color;
						ansr = r;
						ansc = c;
						break loop;
					} else if (count > 5) {
						ans = 0;
					}

				}
			}
		}
		if (ans == 0) {
			System.out.println(ans);
		} else {
			ansr++;
			ansc++;
			System.out.println(ans);
			System.out.println(ansr + " " + ansc);
		}

	}

}
