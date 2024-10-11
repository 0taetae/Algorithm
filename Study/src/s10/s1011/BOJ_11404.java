package s10.s1011;

import java.io.*;
import java.util.*;

public class BOJ_11404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  // 도시
		int M = Integer.parseInt(br.readLine());  // 버스
		boolean[][] arr = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
		}
		
//		for(int k=0;k<N;k++) {
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					if(arr[i][k] && arr[k][j]) {
//						arr[i][j] = true;
//					}
//				}
//			}
//		}
		

	}

}
