package p0905;

import java.io.*;
import java.util.*;

public class MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();  // 목표금액
		int[] D = new int[money+1];
		
		D[0] = 0;  // base case 초기화 
		for(int i=1;i<=money;i++) {
			// 1원짜리 동전 사용했을 경우
			int min = D[i-1] + 1;  
			// 1원짜리 동전 사용했을 경우와 4원짜리 동전 사용했을 경우 최적해 비교
			if(i>=4) min = Math.min(min, D[i-4]+1);  
			// 1원짜리 동전 사용했을 경우와 4원짜리 동전 사용했을 경우와 6원 짜리 동전 사용했을 경우 최적해비교
			if(i>=6) min = Math.min(min, D[i-6]+1);  
			D[i] = min;
		}
		System.out.println(D[money]);  // 최소 동전 개수 

	}

}
