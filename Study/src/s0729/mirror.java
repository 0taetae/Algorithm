package s0729;

import java.util.Scanner;

public class mirror {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N+2][M+2];
		int[] result = new int[2*N+2*M];
		for(int i=1; i<=N-1;i++) {
			for(int j=1;j<=M-1;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<(2*N+2*M)/2;i++) {  // 2N+2M 개의 구멍 중에 반만, 나머진 대칭으로 확인 안해도될듯...?
		
		}
		for(int i=1;i<=N;i++) {
			
		}
		
	}

}
