import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =  null;
		
		int teacher_y=0;
		int teacher_x=0;
		int student_y=0;
		int student_x=0;
		
		int[][] map = new int [n][n];
		for(int y=0; y<n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<n; x++) {
				int a = Integer.parseInt(st.nextToken());
				map[y][x] = a;
				if(a == 5) {
					teacher_y = y;
					teacher_x = x;
				}
				else if (a == 2) {
					student_y = y;
					student_x = x;					
				}
			}
		}
		double dis = Math.sqrt(Math.pow(teacher_y-student_y, 2) + Math.pow(teacher_x-student_x, 2));
//		System.out.println(dis);
		if(dis <5) {
			System.out.println(0);
		return;
		}
		
		int min_x = Math.min(teacher_x, student_x);
		int max_x = Math.max(teacher_x, student_x);
		int min_y = Math.min(teacher_y, student_y);
		int max_y = Math.max(teacher_y, student_y);
		
		int count = 0;
		for(int x = min_x; x <= max_x; x++) {
			for(int y = min_y; y <= max_y; y++) {
				if(map[y][x] == 1) {
					count++;
				}
			}
		}
		
		if(count > 2) {
			System.out.println("1");
		}
		else System.out.println("0");
		

	}

}
