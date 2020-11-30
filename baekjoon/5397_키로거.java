import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> answer = new Stack<>();
			Stack<Character> temp = new Stack<>();
			String str = br.readLine();
			int idx = 0;
			for (int i = 0; i < str.length(); i++) {

				char c = str.charAt(i);

				switch (c) {
				case '<':
					if (!answer.isEmpty()) {
						temp.push(answer.pop());
					}
					break;
				case '>':
					if (!temp.isEmpty()) {
						answer.push(temp.pop());
					}

					break;
				case '-':
					if (!answer.isEmpty()) {
						answer.pop();
					}
					break;
				default:
					answer.push(c);
					break;
				}// 스위치끝

			} // 문자 분해 끝
			Object[] array = answer.toArray();
			for(int i=0; i<array.length; i++) {
				sb.append(array[i]);
			}
			
			while (!temp.isEmpty()) {
				sb.append(temp.pop());
			}
			sb.append('\n');

		}
		System.out.print(sb.toString());
	}

}
