import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String start = s.substring(0,i);
            String next = "";
            StringBuilder sb =new StringBuilder();
            int same =1;

            for(int j=i; j<s.length(); j=j+i){
                if(j+i > s.length()) 
                {
                    next = s.substring(j,s.length());
                    sb.append(start);
                    continue;
                }
                next = s.substring(j,j+i);
                if(start.equals(next))
                    same++;
                else{
                    if(same > 1){
                    sb.append(same).append(start);
                    }
                    else
                        sb.append(start);
                    start = next;
                    same=1;
                }
            }
            if(same > 1) sb.append(same).append(next);
            else  sb.append(next);
            if(sb.length() < answer) answer = sb.length();

        }
        return answer;
    }
}
