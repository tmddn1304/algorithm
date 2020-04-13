package gold;

import java.io.*;
import java.util.*;

public class 빗물 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int a = Integer.parseInt(st.nextToken());
			int y = H - 1;
			for (int j = 0; j < a; j++) {
				map[y][i] = 1;
				y--;
			}
		}
		
		int ans =0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1) {
					int water =0;
					if (j + 1 < W) {
						for (int right = j + 1; right < W; right++) {
							if (map[i][right] == 1) {
								ans +=water;
								break;
							}
							else if(map[i][right]==0) {
								map[i][right] = 3;
								water++;
							}
							
						}
					}
					if(j-1 >= 0) {
						water =0;
						for(int left =j-1; left>=0; left--) {
							if (map[i][left] == 1) {
								ans +=water;
								break;
							}
							else if(map[i][left]==0) {
								map[i][left] =3;
								water++;
							}
						}
					}
				}
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println(ans);

	}
}
