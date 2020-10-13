import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소 {

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[][] copy;
	static boolean[][] virus_visited;
	static int N;//세로
	static int M;//가로
	static int[] sel;
	static int max;
	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy = new int[N][M];
		max = 0;
		virus_visited = new boolean[N][M];
		sel = new int[3];
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}
		comb(0,0);
		System.out.println(max);
	}// end main
					//   상  하   좌    우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void init() {
		
		for(int i=0; i<N; i++)
		{
			System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			Arrays.fill(virus_visited[i], false);
		}

	}
	static void BFS() {
		while (!queue.isEmpty()) {
			Pair virus = queue.poll();
			int c_x = virus.x;
			int c_y = virus.y;
			for (int i = 0; i < 4; i++) {
				int nx = c_x + dx[i];
				int ny = c_y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if(copy[ny][nx] ==0 && virus_visited[ny][nx]==false)
				{
					virus_visited[ny][nx]=true;
					copy[ny][nx]=2;
					queue.add(new Pair(nx, ny));
				}
			}
		}
	}//BFS 종료
	
	static void comb(int idx, int sel_idx)
	{
		if(sel_idx >= 3)
		{
			init();
			int ans = 0;
		
			
			for(int i=0; i<3; i++)
			{
				if(copy[sel[i]/M][sel[i]%M] ==2 || copy[sel[i]/M][sel[i]%M] == 1)return;
				copy[sel[i]/M][sel[i]%M] =1;	
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] ==2)
					{
						queue.add(new Pair(j,i));
					}
				}
			}
			BFS();
			
			// 2차원 배열을 한줄로 나열합니다.
			
			
			//조합을 돌리면 될거같은데... 기저조건으로 Pair쌍으로 넘겨주면 될거같은데...
			//2차원 배열에서 재귀를...? 가능한가?
			for(int i=0; i <N*M; i++)
			{
				if(copy[i/M][i%M]==0)ans++;	
			}
			
				
//				System.out.println();
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(copy[i][j]);
//					}
//					System.out.println();
//				}
			
			max = (max>ans)? max : ans;

			return;
		}
		
		for(int i = idx; i< N * M; i++)
		{			
			sel[sel_idx] = i;
			comb(i+1,sel_idx+1);
		}
	}
}