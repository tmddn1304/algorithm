import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		loop:
		while(true){
			String str = br.readLine();
			if(str.charAt(0)=='.' && str.length() == 1)break;
			Stack<Character> stack = new Stack<>();
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(c == '(' || c=='[') {
					stack.push(c);
				}
				else if(c ==']'){
					if(stack.isEmpty() || stack.peek() =='(') {
						System.out.println("no");
						continue loop;
					}
					else stack.pop();
				}
				else if(c ==')') {
					if(stack.isEmpty() || stack.peek() =='[') {
						System.out.println("no");
						continue loop;
					}
					else stack.pop();
				}
			}
		
			if(stack.size()==0)System.out.println("yes");
			else System.out.println("no");
		}
	}
}
