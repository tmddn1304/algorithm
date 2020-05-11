import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
    static int maxN = -987654321, minN = 987654321;
    static int[] op = new int[4];
    static int[] a = new int [12];
    static int n;
    static void go(int index, int[] use, int total) {
        if (index >= n) {
            maxN = Math.max(maxN, total);
            minN = Math.min(minN, total);
            return;
        }
        if (use[0] < op[0]){
        	use[0]++;
        	go(index+1, use, total + a[index]);
        	use[0]--;
        }
        if (use[1] < op[1]){
        	use[1]++;
        	go(index+1, use, total - a[index]);
        	use[1]--;
        }
        if (use[2] < op[2]){
        	use[2]++;
        	go(index+1, use, total * a[index]);
        	use[2]--;
        }
        if (use[3] < op[3]){
        	use[3]++;
        	go(index+1, use, total / a[index]);
        	use[3]--;
        }
    }
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<4; i++)
        	op[i] = Integer.parseInt(st.nextToken());

        go(1,new int[4],a[0]);
        System.out.println(maxN);
        System.out.println(minN);
    }
}
