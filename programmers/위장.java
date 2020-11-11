import java.util.*;
class Solution {
   public int solution(String[][] clothes) {
			int answer = 1;
			Map<String, Integer> map = new HashMap();

			for (int i = 0; i < clothes.length; i++) {
					map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
			}
			
			for(int i : map.values()) {
				answer *= i + 1;
			}
			answer--;
			return answer;
		}
	}
