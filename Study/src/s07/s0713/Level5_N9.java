package s07.s0713;

import java.util.Scanner;

public class Level5_N9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		String r1 = new StringBuilder().append(A).reverse().toString();
		String r2 = new StringBuilder().append(B).reverse().toString();
		
		A = Integer.parseInt(r1);
		B = Integer.parseInt(r2);
		
		if(A<B) {
			System.out.println(B);
		}
		else {
			System.out.println(A);
		}
		

	}

}
