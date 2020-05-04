import java.io.*;
import java.util.*;

public class 좌표정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		pair[] arr = new pair[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i].x).append(" ").append(arr[i].y).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
	public static class pair implements Comparable<pair> {
		int x,y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			if(this.x > o.x) {
				return 1;
			}
			else if(this.x == o.x) {
	            if(this.y > o.y) {
	                return 1;
	            }
	        }
			return -1;
		}
	}
}
