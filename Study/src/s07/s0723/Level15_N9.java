package s07.s0723;

import java.util.Scanner;

public class Level15_N9 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count =0;
		for(int i=1;i*i<=N;i++) {
			count++;
		}
		System.out.println(count);
		
	}

}
