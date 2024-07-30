package s0714;

import java.util.Scanner;

public class Level8_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int B = sc.nextInt();
		int sum=0;
		for(int i=0;i<N.length();i++) {
			int num=1;
			for(int j=0;j<=i-1;j++) {
				num = num*B;
			}
			int a = N.charAt(N.length()-1-i);
			if((a>=65)&&(a<=90)) {
				sum = sum + (a-65+10)*num;
			}
			else if ((48<=a)&&(a<=57)){
				sum = sum + (a-48)*num;
			}
		}
		System.out.println(sum);
		
		sc.close();
		

	}

}
