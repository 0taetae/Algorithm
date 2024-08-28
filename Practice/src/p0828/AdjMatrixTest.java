package p0828;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
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
		bfs1(0);
		
		adjList = new Node[V];
		for(int i=0;i<E;i++) {
			int from= sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		bfs2(0);

	}
	private static void bfs1(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			//System.out.println((char) (cur+65));
			
			// 자신의 인접 정점들 다음 탐색 준비
			for(int i=0;i<V;i++) {
				if(adjMatrix[cur][i]==0 || visited[i]) continue;
				
				visited[i] = true;
				queue.offer(i);
			}
		}
	}
	private static void bfs2(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			//System.out.println((char) (cur+65));
			
			// 자신의 인접 정점들 다음 탐색 준비
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(visited[temp.to]) continue;
				
				visited[temp.to] = true;
				queue.offer(temp.to);
			}
		}
	}

}
/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
*/
