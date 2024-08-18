package s07.s0713;

import java.util.Scanner;

public class Level3_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int i;
		
		if (N%4==0) {
			for (i=1;i<=(N/4);i++) {
				System.out.print("long ");
			}
			System.out.print("int");
		}
		else {
			for (i=1;i<=(N/4+1);i++) {
				System.out.print("long ");
			}
			System.out.print("int");
		}

	}

}
