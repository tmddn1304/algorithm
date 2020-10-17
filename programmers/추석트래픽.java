import java.util.*;
class Pair{
    double startTime;
    double endTime;
    Pair(double startTime, double endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        LinkedList<Pair> links = new LinkedList();
        
        for(String line : lines){
            String[] str = line.split(" ");
            
            String[] times =str[1].split(":");
            
            
            str[2] = str[2].replace("s" , "");
            double processTime = Double.parseDouble(str[2]);
            
            double endTime = Double.parseDouble(times[0]) * 3600 + Double.parseDouble(times[1]) * 60 + Double.parseDouble(times[2]);
            double startTime = endTime +0.001 - processTime;
            links.add(new Pair(startTime, endTime));
        }
        
        for(int i= 0; i<links.size(); i++){
            int temp=1;
            for(int j=i+1; j<links.size(); j++){
                
                if(links.get(j).startTime < links.get(i).endTime + 1) {
                    temp++;
                }
            }
            if(temp> answer) answer= temp;
        }
        return answer;
    }
}
