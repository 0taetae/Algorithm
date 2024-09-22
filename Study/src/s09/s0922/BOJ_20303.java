package s09.s0922;

import java.io.*;
import java.util.*;

public class BOJ_20303 {
	
	static int N,M,K;
	static int[] candy;
	static ArrayList<Integer>[] lst ;
	static int[] dp;
	static class Info{
		int cnt, sum;
		Info(int cnt, int sum){
			this.cnt = cnt;
			this.sum = sum;
		}
	}
	static boolean[] visited;
	static ArrayList<Info> friend = new ArrayList<Info>();  // 친구관계, 사탕의 수 합 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 아이들의 수
		M = Integer.parseInt(st.nextToken());  // 아이들의 친구 관계 수
		K = Integer.parseInt(st.nextToken());  // 울음소리가 공명하기 위한 최소 아이의 수
		candy = new int[N+1];  // 아이들이 받은 사탕의 수 
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		// 인접리스트 - 친구관계 
		lst = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			lst[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lst[a].add(b);
			lst[b].add(a);
		}
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		dp = new int[K];
        for (Info cur : friend) {
            int curCnt = cur.cnt;
            int curSum = cur.sum;

            for (int i = K - 1; i >= curCnt; i--) {
                dp[i] = Math.max(dp[i], dp[i - curCnt] + curSum);
            }
        }
        // 최대로 뺏을 수 있는 사탕의 양 
        int res = 0;
        for (int i = 0; i < K; i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
		

	}
	static void dfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.offer(start);
		int cnt = 1;
		int sum = candy[start];
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<lst[cur].size();i++) {
				int target = lst[cur].get(i);
				if(!visited[target]) {
					cnt++;
					sum += candy[target];
					q.offer(target);
					visited[target] = true;
				}
				
				
			}
		}
		friend.add(new Info(cnt,sum));
	}

}
