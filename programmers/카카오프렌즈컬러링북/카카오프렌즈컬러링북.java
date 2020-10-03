package programmers;

import java.util.Arrays;

public class 카카오프렌즈컬러링북 {
	public static class Solution {
		int[][] pic;
	    public int[] solution(int m, int n, int[][] picture) {
	        pic = picture;
	    	int numberOfArea = 0;
	       
//	        for(int r =0; r<m; r++) {
//	        	for(int c =0; c<n; c++) {
//	        		System.out.print(picture[r][c]);
//	        	}
//	        	System.out.println();
//	        }
	        
	        for(int r =0; r<m; r++) {
	        	for(int c =0; c<n; c++) {
	        		if(pic[r][c] > 0) {
	        			numberOfArea++;
		        		cnt=1;
	        			DFS(m, n, c, r, pic, pic[r][c]);	        		
	        		}
	        	}
	        }
	        
	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        
//	        for(int r =0; r<m; r++) {
//	        	for(int c =0; c<n; c++) {
//
//	        		System.out.print(picture[r][c]);
//	        	}
//	        	System.out.println();
//	        }
	        
	        return answer;
	       
	    }
	    static int[] dx = {-1,1,0,0};
	    static int[] dy = {0,0,-1,1};
	    static int maxSizeOfOneArea = 0;
	    static int cnt =0 ;
	    
	    public static void DFS(int m, int n, int cc, int cr, int[][] picture, int co) {
//	    	System.out.println(cnt);
	    	picture[cr][cc] = -1;
	    	
	    	for(int i=0; i<4; i++) {
	    		int nr = cr + dy[i];
	    		int nc = cc + dx[i];
	    		
	    		if(nc >= 0 && nr >= 0 && nc <n && nr < m) {
	    			if(picture[nr][nc] <= 0 || co != picture[nr][nc]) {
	    	    		continue;
	    	    	}
	    	    	cnt++;
	    			DFS(m, n, nc, nr, picture ,co);
	    			if(cnt > maxSizeOfOneArea) {
	    				maxSizeOfOneArea =cnt;
	    			}
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		int m = 6; 
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, 
				{1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(m, n, picture)));
	}

}
