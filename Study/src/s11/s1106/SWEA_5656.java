package s11.s1106;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
	static int[] selected;
	static int[][] map,copy;
	static int N,W,H;
	static int res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			selected = new int[N];
			map = new int[H][W];
			copy = new int[H][W];  // 원상복귀를 위한 배열
			res = Integer.MAX_VALUE;
			
			for(int r=0;r<H;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<W;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					copy[r][c] = map[r][c];
				}
			}
			perm(0);
			
		}

	}
	// 중복순열
	public static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				shoot(selected[i]);  // 구슬 쏘기
			}
			res = Math.min(cal(),res);  // 벽돌 수 구하기
			reset(); // 배열 원상복구 
			return;
		}
		for(int i=0;i<W;i++) {
			selected[cnt] = i;
			perm(cnt+1);
			
		}
	}
	private static int cal() {
		return 0;
	}
	private static void reset() {
		
	}
	private static void shoot(int i) {
		
	}

}
