package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17406 {
	
	/*
	배열의 값은 각 행에 있는 모든 수의 합 중 최솟값
	회전 연산의 수행 순서에 따라 최종 배열이 다름
	회전 연산은 모두 한번씩 사용해야 함
	배열의 값의 최솟값은???
	 */
	static int N, M, K;
	static int[][] arr, turnInfo;
	static int[][] copyarr;  // 배열 원상복구를 위한 배열 
	static boolean[] isSelected;
	static int[] select;
	static int res=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 행의 수
		M = Integer.parseInt(st.nextToken());  // 열의 수
		K = Integer.parseInt(st.nextToken());  // 회전 연산 개수
		
		arr = new int[N+1][M+1];  // 0행, 0열 비우기 
		copyarr = new int[N+1][M+1];
		turnInfo = new int[K+1][3];  // 0행 비우기 
		
		for(int r=1;r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				copyarr[r][c] = arr[r][c];
			}
		}
		for(int r=1;r<=K;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<3;c++) {
				turnInfo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[K+1];  // 선택 여부
		select = new int[K];  // 회전 정보 택한 순서 
		perm(0);
		
		System.out.println(res);

	}
	
	// 회전 연산 수행 순서 정하기 -> 순열
	static void perm(int cnt) {
		if(cnt==K) {
			// 회전정보에 따라 배열 돌리기
			for(int j=0;j<K;j++) {
				turn(turnInfo[select[j]][0], turnInfo[select[j]][1], turnInfo[select[j]][2]);
			}
			// 배열 값 구하기
			cal();
			// 배열 원상복구 
			reset();
			return;
		}
		for(int i=1;i<=K;i++) {
			if(!isSelected[i]) {
				select[cnt] = i;
				isSelected[i] = true;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	// 배열 돌리기 -> 역순으로 옮기기 
	static void turn(int r, int c, int s) {
		while(true) {
			if(r-s==r+s && c-s==c+s) break;
			
			int temp = arr[r-s][c-s];
			// 위로 옮기기
			for(int i=r-s;i<r+s;i++) {
				arr[i][c-s] = arr[i+1][c-s];
			}
			// 왼쪽으로 옮기기
			for(int i=c-s;i<c+s;i++) {
				arr[r+s][i] = arr[r+s][i+1];
			}
			// 아래로 옮기기
			for(int i=r+s;i>r-s;i--) {
				arr[i][c+s] = arr[i-1][c+s];
			}
			// 오른쪽으로 옮기기
			for(int i=c+s;i>c-s+1;i--) {
				arr[r-s][i] = arr[r-s][i-1];
			}
			arr[r-s][c-s+1] = temp;
			s--;
		}
	}
	
	// 배열 값 구하기 - 각 행에 있는 모든 수의 합 중 최솟값 
	static void cal() {
		for(int r=1;r<=N;r++) {
			int sum=0;
			for(int c=1;c<=M;c++) {
				sum+=arr[r][c];
			}
			res = Math.min(res, sum);
		}
	}
	// 배열 초기화 
	static void reset() {
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				arr[r][c] = copyarr[r][c];
			}
		}
	}
}
