package s0713;

import java.util.Scanner;

public class Level3_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int i;
		
		for (i=1;i<10;i++) {
			System.out.println(N + " * " + i +" = "+(N*i));
		}

	}

}
