package programmers;

import java.util.HashMap;

public class 단어변환 {
	public static class Solution {
		static HashMap<String, Boolean> map;
		static int answer = 987654321;
	    public int solution(String begin, String target, String[] words) {
	        map = new HashMap<>();
	        for(int i=0; i<words.length; i++) {
	        	map.put(words[i], false);
	        }
	        DFS(begin, target, words, map, 0);
	        answer = (answer == 987654321)? 0 : answer;
	        return answer;
	    }
	    
	    
	    public static void DFS(String begin, String target, String[] words,HashMap<String, Boolean> map,int cnt) {
	    	
	    	//vist체크
	    	if(map.containsKey(begin)) {
	    		if(map.get(begin)) {
	    			
	    			return;
	    		}
	    	}
	    	
//	    	System.out.println(begin + " : " + cnt);
	    	map.replace(begin, true);
	    	//같은케이스를 찾음
	    	if(begin.equals(target) ) {
	    		System.out.println(begin +"," +target + ": " + cnt + "::::" + answer);
	    		if(answer > cnt)
	    			answer=cnt;
	    		return;
	    	}
	    	
	    	
	    	for(String word : map.keySet()) {
	    		if(word.equals(begin)) {
	    			continue;
	    		}
	    		
	    		int eq =0;
	    		for(int i=0; i<word.length(); i++) {
	    			if(begin.charAt(i) == word.charAt(i))eq++;
	    		}
	    		if(eq ==word.length()-1) {
//	    			System.out.println("---------재귀-----------");
//	    			System.out.println(begin + " : " + cnt);
//	    			System.out.println("----------------------");
	    			DFS(word, target, words, map, cnt+1);
	    		}
	    		
	    	}
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		String begin="hit";
		String target="cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(sol.solution(begin, target, words));
	}

}
