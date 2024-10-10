package s10.s1010;

import java.io.*;
import java.util.*;

public class BOJ_2458 {
	
	static int N,M;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 학생 수
		M = Integer.parseInt(st.nextToken());  // 두 학생 키 비교 횟수
		check = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			// a < b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			check[a][b] = true;
		}
		
		int res = 0;
		for(int i=1;i<=N;i++) {
			int sum = bigger(i) + smaller(i);
			
			if(sum == N-1) {
				res++;
			}
		}
		System.out.println(res);
	}
	
	// 자신보다 키가 큰 사람 확인
	static int bigger(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(!visited[i] && check[cur][i]) {
					cnt++;
					q.add(i);
					visited[i]=true;
				}
			}
		}
		return cnt;
	}
	
	// 자신보다 키가 작은 사람 확인
	static int smaller(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(!visited[i] && check[i][cur]) {
					cnt++;
					q.add(i);
					visited[i]=true;
				}
			}
		}
		return cnt;
	}

}
