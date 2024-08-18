package s07.s0717;

import java.util.Scanner;

public class Level9_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N-M+1];
		int k=0;
		int idx=0;
		
		for(int i=M;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(N%j==0) {
					k++;
				}
				
			}
			if(k==2) {
				arr[idx]=i;
				idx++;
			}
		}
		System.out.println();
		System.out.println(arr[0]);
		

	}

}
