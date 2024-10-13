package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_2110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  // 집의 개수
		int C = Integer.parseInt(st.nextToken());  // 공유기의 개수 
		int[] x = new int[N];  // 각 집의 좌표 
		for(int i=0;i<N;i++) {
			x[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(x);
		
		int start = 1;  // 최소 거리
		int end = x[N-1]-x[0];  // 최대 거리 
		int  res = 0;
		while(start <= end) {
			int cnt = 1;  // 설치된 공유기 개수 
			int mid = (start+end)/2;
			int pre=x[0];
			for(int i=1;i<=N-1;i++) {
				if(x[i]-pre >= mid) {
					cnt++;
					pre = x[i];
				}
			}
			if(cnt >= C) {
				start = mid + 1;
				res = Math.max(res, mid);
			}else {
				end = mid-1;
			}
		}
		System.out.println(res);

	}

}
