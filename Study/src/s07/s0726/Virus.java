package s07.s0726;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 컴퓨터의 수 = 정점의 개수 
		int K = sc.nextInt(); // 컴퓨터 쌍의 수 = 간선의 개수 

		boolean visited[] = new boolean[N + 1]; // 바이러스 여부 = 방문 여부

		ArrayList<Integer>[] list = new ArrayList[N + 1];  // 컴퓨터 리스트
		
		long beforTime = System.currentTimeMillis();
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < K; i++) {  // 리스트의 index = 컴퓨터 번호
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			list[v1].add(v2);
			list[v2].add(v1);
		}
		

		BFS(1, list, visited);  // 1번 컴퓨터부터 시작 
		
		long afterTime = System.currentTimeMillis();
		long setDiffTime = (afterTime - beforTime);
		System.out.println("time"+setDiffTime);
		System.out.println(count-1);  // 1번 컴퓨터를 제외
	}

	public static void BFS(int start, ArrayList<Integer>[] list, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while(q.size() != 0) {  // 큐가 빌때까지 반복
			start = q.poll(); 
			if(!visited[start]) {
				count++;
				visited[start] = true; 
				for(int i=0;i<list[start].size();i++) {
					q.add(list[start].get(i));
				}
			}
			
		}
	}
		
	
}
