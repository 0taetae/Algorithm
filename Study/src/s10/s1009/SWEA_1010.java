package s10.s1009;

import java.io.*;
import java.util.*;

public class SWEA_1010 {
	
	static int N,L;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로
		for(int r=0;r<N;r++) {
			upcheck(r);
			downcheck(r);
		}
		// 세로
		for(int c=0;c<N;c++) {
			
		}

	}
	static void upcheck(int r) {
		for(int c=0;c<N;c++) {
			
		}
	}
	static void downcheck(int r) {
		
	}
	

}
