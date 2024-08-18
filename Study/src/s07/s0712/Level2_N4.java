package s07.s0712;

import java.util.Scanner;

public class Level2_N4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if ((A>0)&&(B>0)) {
			System.out.println(1);
		}
		else if ((A>0)&&(B<0)) {
			System.out.println(4);
		}
		else if ((A<0)&&(B>0)) {
			System.out.println(2);
		}
		else if ((A<0)&&(B<0)) {
			System.out.println(3);
		}

	}

}
