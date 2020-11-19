import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static int arr[];
	static int maxarr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());//N개의 컴퓨터
		int M = Integer.parseInt(st.nextToken());//M개의 줄
		
		list = new ArrayList[N+1];
		arr = new int[N+1];
		maxarr= new int[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		for(int i=1; i<=N; i++) {
			visited= new boolean[N+1];
			dfs(i);
		}
		Arrays.sort(maxarr);
		
		int max = maxarr[0]*-1;
		for(int i=1; i<=N; i++) {
			if(max == arr[i])
				sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
//		System.out.println(Arrays.toString(arr));
		
	}
	public static void dfs(int start) {
	
		visited[start] =true;
		
	
		for(int i : list[start])
		{
			if(visited[i]==false) {
				arr[i]++;
				maxarr[i]--;
				dfs(i);
			}
			
		}
		
	}

}
