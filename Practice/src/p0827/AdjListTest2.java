package p0827;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjListTest2 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();  // 정점 개수
		int E = sc.nextInt();  // 간선 개수 
		
		ArrayList<Integer>[] adjList = new ArrayList[V];  // 각 노드의 연결리스트의 헤드리스트 
		for(int i=0;i<V;i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from].add(to);
			adjList[to].add(from);
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
