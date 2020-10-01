package programmers;

import java.util.Arrays;

public class 주식가격 {
	public static class Solution {

		public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i=0; i<prices.length; i++) {
	        	int turn =0;
	        	for(int j= i+1; j<prices.length; j++) {
	        		if(prices[i] <= prices[j]) {
	        			turn++;
	        			answer[i] = turn;	        			
	        		}
	        		else {
	        			turn++;
	        			answer[i] = turn;	
	        			break;
	        		}
	        	}
	        }
	        return answer;
	    }

	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(prices)));
	}

}
