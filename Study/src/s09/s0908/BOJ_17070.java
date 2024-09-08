package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17070 {
	/*
	파이프를 밀 수 있는 방향 : 동, 남동, 남
	가로 - 동, 남동
	대각선 - 동, 남동, 남 
	세로 - 남동, 남
	처음 : (1,1), (1,2) , 가로
	파이프의 한쪽 끝을 (N,N)로 이동시키는 방법의 개수 
	빈칸은 0, 벽은 1
	 */
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	static int[][] state;
	static int N;
	static int res=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 집의 크기 N
		state = new int[N][N]; // 집의 상태 
		// 주어진 집 상태
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				state[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기 가로 상태
		move(0,1,0);  // 가로방향으로 옮기는 경우
		move(0,1,1);  // 대각선방향으로 옮기는 경우
		
		System.out.println(res);

	}
	// 파이프 옮기기 
	static void move(int r, int c, int dir) {
		
		int x = r + dx[dir];
		int y = c + dy[dir];
		
		// 해당 방향으로 옮길 때 집 범위 벗어나면 리턴
		if(x<0 || y<0 || x>=N || y>=N ) {
			return ;
		}
		// 해당 방향으로 옮길 때 벽이 있으면 리턴
		if(state[x][y]==1) {
			return;
		}
		// 대각선 방향으로 옮길 때, /방향에 벽이 있으면 리턴
		if(dir==1) {
			if(state[r+1][c]==1 || state[r][c+1]==1) {
				return;
			}
		}
		// 도착
		if(x==N-1 && y==N-1) {
			res++;
			return;
		}
		// 가로 방향으로 파이프를 옮긴 경우 
		if(dir==0) {
			move(x,y,0);
			move(x,y,1);
		}
		// 대각선 방향으로 파이프를 옮긴 경우
		else if(dir==1) {
			move(x,y,0);
			move(x,y,1);
			move(x,y,2);
		}
		// 세로 방향으로 파이프를 옮긴 경우
		else if(dir==2) {
			move(x,y,1);
			move(x,y,2);
		}
	}

}
