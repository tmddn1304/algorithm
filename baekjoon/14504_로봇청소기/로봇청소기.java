import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int[][] map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		
		
		
		int cleanRoom =0;
		while(true) {
			int rotateCnt=0;
			
			//현재 위치를 청소함
			if(map[robot.r][robot.c] <3)
				cleanRoom++;
			map[robot.r][robot.c] = 3;
			
			//2페이즈 시작
			//네번 회전시키면서 탐색할 예정
			int cr = robot.r;
			int cc = robot.c;
			
			for(int i=0; i<4; i++) {
				robot.dir = (robot.dir -1 + 4)%4;
				
				rotateCnt++;
				int nr = cr + dir[robot.dir][0];
				int nc = cc + dir[robot.dir][1];
				if(map[nr][nc] ==0) {
					robot.r = nr;
					robot.c = nc;
					rotateCnt=0;
					break;
				}
			}
			//청소를 못했을경우
			if(rotateCnt >=4) {
				//후진 해보자
				int nr = cr - dir[robot.dir][0];
				int nc = cc - dir[robot.dir][1];
				
				//벽이여서 후진을 못함
				if(map[nr][nc]==1) {
					break;
				}
				//벽이 아니여서 후진을 함
				else {
					robot.r = nr;
					robot.c = nc;
				}
			}
			
		}
		System.out.println(cleanRoom);
		
		
	}
	public static class Robot {
		int r, c, dir;

		public Robot(int r, int c,int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	

}
