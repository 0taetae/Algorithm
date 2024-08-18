package s07.s0723;

import java.util.Scanner;


public class Level15_N6 {
	
	static int Prime(int num) {
		
		if(num==1) return 0;
		if(num==2) return 1;
		if(num%2==0) return 0;
		for(int j=3;j<=Math.sqrt(num);j+=2) {
			if(num%j==0) return 0;
		}
		return num;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i=N;i<=M;i++) {
			if(Prime(i)==0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
