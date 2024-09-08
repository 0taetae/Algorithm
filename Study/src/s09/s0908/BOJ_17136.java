package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17136 {
	static int[][] arr;
	static int[] maxCnt = {0, 5, 5, 5, 5, 5};
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		for(int r=0;r<10;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0;c<10;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		track(0,0,0);
		if(res== Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		
	}
	static void track(int x, int y, int cnt){
		
		if(x>=10) {
			res = Math.min(res, cnt);
			return;
		}
		
		if(y>=10) {
			track(x+1,0,cnt);
			return;
		}
		
		if(arr[x][y]==0) {
			track(x,y+1,cnt);
			return;
		}
		
		for(int size=5;size>0;size--) {
			if(check(x,y,size)) {
				maxCnt[size]--;
				attach(x,y,size,0);
				track(x,y+1,cnt+1);
				attach(x,y,size,1);
				maxCnt[size]++;
			}
		}
	}
	static boolean check(int x, int y, int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	static void attach(int x, int y, int size, int state) {
		if(maxCnt[size]==0) return;
		if(x+size>=10 || y+size>=10) return;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				arr[i][j] = state;
			}
		}
	}

}
