package s07.s0714;

import java.util.Scanner;

public class Level7_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15];
		
		for(int i=0;i<5;i++) {
			String S = sc.nextLine();
			for(int j=0;j<S.length();j++) {
				arr[i][j] = S.charAt(j);
			}
		}
		for(int j=0;j<arr[0].length;j++) {
			for(int i=0;i<5;i++) {
				if(arr[i][j]==0) {
					continue;
				}
				System.out.print(arr[i][j]+"");
			}
		}
		
		sc.close();

	}

}
