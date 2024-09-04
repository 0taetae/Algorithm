package p0903;

import java.io.*;
import java.util.*;

public class DijkstraTest {
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		System.out.println(getMinDistance(adjList, start, end));
	}
	static int getMinDistance(Node[] adjList, int start, int end) {
		final int v = adjList.length;
		int[] minDistance = new int[v]; // 사작정점에서 자신으로의 최소거리
		boolean[] visited = new boolean[v];
		final int INF = Integer.MAX_VALUE;
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		for(int i=0; i<v;i++) {
			//step1 : 미방문 정점 중 시작정점에서 가장 가까운 정점 선택
			int min = INF;
			int stopOver = -1;
			for(int j=0;j<v;j++) {
				if(!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			//if(stopOver == end) break; // 도착지로의 최단거리만 궁금한 경우 
			if(stopOver == -1) break;
			visited[stopOver] = true;
			
			//step2: 선택된 정점을 경우해서 미방문 인접한 정점으로의 최소비용을 갱신할 수 있는지 체크
			for(Node temp = adjList[stopOver]; temp!=null; temp = temp.next) {
				if(!visited[temp.vertex] && minDistance[temp.vertex]>min+temp.weight) {
					minDistance[temp.vertex] = min+temp.weight;
				}
			}
		}
		System.out.println(Arrays.toString(minDistance));
		return minDistance[end] != INF ? minDistance[end] : -1;  // INF이면 갈 수 없음, INF 아니면 도달 가능 
		
	}

}
/*
6 11
0 5
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 0 3
4 5 6

output==> 12


5 4
0 3
0 1 5
1 2 2
3 2 6
4 3 10

output==> -1



10 17
0 9
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==>21
 */


