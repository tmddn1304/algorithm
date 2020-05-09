import java.io.*;
import java.util.*;

public class 접미사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String[] arr = new String[s.length()];
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			sb.setLength(0);
			for(int j=i; j<s.length(); j++) {
				sb.append(s.charAt(j));
			}
			arr[i] = sb.toString();
		}
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
