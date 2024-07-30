package s0713;

import java.util.Scanner;

public class Level5_N10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int sum=0;
		for(int i=0;i<S.length();i++) {
			char A = S.charAt(i);
			if((A=='A')||(A=='B')||(A=='C')) {
				sum+=3;
			}
			else if((A=='D')||(A=='E')||(A=='F')) {
				sum+=4;
			}
			else if((A=='G')||(A=='H')||(A=='I')) {
				sum+=5;
			}
			else if((A=='J')||(A=='K')||(A=='L')) {
				sum+=6;
			}
			else if((A=='M')||(A=='N')||(A=='O')) {
				sum+=7;
			}
			else if((A=='P')||(A=='Q')||(A=='R')||(A=='S')) {
				sum+=8;
			}
			else if((A=='T')||(A=='U')||(A=='V')) {
				sum+=9;
			}
			else {
				sum+=10;
			}
		}
		System.out.println(sum);

	}

}
