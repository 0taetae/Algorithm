package s10.s1011;

import java.io.*;
import java.util.*;

public class BOJ_20366 {
	
	/*
	두 눈사람의 키 차이의 최솟값 -> 키 차이를 0에 근접하게 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];  // 눈덩이의 지름 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int res = Integer.MAX_VALUE;
		Arrays.sort(arr);  // 오름차순 정렬
		
		// 언니 눈사람 s1, e1
		// 동생 눈사람 s2, e2
		// s1 s2 e2 e1 
		for(int s1 = 0; s1<=N-4; s1++) {
			for(int e1=N-1; e1>=3;e1--) {
				int old = arr[s1] + arr[e1];  // 언니 눈사람의 키
				
				int s2 = s1+1;
				int e2 = e1-1;
				while(s2<e2) {
					int young = arr[s2]+arr[e2];  // 동생 눈사람의 키 
					res = Math.min(res, Math.abs(old - young));  // 두 눈사람의 키 차이의 최솟값 
					if(young < old) {
						s2++;
					}else {
						e2--;
					}
				}
			}
		}
		System.out.println(res);
	}
}
