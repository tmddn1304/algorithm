class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        int cr =-1;
        int cc =0;
        int dir = 0;
        int idx = 1;

        while(n>0){
            cr = cr + dr[dir];
            cc= cc + dc[dir];
            
            if(cr < 0 || cr >=map.length || cc < 0 || cc>=map.length || map[cr][cc]!=0){
                cr = cr - dr[dir];
                cc = cc - dc[dir];
                dir = (dir + 1)%3;
                n--;
                continue;
            }
            map[cr][cc] = idx;
            idx++;
        }
        
        int[] answer = new int[idx-1];
        int Aidx =0;
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map.length; c++){
                // System.out.print(map[r][c]);
                if(map[r][c] !=0){
                    answer[Aidx] = map[r][c];
                    Aidx++;
                }
                else
                    break;
            }
            // System.out.println();
        }
 
        return answer;
    }
}
