package s09.s0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] Lan = new int[K];
		int minLen = Integer.MAX_VALUE;
		//int total=0;
		for(int i=0;i<K;i++) {
			Lan[i] = Integer.parseInt(br.readLine());
			//total += Lan[i];
			minLen = Math.min(Lan[i], minLen);
		}
		Arrays.sort(Lan);
		
		int startLen = 1;
		int endLen = minLen;
		
		int res = 0;
		int cnt = 0;  // 가질 수 있는 랜선 개수 
		while(startLen < endLen) {
			cnt =0;
			int midLen = (startLen + endLen)/2;
			
			for(int i=0;i<K;i++) {
				cnt += Lan[i]/midLen;
			}
			if(cnt <N) {
				endLen = midLen-1;
			}else if(cnt >= N) {
				res = midLen;
				startLen = midLen +1;
				
			}
			
		}
		System.out.println(res);

	}

}
