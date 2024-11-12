package s11.s1112;

import java.io.*;
import java.util.*;

// 다익스트라 알고리즘 
public class SWEA_5643_sol2 {
	
	static int N,M;
	static boolean[][] Short;
	static boolean[][] Long;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			Short = new boolean[N+1][N+1];
			Long  = new boolean[N+1][N+1];
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Short[b][a] = true;
				Long[a][b] = true;
			}
			int res = 0;
			for(int i=1;i<=N;i++) {
				if(check(i,Long) + check(i,Short)==N-1) {
					res++;
				}
			}
			System.out.println("#"+tc+" "+res);
		}

	}

	private static int check(int start, boolean[][] target) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start] = true;
		int sum=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(!visited[i] && target[cur][i]) {
					visited[i] = true;
					q.add(i);
					sum++;
				}
			}
		}
		return sum;
	}

}
