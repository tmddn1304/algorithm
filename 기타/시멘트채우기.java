package nhn;

import java.util.Arrays;

public class Solution2 {
	public static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int ans = 0;
		int[] pre = new int[blocks[0].length];
		for (int[] block : blocks) {
			System.out.println("현재 블록의 값은"+Arrays.toString(block));
			for(int i=0; i<block.length; i++) {
				block[i] += pre[i];
			}
			System.out.println("이전과 합친 블록의 값은"+Arrays.toString(block));
			
			
			int left = 0;
			int right = 0;
			
			for (int i = 1; i < block.length - 1; i++) {
				left = 0;
				right = 0;
				for (int j = i - 1; j >= 0; j--) { // 왼쪽
					left = Math.max(left, block[j]);
				}
				for (int j = i + 1; j < block.length; j++) { // 오른쪽
					right = Math.max(right, block[j]);
				}
				if (Math.min(right, left) - block[i] > 0) {
					ans += Math.min(right, left) - block[i];
					block[i] = Math.min(right, left);
					
				}
			}
			System.out.println(Arrays.toString(block));
			for(int i=0; i<block.length; i++) {
				pre[i] = block[i];
			}
			System.out.println("더한 블록의 값은"+Arrays.toString(pre));
			System.out.println(ans);

		}
	}

	public static void main(String[] args) {
		int day =3;
		int width =10;
		int[][] blocks = {{6,12,0,2,8,4,0,7,3,6},
		{6, 1, 3, 0, 2, 8, 0, 0, 13, 8},
		{6, 3, 0, 10, 6, 5, 7, 0, 0, 3}};
//		int day = 2;
//		int width = 6;
//		int[][] blocks = { { 6, 2, 11, 0, 3, 5 }, { 6, 3, 0, 9, 0, 5 } };

		solution(day, width, blocks);
	}

}
