import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        
	        for(int i=0; i<scoville.length; i++) {	        	
	        	pq.add(scoville[i]);
	        }
	        while(pq.peek() < K && pq.size() > 1) {
	        	Integer first = pq.poll();
	        	Integer second = pq.poll();
	        	
	        	int p = first + (2*second);
	        	pq.add(p);
	        	answer++;
	        }
	        
	        if(pq.isEmpty() || pq.peek() < K)
	        	answer= -1;
            
        return answer;
    }
}
