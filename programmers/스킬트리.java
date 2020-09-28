package programmers;

public class 스킬트리 {
	public static class Solution {
		public int solution(String skill, String[] skill_trees) {
			int answer = 0;
			for(String skillTree : skill_trees) {
				int learningIdx = 0;
				boolean isPossible = true;
				for (char curSkill : skillTree.toCharArray()) {
					int skillIdx = skill.indexOf(curSkill);
					if(skillIdx ==-1) continue;
					else if(skillIdx == learningIdx) {
						learningIdx++;
					}
					else {
						isPossible = false;
						break;
					}
				}
				if(isPossible)answer++;
			}
			return answer;			
		}		
		
	}
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE","CBADF", "AECB", "BDA"};
		
		Solution s = new Solution();
		
		System.out.println(s.solution(skill, skill_trees));
		
	}

}
