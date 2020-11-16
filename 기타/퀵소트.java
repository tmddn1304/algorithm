package prac;

import java.util.Arrays;

public class 퀵소트 {
	public static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }

	
	public static void main(String[] args) {
		
		int[] arr = {5,3,7,6,2,1,4,8};
		
		sort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
