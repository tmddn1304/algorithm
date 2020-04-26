import java.util.*;
import java.io.*;
public class Main {
	static int[][] map = new int[101][101];
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][][] visited = new boolean[5][101][101];
	static Robot start, end;
	static int m, n;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    m = Integer.parseInt(st.nextToken());
	    n = Integer.parseInt(st.nextToken());
	 
	    for (int i = 1; i <= m; i++) {
	    	st = new StringTokenizer(br.readLine());
	        for (int j = 1; j <= n; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    st = new StringTokenizer(br.readLine());
	    int sr = Integer.parseInt(st.nextToken());
	    int sc = Integer.parseInt(st.nextToken());
	    int sdir = Integer.parseInt(st.nextToken());
	 
	    st = new StringTokenizer(br.readLine());
	    int er = Integer.parseInt(st.nextToken());
	    int ec = Integer.parseInt(st.nextToken());
	    int edir = Integer.parseInt(st.nextToken());
	    visited[sdir][sr][sc] = true;
	    start = new Robot(sr, sc, sdir, 0);
	    end = new Robot(er, ec, edir, 0);
	 
	    bfs();
	}
	 
	public static void bfs() {
	    Queue<Robot> q = new LinkedList<>();
	    q.add(start);
	 
	    while (!q.isEmpty()) {
	        Robot pos = q.poll();
	        int d = pos.d;
	        int cnt = pos.cnt;
	        int r = pos.r;
	        int c = pos.c;
	 
	        if (r == end.r && c == end.c && d == end.d) {
	            System.out.println(cnt);
	            return;
	        }

	        for (int i = 1; i <= 3; i++) {
	            int nc = (dc[d - 1] * i) + c;
	            int nr = (dr[d - 1] * i) + r;
	 
	            if (0 < nc && nc <= n && 0 < nr && nr <= m) {
	                if (map[nr][nc] == 0) {
	                    if (!visited[d][nr][nc]) {
	                    	visited[d][nr][nc] = true;
	                        q.add(new Robot(nr, nc, d, cnt + 1));
	                    }
	                } else {
	                    break;
	                }
	            }
	        }
	 
	        for (int i = 1; i <= 4; i++) {
	            if (d != i && !visited[i][r][c]) {
	                int add = 1;
	                if (d == 1) {
	                    if (i == 2) add++;
	                } else if (d == 2) {
	                    if (i == 1) add++;
	                } else if (d == 3) {
	                    if (i == 4) add++;
	                } else {
	                    if (i == 3) add++;
	                }
	                visited[i][r][c] = true;
	                q.add(new Robot(r, c, i, cnt + add));
	            }
	        }
	    }
	}
	 
	public static class Robot {
	    int r;
	    int c;
	    int d;
	    int cnt;
	 
	    Robot(int r, int c, int d, int cnt) {
	        this.r = r;
	        this.c = c;
	        this.d = d;
	        this.cnt = cnt;
	    }
	}
}
