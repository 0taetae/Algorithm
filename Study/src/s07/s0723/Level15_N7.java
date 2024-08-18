package s07.s0723;

import java.util.Scanner;

public class Level15_N7 {
	
static boolean Prime(int num) {
		
		if(num==1) return false;
		if(num==2) return true;
		if(num%2==0) return false;
		for(int j=3;j<=Math.sqrt(num);j+=2) {
			if(num%j==0) return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int count=0;
			int N = sc.nextInt();
			if(N==0) break;
			for(int i=N+1;i<=N*2;i++) {
				if(Prime(i)) {
					count++;
				}
				
			}
			System.out.println(count);
			
		}
		

	}

}
