package p0829;

import java.util.Arrays;
import java.util.Scanner;

public class MST_KruskalTest {
	
	static int V;
	static int[] parents;
	
	static void make() {
		parents = new int[V];
		for(int i=0;i<V;i++) {
			parents[i] = -1;
		}  // Arrays.fill(parents,-1);
	}
	
	static int findSet(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = findSet(parents[a]);  // 집합의 대표자를 자신의 부모로 변경 : 패스 압축
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		// 집합의 크기에 따라 줄이도록 처리 가능
		// 편의상 a집합에 b집합을 붙임 
		parents[aRoot] += parents[bRoot];  // 집합 크기관리(절대값을 사용하면 집합의 크기가 됨)
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		Edge[] edges = new Edge[E];
		for(int i=0;i<E;i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edges);  // 간선의 가중치 기준으로 오름차순 정렬
		make();  // 모든 정점을 분리집합으로 (단위 서로소 집합<트리> 생성)
		
		int cnt = 0; 
		int cost = 0;
		for(Edge edge : edges) {
			if(union(edge.start, edge.end)) {
				cnt++;
				cost += edge.weight;
				if(cnt == V-1) break;  // 최소신장트리 완성
			}
		}
		System.out.println(cost);
		

	}
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
			
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}

/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175

 */

