package s10.s1016;

import java.io.*;
import java.util.*;

public class BOJ_20058 {
	
	static int N,Q;
	static int[][] map;
	static int size;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		map = new int[size][size];
		
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
		}

	}

}
