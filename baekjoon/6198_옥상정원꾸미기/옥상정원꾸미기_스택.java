import java.util.*;
public class 옥상정원꾸미기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer>s = new Stack<>();
		int ans =0;
		for(int i=0; i<N; i++) {
			while(!s.isEmpty() && s.peek() <= arr[i]) {
				s.pop();
			}
			s.push(arr[i]);
			ans += s.size() - 1;
		}
		System.out.println(ans);
	}
}
