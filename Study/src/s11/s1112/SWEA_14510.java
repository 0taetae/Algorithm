package s11.s1112;

import java.io.*;
import java.util.*;

public class SWEA_14510 {
	
	// 가장 큰 나무와 높이가 같아지도록
	// 홀수날은 1, 짝수날은 2만큼 키가 자람
	// 하루에 한 나무에 물을 줄 수 있음 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] h = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = 0;
			for(int i=0;i<N;i++) {
				h[i] = Integer.parseInt(st.nextToken());  // 각 나무의 높이
				target = Math.max(target, h[i]);
			}
			int even=0;
			int odd=0;
			for(int i=0;i<N;i++) {
				odd+=(target-h[i])%2;
				even +=(target-h[i])/2;
			}
			//System.out.println(odd);
			//System.out.println(even);
			
			// 짝수날의 수와 홀수날의 수가 같은 경우
			// 1 2 1 2
			if(even==odd) {
				System.out.println("#"+tc+" "+odd*2);
			}
			// 홀수날 > 짝수날
			// 1 2 1 2 1 0 1 0 1
			else if(odd>even) {
				System.out.println("#"+tc+" "+(odd*2-1));
			}
			// 짝수날 > 홀수날
			// 1 2 1 2 0 2 0 2 0 2 0 2
			// 1 2 1 2 1 2 1 2 0 2
			else if(even>odd) {
				//System.out.println("짝수날이 더 많아 ");
				int res = (2*even+odd)/3*2;
				if((2*even+odd)%3==1) {
					res++;
				}else if((2*even+odd)%3==2) {
					res+=2;
				}
				System.out.println("#"+tc+" "+res);
			}
			
		}
		

	}

}
