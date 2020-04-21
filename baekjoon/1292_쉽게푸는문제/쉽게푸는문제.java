import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[b+1];
		
		int k=1;
		int n=1;
		//배열의 idx
		for(int i=1; i<=b; i++) {
			//반복횟수
			for(int j=0; j<k; j++) {
				if(i==b+1) break;
				arr[i++] = n;
			}
			i--;
			k++;
			n++;
		}
		int ans =0;
		for(int i=a; i<=b; i++) {
			ans +=arr[i];
		}
		System.out.println(ans);
	}
}
