package p0827;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();  // 정점 개수
		int E = sc.nextInt();  // 간선 개수 
		
		// 무향 그래프
		int[][] adjMatrix = new int[V][V];  // 기본 초기화 값 0 : 인접하지 않는 상태
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		for(int[] adj:adjMatrix) {
			System.out.println(Arrays.toString(adj));
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
