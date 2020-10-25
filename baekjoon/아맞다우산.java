import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int itemCount;

	public static class pair {
		int r, c, s;

		public pair(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	static int sr, sc;
	static int er, ec;
	static int M;
	static int N;
	static char copy[][];
	static ArrayList<pair> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 가로
		M = Integer.parseInt(st.nextToken());// 세로

		map = new char[M][N];
		copy = new char[M][N];
		list = new ArrayList<>();
		for (int r = 0; r < M; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
				copy[r][c] = map[r][c];
				if (map[r][c] == 'S') {
					sr = r;
					sc = c;
				} else if (map[r][c] == 'X') {
					list.add(new pair(r, c, 0));
					itemCount++;
				} else if (map[r][c] == 'E') {
					er = r;
					ec = c;
				}
			}
		}

		perm(0, new int[itemCount]);
		System.out.println(ans);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int startr, int startc, int s, pair goal) {
		Queue<pair> queue = new LinkedList<>();
		queue.add(new pair(startr, startc, 0));
		boolean[][] visited = new boolean[M][N];
		while (!queue.isEmpty()) {
			pair cur = queue.poll();
			int cc = cur.c;
			int cr = cur.r;
			int cs = cur.s;

			if(goal.c == cc && goal.r == cr) {
//				System.out.println("걸음수는" +cs +"현재 도착한 곳은 "+cc+","+cr);
				
//				for(int r=0; r<M; r++) {
//					for(int c=0; c<N; c++) {
//						System.out.print(map[r][c]);
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				total_step+=cs;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(map[nr][nc] =='#') continue;
				if(!visited[nr][nc])
				{
					visited[nr][nc] =true;
					queue.add(new pair(nr, nc, cs+1));
					
				}
				

			}
		}
	}

	static boolean[] use = new boolean[5];
	static int ans=987654321;
	static int total_step=0;
	public static void perm(int idx, int[] sel) {
		if (idx >= itemCount) {
			int startr = sr;
			int startc = sc;
			for(int i=0; i<itemCount; i++) {
				bfs(startr, startc, 0, list.get(sel[i]));
				startr=list.get(sel[i]).r;
				startc=list.get(sel[i]).c;
			}
//			System.out.println("최종 도착지점은!!");
			bfs(startr, startc, 0, new pair(er, ec, 0));
//			System.out.println("최종 걸음수는" + total_step);
//			System.out.println("-----------------------");
			
			if(ans > total_step) {
				ans=total_step;
			}
			total_step=0;
			return;
		}

		for (int i = 0; i < itemCount; i++) {
			if (!use[i]) {
				use[i] = true;
				sel[idx] = i;
				perm(idx + 1, sel);
				use[i] = false;
			}
		}

	}

}
