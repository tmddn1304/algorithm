import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int ans = 0;
		
		if(s.length()<3) ans = N;
		else {
			ans=99;
			for(int i=100; i<=N; i++) {
				if(i==1000) continue;
				int h = i/100;
				int t = i%100/10;
				int o = i%100%10;
				
				if((t-o) == (h-t))
					ans++;
			}
		}
		System.out.println(ans);
	}
}
