package s0712;

import java.util.Scanner;

public class Level2_N7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if ((A==B)&&(B==C)) {  // 같은 눈 3개
			System.out.println(10000+A*1000);
		}
		else if (A==B) {  //같은 눈 2개
			System.out.println(1000+A*100);
		}
		else if (B==C) {
			System.out.println(1000+B*100);
		}
		else if (A==C) {
			System.out.println(1000+A*100);
		}
		else { //모두 다른 눈
			int max = A; // 변수 생성
			if (B>max) {
				max = B;
			}
			if (C>max) {
				max = C;
			}
			System.out.println(max*100);
		}

	}

}
