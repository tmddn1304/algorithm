package pro;

import java.util.Scanner;

public class 전북대학교 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a%2==0)System.out.println("I LOVE CBNU");
		else {

			for(int i=0; i<a; i++) {
				System.out.print('*');
			}
			System.out.println();
			
			int mid=a/2;
			for(int i=0; i<mid; i++) {
				System.out.print(" ");
			}
			System.out.println("*");
			int left= mid-1;
			int right =mid+1;
			while(left>=0) {
				
				for(int i=0; i<left; i++) {
					System.out.print(" ");
				}
				System.out.print("*");
				
				for(int i=left+1; i<right; i++) {
					System.out.print(" ");
				}
				left--;
				right++;
				
				System.out.println("*");
				
			}
		}
		
	}

}
