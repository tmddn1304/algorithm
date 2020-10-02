package silver;

import java.io.*;
import java.util.*;

public class 안녕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int[] hp = new int[a+1];
		int[] happy = new int[a+1];
		int[][] dp = new int[a+1][101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=a; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=a; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=a; i++) {
			for(int j=1; j<=100; j++) {
				if(hp[i] < j) {
					dp[i][j] = Math.max(happy[i] + dp[i-1][j-hp[i]], dp[i-1][j]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		
		System.out.println(dp[a][100]);		
	}

}
