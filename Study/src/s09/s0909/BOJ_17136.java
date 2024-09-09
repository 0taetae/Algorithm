package s09.s0909;

import java.io.*;
import java.util.*;

public class BOJ_17136 {
	
	static int[][] map = new int[10][10];
	static int[] color = {0,5,5,5,5,5};
	static int minCnt=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r=0;r<10;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<10;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		test(0,0,0);
		if(minCnt==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minCnt);
		}
		
		

	}
	static void test(int x, int y, int cnt) {
		if(x>=10) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}
		
		if(y>=10) {
			test(x+1,0,cnt);
			return;
		}
		if(map[x][y]==0) {
			test(x,y+1,cnt);
			return;
		}
		for(int size=5;size>=1;size--) {
			if(check(x,y,size)) {
				color[size]--;
				attach(x,y,size,0);
				test(x,y+1,cnt+1);
				attach(x,y,size,1);
				color[size]++;
			}
			
		}
	}
	static boolean check(int x, int y, int size) {
		if(color[size]==0) return false;
		if(x+size>10 || y+size>10) return false;
		for(int r=x;r<x+size;r++) {
			for(int c=y;c<y+size;c++) {
				if(map[r][c]==0) {
					return false;
				}
			}
		}
		return true;
	}
	static void attach(int x, int y, int size, int state) {
		for(int r=x;r<x+size;r++) {
			for(int c=y;c<y+size;c++) {
				map[r][c] = state;
			}
		}
	}

}
