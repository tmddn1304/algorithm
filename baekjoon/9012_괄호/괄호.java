import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		loop:
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(c == '(') {
					stack.push(c);
				}
				else {
					if(stack.isEmpty()) {
						System.out.println("NO");
						continue loop;
					}
					else stack.pop();
				}
			}
			if(stack.size()==0)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
