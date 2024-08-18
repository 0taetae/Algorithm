package s07.s0713;

import java.util.Scanner;

public class Level5_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next();
		int sum=0;
		for(int i=0;i<S.length();i++) {
			int k = S.charAt(i)-'0';
			sum+=k;
		}
		System.out.println(sum);

	}

}
