package s07.s0713;

import java.util.Scanner;

public class Level3_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum=0;
		int i;
		for (i=1;i<=n;i++) {
			sum+=i;
		}
		System.out.println(sum);
		

	}

}
