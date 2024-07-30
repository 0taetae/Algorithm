package s0727;

import java.util.Scanner;

public class OneTwoThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			
			System.out.println(f(n));
		}
	}
	static int f(int n){
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		
		return f(n-1)+f(n-2)+f(n-3);
		
	}

}
