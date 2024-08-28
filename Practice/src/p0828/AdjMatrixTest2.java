package p0828;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest2 {
	static int V;
	static int[][] adjMatrix;
	static Node[] adjList;
	
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", next" +next + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();  // 정점 개수
		int E = sc.nextInt();  // 간선 개수 
		
		// 무향 그래프
		adjMatrix = new int[V][V];  // 기본 초기화 값 0 : 인접하지 않는 상태
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		adjList = new Node[V];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		dfs1(0, new boolean[V]);
		System.out.println("-------");
		dfs2(0, new boolean[V]);

	}
	// 인접행렬
	private static void dfs1(int cur, boolean[] visited) {
		
		visited[cur] = true;
		System.out.println((char) (cur+65));
		
		// 자신의 인접 정점들 다음 탐색 준비
		for(int i=0;i<V;i++) {
			if(adjMatrix[cur][i]==0 || visited[i]) continue;
			dfs1(i,visited);
		}
	}
	//인접리스트
	private static void dfs2(int cur, boolean[] visited) {
		
		visited[cur] = true;
		System.out.println((char) (cur+65));
		
		// 자신의 인접 정점들 다음 탐색 준비
		for(Node temp = adjList[cur]; temp != null ; temp = temp.next) {
			if(visited[temp.to]) continue;
			dfs2(temp.to,visited);
		}
	}

}
/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/
