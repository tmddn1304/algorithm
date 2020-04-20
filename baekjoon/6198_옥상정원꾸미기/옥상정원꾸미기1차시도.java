//의도가 nlogn n 으로 풀길 요구하는거 같은데 n^2으로 시험삼아 내봤는데 통과함

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		long ans =0;
		for(int i=0; i<N; i++) {
			int start =arr[i];
			for(int j=i+1; j<N; j++) {
				if(arr[i]<=arr[j])break;
				else ans++;
			}
		}
		System.out.println(ans);
		
		
	}

}
