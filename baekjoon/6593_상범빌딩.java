import java.io.*;
import java.util.*;

public class Main {
	public static class Person{
		int r,c,h,step;
		public Person(int r, int c, int h,int step) {
			this.r =r;
			this.c =c;
			this.h =h;
			this.step=step;
		}
	}
	
	static int N;
	static int M;
	static int H;
	static char[][][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); //높이
			N = Integer.parseInt(st.nextToken()); //세로
			M = Integer.parseInt(st.nextToken()); //가로
			ans =987654321;
			Person start= null;
			Person goal =null;
			map = new char[H][N][M];
			visited = new boolean[H][N][M];
			if(H==0 && N==0 && M==0) break;
			for(int h=0; h<H; h++) {
				for(int r=0; r<N; r++) {
					String str = br.readLine();
					for(int c=0; c<M; c++) {
						map[h][r][c] = str.charAt(c);
						if(map[h][r][c]=='S')
							start = new Person(r, c, h,0);
						else if(map[h][r][c]=='E')
							goal = new Person(r, c, h, 0);
							
					}
				}
				br.readLine();
			}
			bfs(start.r, start.c, start.h,goal);
			if(ans==987654321)
			sb.append("Trapped!").append('\n');
			else
			sb.append("Escaped in ").append(ans).append(" minute(s).").append('\n');
		}
		System.out.println(sb.toString());
		
		
	}//main 끝
	static int[] dr= {-1,1,0,0,0,0};
	static int[] dc= {0,0,-1,1,0,0};
	static int[] dh= {0,0,0,0,-1,1};
	static int ans = 987654321;
	public static void bfs(int r, int c, int h, Person goal) {
		Queue<Person> queue = new LinkedList<>();
		queue.add(new Person(r, c, h,0));
		while (!queue.isEmpty()) {
			Person cur = queue.poll();
			int cc = cur.c;
			int cr = cur.r;
			int ch = cur.h;
			int cstep = cur.step;
			if(goal.c == cc && goal.r == cr && goal.h == ch) {
				ans = cstep;
				break;
			}
			
			for(int i=0; i<6; i++) {
				int nc = cc + dc[i];
				int nr = cr + dr[i];
				int nh = ch + dh[i];
				if(!isOk(nr, nc, nh))continue;
				if(!visited[nh][nr][nc]) {
					visited[nh][nr][nc] =true;
					queue.add(new Person(nr, nc, nh,cstep+1));
				}
				
			}
		}
		
	}
	
	public static boolean isOk(int r, int c,int h) {
		if (r < 0 || c < 0||  h<0 || r >= N || c >= M|| h>=H || map[h][r][c]=='#')
			return false;
		return true;
	}

}
