import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int left = 0;
		int result = 0;

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
			}			
			else{
				if(left <= 0) {
					result++;
				}
				else {
					left--;
				}
			}
		}
		result +=left;
		System.out.println(result);
	}

}
