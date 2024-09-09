package s09.s0909;

import java.io.*;
import java.util.*;

public class BOJ_17281 {
	
	static int N;
	static int[][] res ;
	static int[] order;  // 각 선수들이 타자치는 순서, 타순
	static boolean[] isSelected;
	static int maxScore;
	static boolean[] state;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 이닝 수
		
		res = new int[N][9];  // 각 이닝마다 선수들의 결과
		for(int r=0;r<N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0;c<9;c++) {
				res[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[9];
		order = new int[9];
		order[3] = 0; // 1번 선수를 4번 타자로 결정
		isSelected[0] = true;
		maxScore = 0;
		perm(0);
		
		System.out.println(maxScore);
	}
	
	// 순열로 타순 결정
	static void perm(int cnt) {
		if(cnt==9) {
			maxScore = Math.max(maxScore, game());
			return;
		}
		if(cnt==3) {
			perm(cnt+1);
			return;
		}
		for(int i=1;i<9;i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				order[cnt] = i;
				perm(cnt+1);
				isSelected[i] = false;
			}
			
		}
	}
	static int game() {
		int scoreSum=0;
		int startPlayer=0;
		for(int i=0;i<N;i++) {
			int outCnt=0;
			state = new boolean[3];
			while(outCnt<3) {
				int result = res[i][order[startPlayer]];
				if(result==0) {
					outCnt++;
				}
				if(result==1) {
					scoreSum += move(1);
				}
				if(result ==2) {
					scoreSum += move(2);
				}
				if(result==3) {
					scoreSum += move(3);
				}
				if(result==4) {
					scoreSum += move(4)+1;
				}
				startPlayer = (startPlayer+1) % 9;
			}
		}
		return scoreSum;
	}
	static int move(int loc) {
		int score=0;
		if(loc==4) {
			for(int i=2;i>=0;i--) {
				if(state[i]) {
					score++;
					state[i] = false;
				}
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
				}
				state[i] = false;
			}
			state[loc-1] = true;
		}
		return score;
	}

}
