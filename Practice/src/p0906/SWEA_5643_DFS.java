package p0906;

import java.io.*;
import java.util.*;

public class SWEA_5643_DFS {
	
	static int N,M, cnt;
	static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				// a는 b보다 작다 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			int ans = 0;
			for(int i=1;i<=N;i++) {
				cnt = 0;
				tallerPeople(i,new boolean[N+1]);
				smallerPeople(i,new boolean[N+1]);
				if(cnt==N-1) ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
	// 자신보다 큰 사람 수 
	static void tallerPeople(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i=1;i<=N;i++) {
			if(!visited[i] && arr[cur][i]!=0) {
				tallerPeople(i,visited);
				cnt++;
			}
		}
	}
	// 자신보다 작은 사람 수 
	static void smallerPeople(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i=1;i<=N;i++) {
			if(!visited[i] && arr[i][cur]!=0) {
				smallerPeople(i,visited);
				cnt++;
			}
		}
	}

}
