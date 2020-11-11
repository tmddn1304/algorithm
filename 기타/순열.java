package 순열조합;

import java.util.Arrays;

public class Perm {
	static boolean use[];
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		use = new boolean[6];
		Perm(0,3,new int[6], arr);
		
	}

	private static void Perm(int idx, int limit, int[] sel,int[] arr) {
		if(idx >=limit) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!use[i]) {
				use[i] = true;
				sel[idx] = arr[i];
				Perm(idx+1, limit, sel, arr);
				use[i]= false;
			}
		}
		
	}

}
