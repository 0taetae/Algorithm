package s0712;

import java.util.Scanner;

public class Level2_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if ((H==0)&&(M<45)) {  // 자정(00시)에서 23시로
			System.out.println(23+" "+(15+M));
		}
		else if (M<45) { // 45분 뺄때, H가 변할때
			System.out.println((H-1)+" "+(15+M));
		}
		else {
			System.out.println(H+" "+(M-45));
		}

	}

}
