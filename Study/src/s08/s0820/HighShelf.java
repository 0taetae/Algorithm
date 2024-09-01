package s08.s0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HighShelf {
	static int[] height;
	static int N;
	static int B;
	static boolean[] select;
	static int min;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T;i++) {
			min=Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			select = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}
			perm(0,select);
			sb.append("#").append(i).append(" ").append(min-B).append("\n");
		}
		System.out.println(sb);

	}
	public static void perm(int cnt, boolean[] select) {
		if(cnt==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(select[i]) {
					sum+=height[i];
				}
			}
			if(sum>=B) {
				min = Math.min(min, sum);
			}
			return;
		}
		select[cnt] = true;
		perm(cnt+1,select);
		select[cnt] = false;
		perm(cnt+1,select);
	}

}
