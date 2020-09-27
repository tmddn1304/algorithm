package programmers;

public class 네트워크 {
	public static class Solution {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        
	        boolean[] visit = new boolean[n];
	        
	        for(int i=0; i<n; i++) {
	        	if(!visit[i]) {
	        		answer++;
	        		DFS(i, computers, visit);
	        	}
	        }
	        return answer;
	    }
	    public void DFS(int start,int[][] computers,boolean[] visit) {
	    	visit[start] = true;

	    	for(int i=0; i<computers[start].length; i++) {
	    		if(computers[start][i] ==1  && !visit[i]) {	    			
	    			DFS(i, computers, visit);
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int n = 3;	
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(sol.solution(n, computers));
	}

}
