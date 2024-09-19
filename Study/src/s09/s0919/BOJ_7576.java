package s09.s0919;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
	
	static int N,M;
	static int[][] box;
	
	// 익은 토마토 큐에 넣기, 익지 않은 토마토가 4방향에 있으면 익은 토마토로 바꾸고 큐에 넣기
	// 토마토가 들어있지 않은 칸은 넘기기
	// 익은 토마토를 큐에 넣을 때 넣은 개수 세기, 해당 큐를 다 빼면 -> 날짜 세기

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		int firstCnt=0;
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				int state =  Integer.parseInt(st.nextToken());
				box[r][c] = state;
				if(state==1) {
					
				}
			}
		}

	}

}
