package s11.s1110;

import java.io.*;
import java.util.*;

public class BOJ_1992 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	// 0은 white, 1은 black

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r=0;r<N;r++) {
			String str = br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		check(0,0,N);
		System.out.println(sb);
		

	}
	
	public static void check(int r, int c, int size) {
		int sum =0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum+=map[i][j];
			}
		}
		if(sum==0) {
			sb.append(0);
			return;
		}else if(sum==size*size) {
			sb.append(1);
			return;
		}else {
			sb.append('(');
			check(r,c,size/2);
			check(r,c+size/2, size/2);
			check(r+size/2,c,size/2);
			check(r+size/2,c+size/2,size/2);
			sb.append(')');
		}
	}

}
