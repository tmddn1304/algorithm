import java.util.Stack;

public class Solution3 {
	public static void solution(int numOfOrder, String[] orderArr) {
 
		for(String str : orderArr) {
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				stack.add(str.charAt(i));
			}
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				Character pop = stack.pop();
				if(pop == ')') continue;
				else if(pop =='(') {
					Character c = stack.pop();
					if(c >='0' && c <='9') {
						String temp= sb.toString();
						int a=Character.getNumericValue(c);
						while(a>1) {
							sb.append(temp);
							a--;
						}
					}
					else {
						String temp = sb.toString();
						int length = temp.length();
						
						for(int i=0; i<length; i++) {
							sb.insert((2*i)+1, c);
						}
					}
				}
				else if(pop >='0' && pop <='9') {
					int a=Character.getNumericValue(pop);
					while(a>1) {
						sb.append(sb.toString().charAt(sb.length()-1));
						a--;
					}
				}
				else {
					sb.append(pop);
				}
			}
			System.out.println(sb.reverse().toString());
		}

	  }
	public static void main(String[] args) {
		int numOfOrder=2;
		String[] orderArr = {"B2(RG)","1B2R3G"};
		
		solution(numOfOrder, orderArr);
	}

}
