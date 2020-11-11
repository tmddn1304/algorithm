import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
         boolean answer = true;
	        Arrays.sort(phone_book);
	        for(int start=0; start<phone_book.length-1; start++) {
	        	for(int cur = start+1; cur<phone_book.length; cur++) {
	        		if(phone_book[cur].startsWith(phone_book[start]))
	        			return false;
	        	}
	        }
	        
	        return answer;
	    }
}
