import java.util.*;

public class 행운의문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] c = str.toCharArray();
		Arrays.sort(c);
		ans=0;
		use = new boolean[str.length()];

		set = new HashSet<>();
		perm(0,c,new char[str.length()]);
		System.out.println(set.size());
	}

	static boolean[] use;
	static int ans;
	static Set<String> set;
	public static void perm(int idx, char[] arr, char[] sel) {
		if(idx > arr.length-1) {
			for(int i=0; i<arr.length-1; i++) {
				if(sel[i] == sel[i+1]) return;
			}
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<arr.length; i++) {
				sb.append(sel[i]);
			}
			set.add(sb.toString());
			
			return;
		}
		
		
		for(int i=0; i<arr.length; i++) {
			if(!use[i]) {
				use[i]= true;
				sel[idx] = arr[i];
				perm(idx+1, arr, sel);
				use[i]= false;
			}
		}
	}

}
