import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int camCount = 0;

	static ArrayList<cam> list = new ArrayList<cam>();

	public static class cam {
		int r, c, level;

		public cam(int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N][M];
		copy = new int[N][M];

		int deadZone =0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 0 && map[r][c] < 5) {
					list.add(new cam(r, c, map[r][c]));
					camCount++;
				} else if (map[r][c] == 5) {
					Fill(r, c, up);
					Fill(r, c, down);
					Fill(r, c, left);
					Fill(r, c, right);
				}
				
				
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++){
				copy[r][c]=map[r][c];
				if(map[r][c]==0){
					deadZone++;
				}
			}
		}

		
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<M; c++){
//				System.out.print(copy[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		

		ans = deadZone;
		if (camCount > 0)
			re_perm(0, new int[camCount]);
		
		System.out.println(ans);
	}

	// 상 하 좌 우
	public static void Fill(int r, int c, int dir) {
		if (!isOk(r, c))
			return;

		if (dir == 0) {
			Fill(r - 1, c, dir);
			
		} else if (dir == 1) {
			Fill(r + 1, c, dir);
			
		} else if (dir == 2) {
			Fill(r, c - 1, dir);
			
		} else if (dir == 3) {
			Fill(r, c + 1, dir);
			
		}
		if (map[r][c] == 0)
			map[r][c] = 9;
	}

	static final int up = 0;
	static final int down = 1;
	static final int left = 2;
	static final int right = 3;

	static int ans =987654321;
	public static void re_perm(int idx, int[] sel) {
		if (idx >= sel.length) {
			// 명령어 방향 4번 방향으로 1번 방향으로 등등
			int sum =0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[r][c]= copy[r][c];
				}
			}
			
			for (int i = 0; i < sel.length; i++) {
				// 감시카메라 레벨에 따라서 방향 설정
				switch (list.get(i).level) {
				// 감시카메라 레벨이 1일 경우
				case 1:
					if (sel[i] == up)
						Fill(list.get(i).r, list.get(i).c, up);
					else if (sel[i] == down)
						Fill(list.get(i).r, list.get(i).c, down);
					else if (sel[i] == left)
						Fill(list.get(i).r, list.get(i).c, left);
					else if (sel[i] == right)
						Fill(list.get(i).r, list.get(i).c, right);
					break;
				// 감시카메라 레벨이 2일경우
				case 2:
					if (sel[i] == up) {
						Fill(list.get(i).r, list.get(i).c, up);
						Fill(list.get(i).r, list.get(i).c, down);
					}
					else if (sel[i] == down) {
						Fill(list.get(i).r, list.get(i).c, up);
						Fill(list.get(i).r, list.get(i).c, down);
					}
					else if (sel[i] == left) {
						Fill(list.get(i).r, list.get(i).c, left);
						Fill(list.get(i).r, list.get(i).c, right);
					}
					else if (sel[i] == right) {
						Fill(list.get(i).r, list.get(i).c, left);
						Fill(list.get(i).r, list.get(i).c, right);
					}

					break;

				// 감시카메라 레벨이 3일경우
				case 3:
					if (sel[i] == up) {
						Fill(list.get(i).r, list.get(i).c, up);
						Fill(list.get(i).r, list.get(i).c, right);
					}
					else if (sel[i] == down) {
						Fill(list.get(i).r, list.get(i).c, right);
						Fill(list.get(i).r, list.get(i).c, down);
					}
					else if (sel[i] == left) {
						Fill(list.get(i).r, list.get(i).c, down);
						Fill(list.get(i).r, list.get(i).c, left);
					}
					else if (sel[i] == right) {
						Fill(list.get(i).r, list.get(i).c, left);
						Fill(list.get(i).r, list.get(i).c, up);
					}

					break;

				case 4:
					if (sel[i] == up) {
						Fill(list.get(i).r, list.get(i).c, up);
						Fill(list.get(i).r, list.get(i).c, left);
						Fill(list.get(i).r, list.get(i).c, right);
					}
					else if (sel[i] == down) {
						Fill(list.get(i).r, list.get(i).c, up);
						Fill(list.get(i).r, list.get(i).c, right);
						Fill(list.get(i).r, list.get(i).c, down);
					}
					else if (sel[i] == left) {
						Fill(list.get(i).r, list.get(i).c, right);
						Fill(list.get(i).r, list.get(i).c, down);
						Fill(list.get(i).r, list.get(i).c, left);
					}
					else if (sel[i] == right) {
						Fill(list.get(i).r, list.get(i).c, down);
						Fill(list.get(i).r, list.get(i).c, left);
						Fill(list.get(i).r, list.get(i).c, up);
					}

					break;
				}// 스위치 (감시카메라 레벨 )종료
			} //뽑아온거 다 돌려봄 
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c]==0)
						sum++;
				}
			}
			if(ans > sum)
				ans = sum;
			return;
		}

		for (int i = 0; i < 4; i++) {
			sel[idx] = i;
			re_perm(idx + 1, sel);
		}
	}

	public static boolean isOk(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M || map[r][c]==6)
			return false;
		return true;
	}

}
