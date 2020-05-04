import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 아이스크림 수
		int M = Integer.parseInt(st.nextToken()); // 안 섞어먹을 아이스크림 가짓수

		int[] arr = new int[N];

		for (int i = 1; i < N + 1; i++) {
			arr[i - 1] = i;
		}

		a = new ArrayList[N+1];
		ans =0;
		for (int i = 0; i < N+1; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(b < c) a[b].add(c);
			else a[c].add(b);
		}

		comb(0, 0, arr, new int[3]);
		System.out.println(ans);
	}

	static int N;
	static ArrayList<Integer>[] a;
	static int ans;
	public static void comb(int idx, int sel_idx, int[] arr, int[] sel) {
		if (sel_idx >= 3) {
			for (int i = 0; i < 2; i++) {
				for (int j = i + 1; j < 3; j++) {
					for (int k = 0; k < a[sel[i]].size(); k++) {
						if (sel[j] == a[sel[i]].get(k)) {
							return;
						}
					}
				}
			}
//			System.out.println(Arrays.toString(sel));
			ans++;
			return;
		}

		if (idx >= N)
			return;

		sel[sel_idx] = arr[idx];

		comb(idx + 1, sel_idx + 1, arr, sel);
		comb(idx + 1, sel_idx, arr, sel);
	}

}
