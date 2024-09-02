package s09.s0902;

import java.io.*;
import java.util.*;

public class SWEA_7465 {
	
	static int N, M;
	static Edge[] edges;
	
	static class Edge{
		int from;
		int to;
		Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
	static int[] parents;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 정점 개수
			M = Integer.parseInt(st.nextToken());  // 간선 개수 
			edges = new Edge[M];
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edges[j] = new Edge(from, to);
			}
			make();
			int cnt=0;
			for(Edge edge:edges) {
				union(edge.from, edge.to);
			}
			int result=0;
			for(int j=1;j<N+1;j++) {
				if(parents[j]<0) {
					result++;
				}
			}
			System.out.println("#"+i+" "+result);
			
		}

	}

}
