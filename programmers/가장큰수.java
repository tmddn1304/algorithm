import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        int i =0;
        
        for(int a : numbers){
            temp[i++] = Integer.toString(a);
        }
        Arrays.sort(temp, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return ((o2 + o1).compareTo(o1 + o2));
			}
		});
        
        // System.out.println(Arrays.toString(temp));
        for(String s : temp){
            sb.append(s);
        }
        
        String answer = sb.toString();
        if(answer.startsWith("0"))
            answer = "0";
        return answer;
    }
}
