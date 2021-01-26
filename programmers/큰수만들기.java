import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int size = number.length() - k;
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<number.length(); i++){
            int curNum = number.charAt(i) - '0';
            if(stack.isEmpty())
                stack.push(curNum);
            else{
                while(!stack.isEmpty() && stack.peek() < curNum && k>0)
                {
                    stack.pop();
                    k--;
                }
                // System.out.println(stack.size()+","+number.length());
                if(stack.size() < size)
                    stack.push(curNum);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        answer = sb.reverse().toString();
        
        
        return answer;
    }
}
