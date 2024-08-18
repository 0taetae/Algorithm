package s07.s0712;

import java.util.Scanner;

public class Level2_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if (((A*60+B+C)/60)>=24) {  // 시간을 분으로 통일하기 -> 24시 이상인 경우
			System.out.println(((A*60+B+C)/60-24)+" "+((A*60+B+C)%60));
		}
		else {
			System.out.println(((A*60+B+C)/60)+" "+((A*60+B+C)%60));
		}

	}

}
