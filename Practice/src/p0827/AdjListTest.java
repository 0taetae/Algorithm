package p0827;

import java.util.Scanner;

public class AdjListTest {
	
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next  + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();  // 정점 개수
		int E = sc.nextInt();  // 간선 개수 
		
		Node[] adjList = new Node[V];  // 각 노드의 연결리스트의 헤드리스트 
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 첫노드로 삽입하는 알고리즘
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		for(int i=0;i<V;i++) {
			System.out.println(adjList[i]);
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
