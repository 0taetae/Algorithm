package s09.s0907;

import java.io.*;
import java.util.*;

public class BOJ_17136 {
	
	static int[][] paper;  // 주어진 종이
	static int[] color; // 색종이 크기별 붙인 개수 
	static int res = Integer.MAX_VALUE;  // 필요한 색종이의 최소 개수 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		paper = new int[10][10];
		color = new int[6];
		for(int r=0;r<10;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<10;c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		track(0,0,0);   // 행, 열, 필요한 색종이 개수 
		
		// 색종이를 붙일 수 없는 경우 
		if(res==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
	static void track(int x, int y, int cnt) { 
		
		// 모든 칸 확인 다한 경우
		if(x>=10) {
			// 사용한 색종이 개수의 최솟값 구하기 
			res = Math.min(cnt, res);
			return;
		}
		// 해당 행 확인 완료 
		if(y>=10) {
			track(x+1, 0, cnt);
			return;
		}
		
		// 색종이를 붙일 수 없는 칸
		if(paper[x][y]==0) {
			track(x,y+1,cnt);
			return ;
		}
		
		for(int size=5;size>=1;size--) {
			if(check(x,y,size)) {
				color[size]++;  // 해당 크기의 색종이 사용 
				attach(x,y,size,0);  // 색종이 사용한 부분 0으로 바꾸기
				track(x,y+1,cnt+1);
				attach(x,y,size,1);  // 원상복구
				color[size]--;
				
			}
		}
	}
	// 색종이를 붙일 수 있는지 확인
	static boolean check(int x, int y, int size) {
		if(color[size]==5) return false;  // 사용 가능한 색종이 수 다쓴 경우
		if(x+size>10 || y+size>10) return false;  // 10*10 종이 밖
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	// 색종이 붙이거나 뗄 때 
	static void attach(int x, int y, int size, int state) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				paper[i][j] = state;
			}
		}
	}
	
}
