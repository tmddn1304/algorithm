import java.io.*;
import java.util.*;

public class 체스판다시칠하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] input = new String[N];
        for(int i = 0; i < N; i++){
            input[i] = br.readLine();
        }

        
        String[] map = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", 
                "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
        
        int ans = 987654321;
        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int cnt = 0;
                for(int k = 0; k < 8; k++){
                    //계산을 진행 할 위치의 값들을 임시로 받아옴
                    String temp = input[i + k].substring(j, j + 8);
                    for(int l = 0; l < 8; l++){
                        if(temp.charAt(l) == map[k].charAt(l)){
                            cnt++;
                        }
                    }
                }
                if(cnt >= 32) cnt = 64 - cnt;
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
      
    }
}
