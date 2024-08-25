package s0824;

import java.util.Arrays;
import java.util.Scanner;

public class BitPermutationTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
	}
	static boolean np(int[] p) { // boolean : true(다음순열 존재), false(다음순열 없음)
		int N = p.length;
		
		// step1) 꼭대기 찾기
		int i=N-1;
		while(i>0 && p[i-1] >= p[i]) --i;
		
		if(i==0) return false;  // 다음 순열 없음
		
		// step2) 꼭대기 앞 교환위치에 교환할 값(i-1위치 값보다 큰 값 중 가장 작은 값) 자리 찾기
		int j = N-1;
		while(p[i-1]>=p[j]) --j;
		
		// step3) 두 위치의 수 교환
		swap(p, i-1, j);
		
		// step4) 꼭대기부터 맨 뒤까지 오름차순의 형태로 만듦
		int k = N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		return true;
	}
	static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
