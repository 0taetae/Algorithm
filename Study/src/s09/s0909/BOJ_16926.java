package s09.s0909;

import java.io.*;
import java.util.*;

public class BOJ_16926 {
	
	static int N,M,R;
	static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R;i++) {
			turn();
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					System.out.print(arr[r][c]+" ");
				}
				System.out.println();
			}
		}
		
		
	}
	// 시계 반대방향 회전
	static void turn() {
		int idx = 0;
		int a = 0;
		int b = N-1;
		while(true) {
			if((a+idx)==(b-idx)) break;
			int temp = arr[idx][idx];
			System.out.println("temp "+temp);
			//왼쪽으로
			for(int c=a+idx;c<b-idx;c++) {
				arr[0][c] = arr[0][c+1];
			}
			// 위쪽으로
			for(int r=a+idx;r<b-idx;r++) {
				arr[r][N-1] = arr[r+1][N-1];
			}
			// 오른쪽으로
			for(int c=b-idx;c>a+idx;c--) {
				arr[N-1][c] = arr[N-1][c-1];
			}
			// 아래쪽으로
			for(int r=b-idx;r>a+idx;r--) {
				arr[r][0] = arr[r-1][0];
			}
			arr[idx+1][idx] = temp;
			idx++;
		}
		
		
		
	}

}
