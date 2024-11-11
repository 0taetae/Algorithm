package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_4012 {
	
	static int N;
	static int[][] map;
	static boolean[] selected;
	static int total;
	static int res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			total=0;
			for(int r=1;r<=N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=1;c<=N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					total+=map[r][c];
				}
			}
			selected = new boolean[N+1];
			res = Integer.MAX_VALUE;
			
			comb(1,0);
			System.out.println("#"+tc+" "+res);
			
		}
		
		
	}
	// 조합 
	public static void comb(int idx, int cnt) {
		if(cnt==N/2) {
			int sumA=0;
			int sumB=0;
			for(int r=1;r<=N;r++) {
				
				for(int c=1;c<=N;c++) {
					if(selected[r] &&selected[c]) {
						sumA+=map[r][c];
					}
					if(!selected[r] && !selected[c]) {
						sumB+=map[r][c];
					}
				}
			}
			res = Math.min(res,Math.abs(sumA-sumB));
			return;
		}
		for(int i=idx;i<=N;i++) {
			if(!selected[i]) {
				selected[i] = true;
				comb(i+1,cnt+1);
				selected[i] = false;
			}
		}
	}

}
