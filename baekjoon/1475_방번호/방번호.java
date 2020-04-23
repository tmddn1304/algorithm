import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] num = new int[9];
            String str = br.readLine();
            for(int i =0; i < str.length(); i++){
                if((str.charAt(i) == '6') || str.charAt(i) == '9') {
                    num[6]++;
                }else {
                    int idx = str.charAt(i)-48;
                    num[idx]++;
                }
            }
            num[6] = (num[6] / 2) + (num[6]%2);
            int max = num[0];
            for(int i = 1; i < num.length; i++) {
                max = Math.max(max, num[i]);
            }
            System.out.println(max);
         
    }
}
