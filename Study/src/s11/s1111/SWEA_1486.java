package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_1486 {
	
	static int N,B;
	static int[] h;
	static int res;
	static boolean[] select;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			h = new int[N];
			select = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			res = Integer.MAX_VALUE;
			select = new boolean[N];
			subset(0);
			System.out.println("#"+tc+" "+res);
		}

	}
	public static void subset(int cnt) {
		if(cnt==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(select[i]) {
					sum+=h[i];
				}
			}
			if(sum>=B) {
				res = Math.min(res, sum-B);
			}
			return;
		}
		select[cnt] = true;
		subset(cnt+1);
		select[cnt] = false;
		subset(cnt+1);
	}

}
