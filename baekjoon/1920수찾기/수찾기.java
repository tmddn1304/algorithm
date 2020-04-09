package pro;

import java.io.*;
import java.util.*;

public class 수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			System.out.println(binary_search(arr, target));
		}
	}
	
	public static int binary_search(int arr[], int target){
		
		int left =0;
		int right =arr.length-1;
		int mid;
		
		while(left <=right) {
			mid = (left+right)/2;
			if(arr[mid] == target) return 1;
			if (arr[mid] >target)
				right = mid-1;
			else left = mid+1;
					
		}

		return 0;
	}

}
