package s07.s0714;

import java.util.Scanner;

public class Level7_N4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[100][100];
		for(int i=0;i<T;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int n=a;n<a+10;n++) {
				for(int m=b;m<b+10;m++) {
					arr[n][m]=1;
				}
			}
		}
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);

	}

}
