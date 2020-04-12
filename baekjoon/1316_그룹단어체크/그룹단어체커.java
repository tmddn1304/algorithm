package silver;

import java.io.*;

public class 그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result = 0;
		// solution
		while (t-- > 0) {
			String input = br.readLine().trim();
			if (checkGroup(input)) {
				result++;
			}
		}
		System.out.print(result);
	}

	private static boolean checkGroup(String input) {
		boolean[] alpabet = new boolean[26];
		int length = input.length();
		int i;
		for (i = 0; i < length; i++) {
			char temp = input.charAt(i);
			if (alpabet[temp - 'a']) {
				return false;
			} else {
				if (i < length - 1 && temp != input.charAt(i + 1)) {
					alpabet[temp - 'a'] = true;
				}
			}
		}
		return true;
	}
}