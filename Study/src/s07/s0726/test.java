package s07.s0726;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		//int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		}

		System.out.println("BFS - 인접리스트");
		bfs_list(1, adjList, visited);
		
		for(int i=0;i<=n;i++) {
			if(visited[i]) {
				count++;
			}
		}
		System.out.println(count-1);
	}

	// BFS - 인접리스트 
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v);

		while(queue.size() != 0) { 
			v = queue.poll(); 
			//System.out.print(v + " ");
			//count++;

			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) { 
				int w = iter.next(); 
				if(!visited[w]) { 
					visited[w] = true; 
					queue.add(w); 
				} 
			}
		}
		//return count;
	}

}
