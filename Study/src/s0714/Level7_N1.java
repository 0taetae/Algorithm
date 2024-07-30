package s0714;

import java.util.Scanner;

public class Level7_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int a = sc.nextInt();
				arr1[i][j]=a;
			}
		}
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int b = sc.nextInt();
				arr2[i][j]=b;
			}
		}
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int ans = arr1[i][j]+arr2[i][j];
				System.out.print(ans+" ");
			}
			System.out.println();
		}
		
		sc.close();
		

	}

}
