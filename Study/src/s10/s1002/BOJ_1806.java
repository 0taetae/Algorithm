package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_1806 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0;
		int minCnt=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			sum=0;
			for(int j=i;j<N;j++) {
				sum+=arr[j];
				
				if(sum >=S) {
					minCnt = Math.min(minCnt,j-i+1);
					break;
				}
			}
		}
		if(minCnt == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(minCnt);
		}
		
	}
}
