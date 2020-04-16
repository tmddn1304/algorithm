import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr  =new char[C];
		 
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		StringBuilder pwd = new StringBuilder();
		
		comb(pwd, 0);
	}
	static int L,C;
	static char[] arr;
	static char[] vowel = {'a','e','i','o','u'};
	public static void comb(StringBuilder pwd,int idx) {
		if(pwd.length() >=L) {
			int v = 0;//모음
			int c = 0;//자음
			for(int i=0; i<pwd.length(); i++) {
				
				char ch = pwd.charAt(i);
				
				if(ch=='a' || ch=='e' || ch =='i' || ch =='o' || ch =='u')v++;
				else c++;
			}
			if(v>=1 && c>=2) {					
				System.out.println(pwd.toString());
			}
			return;
		}
		//다뽑았으면 종료
		if(idx >=C) return;
		pwd.append(arr[idx]);
		comb(pwd,idx+1);
		pwd.deleteCharAt(pwd.length()-1);
		comb(pwd,idx+1);
	}
}
