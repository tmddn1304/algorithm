import java.io.*;
import java.util.*;

public class Main {
	public static class Chicken {
		int r, c;

		public Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static class Home {
		int r, c;

		public Home(int r, int c) {
			this.r = r;
			this.c = c;
		}

		int[] distance = new int[13];
	}

	
	static int chickenN;
	static int homeN;
	static ArrayList<Chicken> chicken;
	static ArrayList<Home> home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 맵 넓이
		int M = Integer.parseInt(st.nextToken()); // 유지할 치킨 집 수

		chicken = new ArrayList<>();
		home = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {// 집
					home.add(new Home(r, c));
				} else if (a == 2) { // 치킨집
					chicken.add(new Chicken(r, c));
				}
			}
		}
		chickenN = chicken.size();
		homeN = home.size();
		for (int i = 0; i < homeN; i++) {
			for (int j = 0; j < chickenN; j++) {
				home.get(i).distance[j] = Math.abs(home.get(i).r - chicken.get(j).r)
						+ Math.abs(home.get(i).c - chicken.get(j).c);
			}
		}
		
		int[] arr = new int[chickenN];
		for(int i=0; i<chickenN; i++) {
			arr[i] = i;
		}
		
		comb(0, 0, M, new int[M], arr);
		
		System.out.println(ans);
	}// main 끝

	static int ans =987654321;
	public static void comb(int sel_idx, int idx, int M, int[] sel, int[] arr) {
		if (sel_idx >= M) {
			int sum =0;
			int[] min_temp = new int[M];
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < homeN; i++) {
				for (int j = 0; j < M; j++) {
					min_temp[j]= home.get(i).distance[sel[j]];
					
				}
				Arrays.sort(min_temp);
//				System.out.println(Arrays.toString(min_temp));
				sum +=min_temp[0];
			}
			if(sum < ans)
				ans = sum;
			return;
		}

		if (idx >= arr.length) {
			return;
		}
		sel[sel_idx] = arr[idx];
		comb(sel_idx + 1, idx + 1, M, sel, arr);
		comb(sel_idx, idx + 1, M, sel, arr);

	}
}
