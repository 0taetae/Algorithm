package s08.s0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamberger {

	static int[][] arr;
	static boolean[] select;
	static int N;
	static int L;
	static int max;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			select = new boolean[N];
			
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				arr[r][0] = Integer.parseInt(st.nextToken());
				arr[r][1] = Integer.parseInt(st.nextToken());
			}
			max=0;
			per(0, select);
			sb.append("#").append(i).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);

	}
	public static void per(int cnt, boolean[] select) {
		if(cnt == N) {
			int cal=0;
			int score=0;
			for(int i=0;i<N;i++) {
				if(select[i]) {
					cal+=arr[i][1];
					score += arr[i][0];
				}
			}
			if(cal<=L) {
				max = Math.max(max,score);
			}
			return;
		}
		select[cnt] = true;
		per(cnt+1, select);
		select[cnt] = false;
		per(cnt+1, select);
	}

}
