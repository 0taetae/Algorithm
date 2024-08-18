package s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS {
	static boolean[] visit;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N+1][N+1];
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		visit = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
		

	}
	public static void dfs(int start) {
		visit[start] = true;
		sb.append(start+" ");
		for(int i=1;i<=N;i++) {
			if(arr[start][i]==1 && !visit[i] ) {
				dfs(i);
			}
		}
	}
	public static void bfs(int start) {
		
		q.offer(start);
		visit[start]=true;
		
		while(!q.isEmpty()){
			start = q.poll();
			sb.append(start+" ");
			for(int i=1;i<=N;i++) {
				if(arr[start][i]  == 1 && !visit[i]) {
					visit[i]=true;
					q.offer(i);
					
				}
			}
			
		}
	}

}
