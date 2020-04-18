package silver;

import java.io.*;
import java.util.*; 
public class 정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
 
        StringTokenizer st;
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j=0 ; j<i+1 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<i+1 ; j++){
                arr[i][j] += Math.max((j==0) ? 0 : arr[i-1][j-1], arr[i-1][j]);
            }
        }
 
        Arrays.sort(arr[n-1]);
        System.out.println(arr[n-1][n-1]);
    }
}
