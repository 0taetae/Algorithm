package s09.s0912;

import java.io.*;
import java.util.*;

public class BOJ_1967 {
	
	static int N;
	static ArrayList<ArrayList<Info>> adj = new ArrayList<>();
	static boolean[] visited;
	static int nextStart;
	static int maxWeight;
	
	static class Info{
		int node;
		int weight;
		Info(int node, int weight){
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // N개의 노드 
		StringTokenizer st;
		
		// 2차원 인접 리스트 생성
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<Info>());
		}
		
		for(int i=1;i<=N-1;i++) {  // N-1개의 간선
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // 부모 노드 번호
			int b = Integer.parseInt(st.nextToken());  // 자식 노드 번호
			int w = Integer.parseInt(st.nextToken());  // 간선의 가중치
			adj.get(a).add(new Info(b,w));
			adj.get(b).add(new Info(a,w));
		}
		
		// 아무 노드에서 가장 가중치의 합이 큰 경우에 끝에 있는 노드 구하기 -> 임의로 1로 지정 
		visited = new boolean[N+1];
		visited[1] = true;
		nextStart=0;
		maxWeight=0;
		dfs(1,0);
		
		// 위에서 구한 노드에서 시작하여 가장 가중치의 합이 큰 경우에 끝에 있는 노드 구하기 
		visited = new boolean[N+1];
		visited[nextStart] = true;
		maxWeight=0;
		dfs(nextStart,0);
		
		// 위에서 구한 두 노드 사이의 가중치의 합이 트리의 지름 
		System.out.println(maxWeight);
		
	}
	public static void dfs(int start,int weight) {
		for(int i=0;i<adj.get(start).size();i++) {
			Info target = adj.get(start).get(i);
			if(!visited[target.node]) {
				visited[target.node] = true;
				dfs(target.node, weight+target.weight);
				if(maxWeight < weight+target.weight) {
					nextStart = target.node;
					maxWeight = weight+target.weight;
				}
			}
		}
	}
}
