package s0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PipeMove {
	static int[][] home;
	static int N;
	static int count=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N+1][N+1];
		for(int r=1;r<=N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				home[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로: 1, 세로: 2, 대각선: 3 
		dfs(1,2,1);
		System.out.println(count);

	}
	public static void dfs(int r, int c, int dir) {
		if(r>N || c >N || home[r][c]==1) {
			return;
		}
		if(r==N && c==N) {
			count++;
			return;
		}
		
		// 파이프가 가로방향인 경우 
		if(dir==1) {
			// 가로방향으로 이동
			dfs(r,c+1,1);
			// 대각선방향으로 이동 
			dfs(r+1,c+1,3);
		}
		// 파이프가 세로방향인 경우 
		if(dir==2) {
			// 세로방향으로 이동 
			dfs(r+1,c,2);
			// 대각선방향으로 이동 
			dfs(r+1,c+1,3);
		}
		// 파이프가 대각선방향인 경우 
		if(dir==3) {
			// 파이프의 / 대각선도 1이 벽이 아니어야 함 
			if(home[r][c-1]==1 || home[r-1][c]==1) {
				return;
			}
			// 가로방향으로 이동
			dfs(r,c+1,1);
			// 세로방향으로 이동
			dfs(r+1,c,2);
			// 대각선방향으로 이동 
			dfs(r+1,c+1,3);
		}
		
	}

}