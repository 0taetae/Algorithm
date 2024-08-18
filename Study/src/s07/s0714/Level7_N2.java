package s07.s0714;

import java.util.Scanner;

public class Level7_N2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int a = sc.nextInt();
				arr[i][j] = a;
			}
		}
		int max = 0;
		int maxi = 1;
		int maxj = 1;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(max<arr[i][j]) {
					max = arr[i][j];
					maxi = i+1;
					maxj = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.print(maxi+" "+maxj);
		sc.close();

	}

}
