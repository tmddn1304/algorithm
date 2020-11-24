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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		Queue<Pair> queue = new LinkedList<>();
		char[][] map = new char[R][C];
		String str;
		for(int r=0; r<R;r++) {
			 str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='S')
					queue.add(new Pair(r, c));
			}
		}
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int ans=1;
		while(!queue.isEmpty()) {
			Pair sheep = queue.poll();
			for(int i=0; i<4;i++) {
				int nr = sheep.r + dr[i];
				int nc = sheep.c + dc[i];
				if(nr < 0 || nc <0 || nr>=R || nc >=C)continue;
				if(map[nr][nc] =='W')
					ans=0;
				else if(map[nr][nc] !='S')
					map[nr][nc] ='D';
			}
		}
		if(ans ==0) {
			sb.append('0');
			System.out.println(sb.toString());			
		}
		else {
			sb.append('1').append('\n');
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					sb.append(map[r][c]);
				}
				sb.append('\n');
			}
			System.out.print(sb.toString());
		}
		
		
	}

}
