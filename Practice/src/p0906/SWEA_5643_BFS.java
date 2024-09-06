package p0906;

import java.io.*;
import java.util.*;

public class SWEA_5643_BFS {
	
	static int N,M;
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
			// 자신보다 작은 사람 수 + 자신보다 큰 사람 수 == N-1 -> 자신의 키 순서를 알 수 있음 
			int res = 0;
			for(int i=1;i<=N;i++) {
				if(tallerPeople(i) + smallerPeople(i)==N-1) {
					res++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);

	}
	// 자신보다 큰 사람 수 
	static int tallerPeople(int start) {
		int cnt= 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(!visited[i] && arr[cur][i]!=0) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}
	// 자신보다 작은 사람 수 
	static int smallerPeople(int start) {
		int cnt= 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(!visited[i] && arr[i][cur]!=0) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		return cnt;
	}

}
