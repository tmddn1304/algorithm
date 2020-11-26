import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		int r,c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pair> queue = new LinkedList<>();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int ansWolf =0;
		int ansSheep=0;
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int sheep =0;
		int wolf=0;
		
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				
				if(map[r][c]=='k' || map[r][c]=='v') {
					queue.add(new Pair(r, c));
					if(map[r][c]=='k')
						sheep++;
					if(map[r][c]=='v')
						wolf++;
					map[r][c]='.';
					while (!queue.isEmpty()) {
						Pair cur = queue.poll();

						int cr = cur.r;
						int cc = cur.c;

						for (int i = 0; i < 4; i++) {
							int nr = cr + dr[i];
							int nc = cc + dc[i];

							if (nr < 0 || nc < 0 || nr >= R || nc >= C)
								continue;
							if (map[nr][nc] == '#')continue;
							if (!visited[nr][nc]) {
								visited[nr][nc] = true;
								if(map[nr][nc]=='k')//k는 양
								{
									sheep++;
									map[nr][nc] ='.';
								}
								else if(map[nr][nc]=='v') //v는늑대
								{
									wolf++;
									map[nr][nc] ='.';
								}
								
								queue.add(new Pair(nr, nc));
								
							}
						}
//						System.out.println("늑대는"+ wolf +" 양은 "+sheep);
					}//while끝
					if(wolf >=sheep) {
						ansWolf +=wolf;
					}
					else {
						ansSheep +=sheep;
					}
					wolf =0;
					sheep =0;
				}
				
			}//for문 c
		}//for문 r
		
//		for(int r=0; r<R; r++) {
//			for(int c=0; c<C; c++) {
//				System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		System.out.println(ansSheep +" " +ansWolf);
		
	}
}
