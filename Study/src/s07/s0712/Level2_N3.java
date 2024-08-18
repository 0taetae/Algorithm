package s07.s0712;

import java.util.Scanner;

public class Level2_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		
		if ((A%4==0)&&(A%100!=0)||(A%400==0)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}

	}

}
