package gold;

import java.io.*;
import java.util.*;

public class 뱀 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//맵의크기
		int K = Integer.parseInt(br.readLine());//사과의 수

		int [][] map = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st =new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		
		int L =Integer.parseInt(br.readLine());//뱀의 방향변환수
		command[] arr = new command[L];
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			arr[i] = new command(sc, cmd);
		}
						//오 하  좌 상
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int cmdline=0;
		int cnt=0;
		
		Snake snake = new Snake(1, 1, 0);
		
		map[snake.r][snake.c] =1;
		
		//0 빈 곳 1 뱀 2사과 
		Queue<Snake> queue = new LinkedList<>();
		while(true) {
			
			if(cmdline < L && arr[cmdline].sc == cnt) {
				//오른쪽
				if(arr[cmdline].cmd == 'D')snake.dir= (snake.dir+1)%4;
				//왼쪽
				else snake.dir = (snake.dir-1 + 4)%4;
				
				cmdline++;
			}
			//꼬리 위치 기록
			queue.add(new Snake(snake.r, snake.c, snake.dir));
			
			
			
			int nr = snake.r + dir[snake.dir][0];
			int nc = snake.c + dir[snake.dir][1];
			
			
			if(nr<1 || nc<1 || nr > N || nc > N || map[nr][nc]==1) {
				System.out.println(cnt+1);
				break;
			}
			
			
			//사과가 있을경우
			if(map[nr][nc] == 2) {
				map[nr][nc]=1;
			}
			//사과가 없을경우
			else {
				//맨 뒤꼬리부터 삭제시켜줌
				Snake pos = queue.poll();
				map[pos.r][pos.c] =0;
				map[nr][nc] =1;
			}
			snake.r = nr;
			snake.c = nc;
			cnt++;
			
		}		
	}
	public static class Snake{
		int r,c, dir; 
		public Snake(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir= dir;
		}
	}
	public static class command{
		int sc;
		char cmd;
		public command(int sc, char cmd) {
			this.sc = sc;
			this.cmd = cmd;
		}
		
	}

}
