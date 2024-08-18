package s07.s0714;

import java.util.Scanner;

public class Level8_N2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		String n ="";
		int num = 0;
		char ch;
		while(true) {
			num = N%B;
			if (num>=10) {
				ch = (char) (num-10+'A');
			}
			else {
				ch = (char) (num + '0');
			}
			n = ch + n;
			N = N/B;
			if(N==0) {
				break;
			}
		}
		System.out.println(n);
		sc.close();

	}

}
