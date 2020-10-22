package boj;

import java.io.*;
import java.util.*;

public class 부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		int answer=Integer.MAX_VALUE;
		int left=0;
		int right=0;
		
		while(true) {
			if(sum >= S) {
				if(answer > right-left)
					answer=right-left;
				sum -=arr[left++];
			}
			else if(right==N)break;
			else sum +=arr[right++];
		}
		answer = (answer==Integer.MAX_VALUE)? 0: answer;
		System.out.println(answer);
	}

}
