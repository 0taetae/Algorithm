package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		int res = Integer.MAX_VALUE;
		int targetS=0;
		int targetE = 0;
		
		while(start<end) {
			
			int sum = arr[start]+arr[end];
			
			if(Math.abs(sum) < res) {
				res = Math.abs(sum);
				targetS = start;
				targetE = end;
				
			}
			if(sum<0) {
				start++;
			}
			else if(sum >0) {
				end--;
			}else {
				break;
			}
		}
		System.out.println(arr[targetS]+" "+arr[targetE]);
	}

}
