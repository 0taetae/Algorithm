package s07.s0716;

import java.util.Scanner;

public class Level9_N4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			int k=0;
			for(int j=1;j<=num;j++) {
				if(num%j==0) {
					k++;
				}
				if(k==2) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
