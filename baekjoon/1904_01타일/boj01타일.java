package silver;
import java.util.Scanner;

public class boj01타일 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n==0 || n==1 || n==2) {
			System.out.println(n);
			return;
		}
		int[] a = new int[n+1];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		for(int i=3; i<=n; i++)
		{
			a[i] = a[i-1] + a[i-2];
			a[i]%=15746;
		}
		System.out.println(a[n]);
		
	}

}
