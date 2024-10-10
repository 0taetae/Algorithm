package s10.s1009;

import java.io.*;
import java.util.*;

public class BOJ_10159 {
	
	static int N,M;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		check = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // a > b
			int b = Integer.parseInt(st.nextToken());
			
			check[a][b] = true;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			int cnt = 0;  // 비교 결과를 알 수 있는 물건
			
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				if(check[i][j] || check[j][i]) {
					cnt++;
				}
			}
			System.out.println(N-1-cnt);  // 비교 결과를 알 수 없는 물건 
		}
	}
}
