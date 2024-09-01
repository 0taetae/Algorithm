package s09.s0901;

import java.io.*;
import java.util.*;

public class BOJ_1647 {
	
	static int N, M;
	static int[] parents;
	static class Edge{
		int start, end, weight;
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static void make() {
		parents = new int[N+1];
		Arrays.fill(parents, -1);
	}
	static int findSet(int a) {
		if(parents[a]<0) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 집(정점)의 개수
		M = Integer.parseInt(st.nextToken());  // 길(간선)의 개수
		
		Edge[] edges = new Edge[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A,B,C);
		}
		
		if(N<=2) {
			System.out.println(0);
			return;
		}
		// 가중치를 기준으로 오름차순 정렬
		Arrays.sort(edges, new Comparator<Edge>() {

			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
			
		});
		make();
		
		int cnt = 0;
		int cost = 0;
		for(int i=0;i<M;i++) {
			Edge target = edges[i];
			if(union(target.start, target.end)) {
				cnt++;
				cost += target.weight;
				if(cnt == N-2) break;
			}
		}
		System.out.println(cost);
	}

}
