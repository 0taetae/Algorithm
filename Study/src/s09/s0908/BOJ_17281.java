package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17281 {
	
	static int N, maxScore, startPlayer, scoreSum;
	static int[][] arr;
	static int[] select = new int[9];
	static boolean[] isSelected = new boolean[9];
	static boolean[] state;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxScore=0;
		select[0] = 3;
		isSelected[3] = true;
		
		perm(1);
		System.out.println(maxScore);

	}
	static void perm(int cnt) {
		if(cnt==9) {
			startPlayer = 0;
			scoreSum=0;
			for(int i=0;i<N;i++) {
				game(i);
			}
			maxScore = Math.max(maxScore,scoreSum);
			return;
		}
		for(int i=0;i<9;i++) {
			if(i==3) continue;
			if(!isSelected[i]) {
				isSelected[i] = true;
				select[cnt] = i;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	static void game(int inning) {
		int outCnt=0;
		state = new boolean[3];
		
		while(outCnt<3) {
			int res = arr[inning][select[startPlayer]];
			if(res==0) {
				outCnt++;
			}
			else if(res==1) {
				scoreSum += move(1);
			}
			else if(res==2) {
				scoreSum += move(2);
			}
			else if(res==3) {
				scoreSum += move(3);
			}
			else if(res==4) {
				scoreSum += move(4)+1;
			}
			startPlayer = (startPlayer + 1)%9;
			
		}
	}
	static int move(int loc) {
		int score=0;
		
		if(loc == 4) {
			if(state[2]) {
				score++;
				state[2] = false;
			}
			if(state[1]) {
				score++;
				state[1] = false;
			}
			if(state[0]) {
				score++;
				state[0] = false;
			}
		}
		else {
			for(int i=2;i>=0;i--) {
				if(state[i]) {
					if(i+loc>=3) {
						score++;
					}
					else {
						state[i+loc] = true;
					}
					state[i] = false;
				}
			}
			state[loc-1] = true;
		}
		return score;
	}

}
