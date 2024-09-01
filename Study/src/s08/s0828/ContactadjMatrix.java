package s08.s0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ContactadjMatrix {
	static int count;
	static int[][] adjMatrix;
	static int Max;
	static int[] score;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=1;i<=10;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			score = new int[101];
			adjMatrix = new int[101][101];
			
			
			for(int j=1;j<=N/2;j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}
			Max = 0;
			int result =0;
			
			bfs(start);
			
			for(int j=1;j<=100;j++) {
				Max = Math.max(Max, score[j]);
			}
			
			for(int j=1;j<=100;j++) {
				if(score[j]==Max) {
					result = Math.max(result, j);
				}
			}
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		score = new int[101];
		
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=100;i++) {
				if(adjMatrix[cur][i]==0 || visited[i]) continue;
				
				score[i] = score[cur]+1;
				visited[i] = true;
				q.offer(i);
			}
		}
	}
}
