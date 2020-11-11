package 순열조합;

import java.util.Arrays;

public class comb {
	static boolean use[];
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		use = new boolean[6];
		comb(0, 0,3, new int[6], arr);
	}

	private static void comb(int idx, int sel_idx,int limit, int[] sel, int[] arr) {
		if(sel_idx>=limit) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx >=arr.length)
			return;

		//재귀를 통한 구현
//		sel[sel_idx] = arr[idx];
//		comb(idx+1, sel_idx+1, limit, sel, arr);
//		comb(idx+1, sel_idx, limit, sel, arr);
		
		//for문을 통한 구현
		for(int i=idx; i<arr.length; i++) {
			if(!use[i])
			{
				use[i] = true;
				sel[sel_idx] = arr[i];
				comb(i, sel_idx+1, limit, sel, arr);
				use[i]= false;
			}
			
		}

		
	}

}
