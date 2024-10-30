package s10.s1030;

import java.io.*;
import java.util.*;

public class BOJ_17140 {
	
	static int r,c,k;
	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int r=0;r<3;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<3;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int rCnt = 3;
		int cCnt = 3;
		int time=0;
		while(time<=k) {
			if(arr[r][c]==k) {
				break;
			}
			// R 연산
			if(rCnt>=cCnt) {
				
			}
			// C 연산 
			else {
				
			}
			time++;
		}
	}

}
