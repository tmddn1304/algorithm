package prac;

import java.util.Arrays;

public class 퀵소트 {
	public static void sort(int[] arr, int l, int r){
		int i, j, pivot, tmp;

		if (r <= l)
			return;

		i = l;
		j = r;
		pivot = arr[r];
		while (i < j) {
			while (arr[i] < pivot)
				i++;
			while (i < j && arr[j] >= pivot)
				j--;

			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		arr[r] = arr[i];
		arr[i] = pivot;

		sort(arr, l, i - 1);
		sort(arr, i + 1, r);
	}

	
	public static void main(String[] args) {
		
		int[] arr = {5,3,7,6,2,1,4,8};
		
		sort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
