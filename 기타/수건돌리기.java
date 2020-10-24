package nhn;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	public static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
	    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		//플레이어의 자리
		People[] arr = new People[numOfAllPlayers-1];

		int c = 65;
		
		//answer
		//자리배정 b부터 배정
		for(int i=0; i<numOfAllPlayers-1; i++) {
			c++;
			arr[i] = new People((char) c, i,0);
		}
		Queue<People> queue =new LinkedList<>();
		queue.add(new People('A', 0, 1));
		
		int cnt=0;
		while(numOfGames > cnt) {
			People poll = queue.poll();
			//수건을 놓을 장소로 이동
			System.out.println(poll.seat + "," + numOfMovesPerGame[cnt]);
			poll.seat =(poll.seat + numOfMovesPerGame[cnt])%(numOfAllPlayers-1);
			if(poll.seat <0) {
				poll.seat = numOfAllPlayers-1 + poll.seat;
			}
			//못잡는 사람인지 체크
			boolean flag = false;
			for(int j=0; j<numOfQuickPlayers; j++) {
				//못잡는 사람이면 그 사람 그대로 자리만 옮기고 술래 횟수+1
				if(arr[poll.seat].name==namesOfQuickPlayers[j]) {
					queue.add(new People(poll.name, poll.seat, poll.cnt +1));
					flag = true;
					break;
				}
			}
			//잡을수 있는 사람이면
			if(!flag) {
				queue.add(new People(arr[poll.seat].name, arr[poll.seat].seat, arr[poll.seat].cnt+1));
				arr[poll.seat] = new People(poll.name, poll.seat, poll.cnt);
			}
			
			cnt++;
		}
		
		for(int i=0; i<numOfAllPlayers-1; i++) {
			System.out.println(arr[i].name + " " + arr[i].cnt);
		}
		System.out.println(queue.peek().name + " " + queue.peek().cnt);
		
		
	  }
	public static class People{
		char name;
		int seat;
		int cnt;
		public People(char name, int seat,int cnt) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.seat = seat;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		
		
//		6
//		2
//		B C
//		2
//		3 -2
		
//		B 0
//		C 0
//		D 0
//		A 1
//		F 0
//		E 2
		
//		
		
//		B 0
//		C 0
//		D 0
//		L 1
//		Q 1
//		A 3
//		F 2
//		I 0
//		J 0
//		G 1
//		K 1
//		M 0
//		N 0
//		H 1
//		P 0
//		E 1
//		O 1
		
//		17
//		5
//		B D I M P
//		11
//		3 -4 5 6 -7 -8 10 -12 -15 -20 23
		
//		6
//		2
//		B C
//		2
//		3 -2
		
//		int numOfAllPlayers = 6;
//		int numOfQuickPlayers = 2;
//		char[] namesOfQuickPlayers = {'B','C'};
//		int numOfGames =2;
//		int[] numOfMovesPerGame = {3, -2};
//		
		int numOfAllPlayers = 17;
		int numOfQuickPlayers = 5;
		char[] namesOfQuickPlayers = {'B','D','I','M','P'};
		int numOfGames =11;
		int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};
		solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);
	}

}
