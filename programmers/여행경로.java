import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> list;
    public String[] solution(String[][] tickets) {
       
        visited = new boolean[tickets.length];
        list = new ArrayList<String>();
        
        dfs(tickets, 0, "ICN", "ICN");
        Collections.sort(list);
        // for(int i=0; i<list.size(); i++){
        //     System.out.println(list.get(i));
        // }
         String[] answer = list.get(0).split(" ");
        return answer;
    }
    public void dfs(String[][] tickets, int cnt, String trip, String start){
        if(cnt == tickets.length){
            list.add(trip);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets, cnt+1, trip + " " +tickets[i][1], tickets[i][1]);
                visited[i] = false;
            }
        }
        return;
    }
    
}
