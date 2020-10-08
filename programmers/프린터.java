package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static class Pair{
		int idx;
		int num;
		public Pair(int idx, int num) {
			// TODO Auto-generated constructor stub
			this.idx = idx;
			this.num = num;
		}
	}
	public static class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Pair> queue = new LinkedList<Pair>();
	        
	        for(int i=0; i<priorities.length; i++) {
	        	queue.add(new Pair(i, priorities[i]));
	        }
	        int [] sortArr = priorities;
	        Arrays.sort(sortArr);
	        
	       loop: for(int i=priorities.length-1; i>=0; i--) {
	        	while(true) {
	        		Pair front = queue.poll();
		        	
		        	if(front.num == sortArr[i]) {
		        		answer++;
		        		if(location == front.idx) {
		        			 break loop; 
		        		}
		        		break;
		        	}
		        	else {
		        		queue.add(new Pair(front.idx, front.num));
		        	}
	        	}
	        	
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		
//		int[] priorities = {2, 1, 3, 2};
//		int location =2;
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location =0;
		System.out.println(s.solution(priorities, location));
	}

}
