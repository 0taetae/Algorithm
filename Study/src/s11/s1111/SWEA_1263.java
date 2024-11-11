package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_1263 {
	
	static int N;
	static int[][] map, dist;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			dist = new int[N+1][N+1];
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(r!=c) {
						dist[r][c] = Integer.MAX_VALUE;
					}
					
				}
			}
			
			for(int i=1;i<=N;i++) {
				bfs(i);
			}
			sb.append("#"+tc+" ");
			int res=Integer.MAX_VALUE;
			for(int i=1;i<=N;i++) {
				int sum=0;
				for(int j=1;j<=N;j++) {
					sum+=dist[i][j];
				}
				res = Math.min(res, sum);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);

	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(cur==i) continue;
				if(map[cur][i]==1 && !visited[i] && dist[start][i] >= dist[start][cur]+1) {
					q.add(i);
					visited[i] = true;
					dist[start][i] = dist[start][cur]+1;
				}
				
			}
				
		}
		
	}

}
/*
0 1 1 0 0 
1 0 1 1 1 
1 1 0 0 0 
0 1 0 0 0 
0 1 0 0 0
 */
