package s0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayTurn4 {
	
	static int[][] arr;
	static int[][] turnInfo;
	static int[] isSelected;
	static boolean[] visit;
	static int N, M, K;
	static int res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 행 크기
		M = Integer.parseInt(st.nextToken());  // 배열의 열 크기
		K = Integer.parseInt(st.nextToken());  // 회전 연산의 개수
		
		arr = new int[N+1][M+1];
		turnInfo = new int[K+1][4];
		isSelected = new int[K];
		visit = new boolean[K+1];
		
		for(int r=1; r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=1;r<=K;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=3;c++) {
				turnInfo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MAX_VALUE;
		perm(0,isSelected,visit);
		
		System.out.println(res);
		
		
	}
	
	// 회전정보를 행할 순서를 정하는 순열
	public static void perm(int cnt, int[] isSelected, boolean[] visit ) {
		if(cnt == K) {
			for(int i=0;i<K;i++) {
				turn(turnInfo[isSelected[i]][1], turnInfo[isSelected[i]][2],turnInfo[isSelected[i]][3]);
			}
			int value = check();
			res = Math.min(res, value);
			return;
		}
		for(int i=1;i<=K;i++) {
			if(!visit[i]) {
				visit[i] = true;
				isSelected[cnt] = i;
				perm(cnt+1, isSelected, visit);
				visit[i] = false;
			}
		}
	}
	
	// 배열을 돌림
	public static void turn(int r, int c, int s) {
		
		while(true) {
			if((r-s == r+s) &&(c-s==c+s)) {
				break;
			}
			int temp = arr[r-s][c-s];
			// 위로 옮기기
			for(int i=r-s;i<r+s;i++) {
				arr[r-s][i] = arr[r-s+1][i];
			}
			// 왼쪽으로 옮기기
			for(int i=c-s;i<c+s;i++) {
				arr[r-s][i] = arr[r-s][i+1];
			}
			// 아래로 옮기기
			for(int i=r+s;i>r-s;i--) {
				arr[i][c+s] = arr[i-1][c+s];
			}
			// 오른쪽으로 옮기기
			for(int i=c+s;i>c-s-1;i--) {
				arr[r-s][i] = arr[r-s][i-1];
			}
			arr[r-s][c-s-1] = temp;
			s--;
		}
	}
	
	// 배열을 돌린 결과에서 행의 합 -> 최솟값
	public static int check() {
		int result = Integer.MAX_VALUE;
		for(int c=1;c<=M;c++) {
			int sum=0;
			for(int r=1;r<=N;r++) {
				sum += arr[r][c];
			}
			result = Math.min(result, sum);
		}
		return result;
	}
}
