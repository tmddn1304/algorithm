package bronze;

import java.io.*;
import java.util.*;

public class 멀티버스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());// 우주의 개수
		int N = Integer.parseInt(st.nextToken());// 행성의 개수

		int[][] map = new int[M][N];
		int answer =0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] ans = new int[M][N][N];
		for(int h=0; h<M; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) ans[h][i][j] =0;
					else {
						ans[h][i][j] = (map[h][i] < map[h][j])? 1 : -1;						
					}
				}
			}
		}
		
//		for(int h=0; h<M; h++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(ans[h][i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("-------------------------");
//		}
		
		for (int h = 0; h < M; h++) {
			for (int k = h + 1; k < M; k++) {
				boolean notSame = false;
				loop:for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (notSame ==true)
							break;
						if (ans[h][i][j] != ans[k][i][j]) {
							notSame = true;
							break loop;
						}
					}
				}
				if (notSame==false)
					answer++;
			}

		}
		System.out.println(answer);

	}

}
