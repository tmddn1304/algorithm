import java.util.*;
class Solution {
   public int[] solution(String[] gems) {
			int[] answer = { 0, gems.length};
			Map<String, Integer> map = new HashMap<>();
			Set<String> set = new HashSet<>();

			for (String gem : gems) {
				set.add(gem);
			}

			int left = 0;
			int right = 0;
			while (true) {
				if (left == gems.length)break;
				if (map.size() == set.size()) {
					int temp = map.get(gems[left]);
					if (answer[1] - answer[0] > right - left) {
						answer[0] = left;
						answer[1] = right;
					}
					if (temp == 1) {
						map.remove(gems[left]);
						left++;
						
					} else {
						map.put(gems[left], temp - 1);
						left++;
					}
					continue;
				}
				if (right == gems.length)break;
				if (map.size() != set.size()) {
					if (map.containsKey(gems[right])) {
						int temp = map.get(gems[right]);
						map.put(gems[right], temp + 1);
					} else map.put(gems[right], 1);
					right++;
				}
			}
			answer[0] +=1;
			return answer;
		}
	}
