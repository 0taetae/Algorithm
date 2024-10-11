package s10.s1011;

import java.io.*;
import java.util.*;

public class BOJ_20366 {
	
	static int N;
	static int[] arr;
	static int[] selected;
	static int res;
	
	// 1. 조합으로 4개 뽑아, 차 최솟값 구하기 -> 시간초과
	// 2. 2개 이중 for문, 2개 투포인터

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res = Integer.MAX_VALUE;
		Arrays.sort(arr);  // 오름차순 정렬
		
		// 언니 눈사람 s1, e1
		// 동생 눈사람 s2, e2
		for(int s1 = 0; s1<=N-4; s1++) {
			for(int e1=N-1; e1>=3;e1--) {
				int old = arr[s1] + arr[e1];
				
				int s2 = s1+1;
				int e2 = e1-1;
				while(s2<e2) {
					int young = arr[s2]+arr[e2];
					res = Math.min(res, Math.abs(old - young));
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
