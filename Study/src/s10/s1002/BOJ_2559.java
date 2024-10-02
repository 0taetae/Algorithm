package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_2559 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 온도를 측정한 전체 날짜의 수 
		int K = Integer.parseInt(st.nextToken());  // 합을 구하기 위한 연속적인 날짜의 수 
		
		int[] temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0;
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<=N-K;i++) {
			sum=0;
			for(int j=i;j<i+K;j++) {
				sum+=temp[j];
			}
			maxSum = Math.max(sum, maxSum);
		}
		System.out.println(maxSum);
	}

}
