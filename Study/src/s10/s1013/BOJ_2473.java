package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_2473 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = 0;
		int target=0;
		int targetS = 0;
		int targetE = 0;
		long res = Long.MAX_VALUE;
		for(int i=0;i<=N-3;i++) {
			start = i+1;
			end = N-1;
			
			while(start<end) {
				long sum = arr[i]+arr[start]+arr[end];
				
				if(Math.abs(sum) < res) {
					res = Math.abs(sum);
					targetS = start;
					targetE = end;
					target = i;
				}
				
				if(sum<0) {
					start++;
				}
				else if(sum>0) {
					end--;
				}
				else if(sum==0) {
					System.out.println(arr[target]+" "+arr[targetS]+" "+arr[targetE]);
					return;
				}
			}
		}
		System.out.println(arr[target]+" "+arr[targetS]+" "+arr[targetE]);
	}
}
