package bronze;

import java.io.*;
import java.util.*;

public class 진법변환11005 {

	// 제약 입출력 제외 Arraylist말고는 사용 안해봄
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		ArrayList<Character> list = new ArrayList<>();
		while (true) {
			int b = N % B;
			char c = Character.forDigit(b, 10);

			if (b > 9 && b < B) {
				c = (char) (b - 10 + 65);
			}
			list.add(c);
			N /= B;

			if (N < B) {
				if (N != 0) {
					if (N > 9 && N < B) {
						list.add((char) (N - 10 + 65));

					} else {
						list.add(Character.forDigit(N, 10));
					}
				}
				break;
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i));
		}

	}

}
