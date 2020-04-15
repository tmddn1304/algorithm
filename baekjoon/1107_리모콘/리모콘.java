package pro;

import java.io.*;
import java.util.*;
public class 리모콘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//이동할 채널
		int m = Integer.parseInt(br.readLine());//고장난 채널수
		if(m!=0) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				int a =Integer.parseInt(st.nextToken());
				arr[a] = 1;
			}
		}
		int ans = Math.abs(n-100); //직접 이동하는 케이스
		
		for(int i=0; i<=1000000; i++) {
			int b = check(i);
			if(b!=0)
			ans = Math.min(ans, b+Math.abs(n-i));
		}
		System.out.println(ans);
	} 
	static int[] arr = new int[10];
	public static int check(int num) {
		  if(num == 0){
		        if(arr[0] == 1)
		            return 0;
		        else
		            return 1;
		    }
		    int cnt = 0;
		    
		    while(num> 0){
		        //중간에 한개의 버튼이라도 고장났다면 탈락!
		        if(arr[num%10] == 1){
		            return 0;
		        }
		        cnt++;
		        num /= 10;
		    }
		    return cnt;
	}

}
