package p0830;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 수
		int[][] adjMatrix = new int[V][V];
		boolean[] visited = new boolean[V]; // 방문여부 배열(트리 포함정점배열) 
		int[] minEdge = new int[V]; // 자신과 타정점들간의 간선비용 중 최소 간선 비용
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = sc.nextInt();
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; // 0번 정점을 트리의 시작정점이 되도록 함(다른 정점이어도 상관없음)
		int cost = 0;
		
		int i = 0;
		for (i = 0; i < V; i++) {
			
			// step1 : 트리 구성에 포함될 가장 유리한 정점 선택(비트리 정점 중 최소비용 간선의 정점 선택 )
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < V; j++) {
				if(visited[j]) continue;
				if(min>minEdge[j]) {
					minVertex = j;
					min = minEdge[j];
				}
			}
			
			if(minVertex == -1) break;
			visited[minVertex] = true;
			cost += min;
			
			// step2 : 선택된 정점과 타 정점들 간선비용 비교하기 (간보기)
			for (int j = 0; j < V; j++) {
				//비트리 정점이어야 함 && 지금 선택한 정점과 그 정점이 인접해야함 && 현재 정점에서 가는 간선이 더 유리하다면
				if(!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(i==V?cost:-1);
	}
}

/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175

 */

