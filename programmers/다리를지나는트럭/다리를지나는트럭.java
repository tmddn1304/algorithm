package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static class Pair{
		int time;
		int weight;
		public Pair(int time, int weight) {
			this.time = time;
			this.weight = weight;
			// TODO Auto-generated constructor stub
		}
	}
	public static class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			int answer = 0;
			Queue<Pair> queue = new LinkedList<Pair>();
			
			int time = 0;
			int curWeight=0;
			for(int i=0; i<truck_weights.length; i++) {
				if(queue.isEmpty()) {
					time++;
					curWeight += truck_weights[i];
					queue.add(new Pair(time, truck_weights[i]));
				}
				else {
					// 7, 4, 5, 6 length =2 weight =10
					// 3 3 8 의 경우를 생각 최대 10
					
					
					//다리 패스를 어떻게하지?
					time++;
					if(bridge_length <= time - queue.peek().time) {
						Pair truck = queue.poll();
						curWeight -= truck.weight;
					}
					curWeight+= truck_weights[i];
					
					if(weight >= curWeight) {	
						queue.add(new Pair(time, truck_weights[i]));
					}
					else {
						while(weight < curWeight) {
							Pair truck = queue.poll();
							curWeight -= truck.weight;
							time = truck.time+bridge_length;
						}
						queue.add(new Pair(time, truck_weights[i]));
					}
				}
				
			}
			if(!queue.isEmpty()) {
				Pair temp;
				while(!queue.isEmpty()) {
					temp = queue.poll();
					 time += bridge_length - (time - temp.time);
				}
			}
			answer = time;

			return answer;
		}
	}


	public static void main(String[] args) {
		Solution s = new Solution();
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = { 7, 4, 5, 6 };
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		System.out.println(s.solution(bridge_length, weight, truck_weights));
	}

}
