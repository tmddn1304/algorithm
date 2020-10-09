package programmers;

public class 나라124 {
	public static class Solution {
	    public String solution(int n) {
	        String answer = "";
	        StringBuffer sb = new StringBuffer();
	         
	        boolean check = false;
	        while(n >2) {
	        	int r = n%3;
	        	if(r==0) {
	        		r=4;
	        		check =true;
	        	}
	        	
	        	sb.append(r);
	        	if(check) {
	        		n = n/3 -1;
	        		check =false;
	        	}
	        	else 
	        	n = n/3;
	        }
	        if(n!=0)
	        sb.append(n);
	        
	        answer  = sb.reverse().toString();

	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 12;
		System.out.println(sol.solution(n));
	}
}
