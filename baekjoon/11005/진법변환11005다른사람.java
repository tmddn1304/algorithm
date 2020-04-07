package bronze;

import java.util.Scanner;

public class 진법변환11005다른사람 {
	public static void main(String[] args) {
		int N, B;
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(N > 0) {
			sb.append(N % B >= 10 ? Character.toString((char)('A' + N % B - 10)) : N % B);
			N /= B;
		}
		System.out.println(sb.reverse());
		sc.close();
	}
}