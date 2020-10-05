package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
	public static class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        
	        Queue<Integer> proQ  = new LinkedList<Integer>();
	        Queue<Integer> spQ = new LinkedList<>();
	        LinkedList<Integer> ans = new LinkedList<>();
	        
	        for(int pro : progresses)
	        	proQ.add(pro);
	        for(int speed : speeds)
	        	spQ.add(speed);
	        
	        int day=0;
	        while(!proQ.isEmpty()) {
	        	int pro = proQ.poll();
	        	int speed = spQ.poll();
	        	
	        	int chk =0;
	        	
	        	while(true){
//	        		System.out.print(pro + " , " + speed + " , " + day + ";; ");
	        		
	        		if(pro + (speed * day) < 100) {
	        			day++;
	        			chk++;
	        		}
	        		else {
//	        			System.out.println("size is = "+ ans.size() + " chk : " + chk);
	        			if(chk>0 || ans.size() == 0) {
	        				ans.add(1);
//	        				for(int an : ans) {
//	        					System.out.print(an + " ");
//	        				}
//	        				System.out.println();
	        			}
	        			else {
	        				ans.set(ans.size()-1, ans.get(ans.size()-1)+1);
	        			}
	        			break;
	        		}
	        	}
//	        	System.out.println();
	        }
	        
	        int[] answer = new int[ans.size()];
        	for( int i =0;  i<ans.size(); i++) {
        		answer[i] = ans.get(i);
        	}
        	
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s1= new Solution();
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		// return [2, 1]
		
//		int[] progresses = {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
		// return [1, 3, 2]
		System.out.println(Arrays.toString(s1.solution(progresses, speeds)));
		
	}

}
