package s0718;

import java.util.Scanner;
import java.util.Arrays;

public class Level10_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N==1) {
			System.out.println(0);
		}
		else {
			int[] arrx = new int[N];
			int[] arry = new int[N];
			
			for(int i=0;i<N;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arrx[i]=x;
				arry[i]=y;
			}
			Arrays.sort(arrx);
			Arrays.sort(arry);
			System.out.println((arrx[N-1]-arrx[0])*(arry[N-1]-arry[0]));
		}

	}

}
