package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_19539 {
	
	/*
	사과나무 개수 N
	물뿌리개 반드시 동시 사용 -> 1, 2
	물뿌리개를 나무 없는 토양에 사용 불가
	두 물뿌리개를 한 나무에 사용 -> 3만큼 키울 수 있음
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int even=0;  // 2번 물뿌리개 사용
		int odd=0;  // 1번 물뿌리개 사용
		
		for(int i=0;i<N;i++) {
			int height = sc.nextInt();
			even += height/2;
			odd += height%2;
		}
        // 1번 물뿌리개 대신 2번 물뿌리개 사용 불가
		if(even < odd) {
			System.out.println("NO");
		}
        // 2번 물뿌리개 대신 1번 물뿌리개 사용할 경우 
		else if(even > odd) {
			if((even-odd)%3==0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
        // 1번 물뿌리개 사용 횟수 = 2번 물뿌리개 사용 횟수
		else {
			System.out.println("YES");
		}
	}
}
