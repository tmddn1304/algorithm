import java.io.*;
import java.util.*;
public class Main {
    public static class pair {
        int r;
        int c;
        public pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<pair> queue = new LinkedList<>();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int answer =0;
            if (w == 0 && h == 0)break;
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            
            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
            int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        visited[r][c] =true;
                        answer++;
                        queue.add(new pair(r, c));
                        while (!queue.isEmpty()) {
                            pair cur = queue.poll();
                            int cr = cur.r;
                            int cc = cur.c;
                            for (int i = 0; i < 8; i++) {
                                int nr = cr + dr[i];
                                int nc = cc + dc[i];
                                if (nr < 0 || nc < 0 || nr >= h || nc >= w)continue;
                                if (map[nr][nc]==1 && !visited[nr][nc]) {
//                                	System.out.println(map[nr][nc]);
                                    visited[nr][nc] = true;
                                    queue.add(new pair(nr, nc));
                                }
                            }
                        }
                        
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
