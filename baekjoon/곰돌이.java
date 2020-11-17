import java.io.*;
import java.util.*;

public class Main {
	public static class bee {
		int r, c, t;

		public bee(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static class bear {
		int r, c, t,s;

		public bear(int r, int c, int t,int s) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.s = s;
		}
	}
	static int N;
	static int S;
	static char[][] map = new char[801][801];
	static int[][] copy = new int[801][801];
	static boolean[][] visited = new boolean[801][801];
	static Queue<bee> beequeue= new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //맵크기
		S = Integer.parseInt(st.nextToken()); //곰의 이동가능 거리
	
		int startr=0,startc=0;
		int endr=0,endc=0;
		for(int r=0; r<N; r++){
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='T') { //나무
					copy[r][c]=-1;
				}
				else if(map[r][c]=='D') {//곰 집
					copy[r][c]=Integer.MAX_VALUE;
					endr=r;
					endc=c;
				}
				else if(map[r][c]=='M') { //곰
					copy[r][c]=0;
					startr=r;
					startc=c;
				}
				else if(map[r][c] == 'G') {//숲
					copy[r][c]=0;
				}
				else if(map[r][c]=='H') { //벌집
					copy[r][c]=-1;
					beequeue.add(new bee(r, c, 0));
				}
			}
		}//입력끝
		
		//벌퍼뜨리기
		beefs();
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<N; c++) {
//				System.out.print(copy[r][c]);
//			}
//			System.out.println();
//		}
//		
		int left = -1, right = 0, max = -1;

		right = copy[startr][startc];

		while (left <= right) {
			int mid = (left + right) / 2;
			boolean attaced = goHome(startr, startc, endr, endc, mid);
			if (attaced) {
				left = mid + 1;
				if (max < mid)
					max = mid;
			} else { 
				right = mid - 1;
			}
		}
//		System.out.println(goHome(startr, startc, endr, endc, 2));
		
		System.out.println(max);
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static boolean goHome(int startr, int startc, int endr, int endc, int level) {
		boolean[][] visited = new boolean[N][N];
		Queue<bear> bearqueue = new LinkedList<>();
		visited[startr][startc] = true;
		bearqueue.add(new bear(startr, startc, level,S));
		while(!bearqueue.isEmpty()) {
			
			bear cur = bearqueue.poll();
			int cc = cur.c;
			int cr = cur.r;
			int clevel = cur.t;
			int cs = cur.s;
			if(clevel == copy[cr][cc]) continue;
//			System.out.println(level);
//			System.out.println(cr+","+cc+", 곰 레벨은"+clevel);
				for(int i=0; i<4; i++) {
					int nr = cr+dr[i];
					int nc = cc+dc[i];
					if(nr <0 || nc <0 || nr>=N || nc >=N)continue;
					if(!visited[nr][nc] && copy[nr][nc]> clevel) {
						visited[nr][nc]=true;

						if (nr == endr && nc == endc) {
//							System.out.println(copy[cr][cc] +", 곰 레벨은"+clevel);
							return true;
						}
						if(cs-1==0) {
//							System.out.println(copy[nr][nc]+" :   " + nr + " ,"+nc);
							bearqueue.add(new bear(nr, nc, clevel+1,S));
						}
						else {
							bearqueue.add(new bear(nr, nc, clevel,cs-1));
						}
					}
				}
		}
		
		return false;
	}
	public static void beefs() {
		while(!beequeue.isEmpty()) {
			bee cur = beequeue.poll();
			int cc = cur.c;
			int cr = cur.r;
			int ct = cur.t;
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				if(nr <0 || nc <0 || nr>=N || nc >=N)continue;
				if(!visited[nr][nc] && copy[nr][nc]==0) {
					visited[nr][nc]=true;
					copy[nr][nc] =ct+1;
					beequeue.add(new bee(nr, nc, ct+1));
				}
			}
		}
		
	}

}
