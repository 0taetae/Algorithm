package s07.s0713;

import java.util.Scanner;

public class Level3_N4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		int i;
		int sum=0;
		
		for (i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			sum = sum + a*b;
		}
		
		if (sum==x){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
