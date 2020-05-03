import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		int[][] map = new int[n][n];


		int cr = n / 2;
		int cc = n / 2;
		
		int num =1;
		map[cr][cc] = num;
		
					//위 오 하 좌
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		
		int cnt = 0; //반복할 횟수
		int[] ans = new int[2];
		loop:
		while (true) {
			
			int dir=0;
			
			cnt++;
			for (int i = 0; i < cnt; i++) {
				
				cr += dr[dir];
				if(cr <0) break loop;
				num++;
				if(t == num) {
					ans[0] = cr+1;
					ans[1] = cc+1;
				}
				map[cr][cc] = num;
			}
			dir++;
			for (int i = 0; i < cnt; i++) {
				cc += dc[dir];
				num++;
				
				if(t == num) {
					ans[0] = cr+1;
					ans[1] = cc+1;
				}
				map[cr][cc] = num;
			}
			
			
			cnt++;
			dir++;
			for (int i = 0; i < cnt; i++) {
				cr += dr[dir];
				num++;
				if(t == num) {
					ans[0] = cr+1;
					ans[1] = cc+1;
				}
				map[cr][cc] = num;
			}
			
			
			dir++;
			for (int i = 0; i < cnt; i++) {
				cc += dc[dir];
				num++;
				if(t == num) {
					ans[0] = cr+1;
					ans[1] = cc+1;
				}
				map[cr][cc] = num;
			}

		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}

		System.out.print(ans[0]+" " + ans[1]);
	}

}
