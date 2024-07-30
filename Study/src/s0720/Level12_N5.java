package s0720;

import java.util.Scanner;

public class Level12_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num=665;
		int count=0;
		while(true) {
			num++;
			String str = String.valueOf(num);
			if(str.contains("666")) count++;
			if(N==count) {
				System.out.println(num);
				break;
			}
		}
	}

}
