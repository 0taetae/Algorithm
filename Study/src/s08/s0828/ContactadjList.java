package s08.s0828;

import java.io.*;
import java.util.*;

public class ContactadjList {

	static Node[] adjList;
	static int[] score;
	
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=1;i<=10;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			score = new int[101];
			adjList = new Node[101];
			for(int j=1;j<=N/2;j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
			}
			int Max = 0;
			int result =0;
			
			bfs(start);
			
			for(int j=1;j<=100;j++) {
				Max = Math.max(Max, score[j]);
			}
			
			for(int j=1;j<=100;j++) {
				if(score[j]==Max) {
					result = Math.max(result, j);
				}
			}
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean visited[] = new boolean[101];

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
		    for(Node temp = adjList[current]; temp != null; temp = temp.next) {
		    	if(!visited[temp.to]) {
		        	queue.offer(temp.to);
		            visited[temp.to] = true;
		            score[temp.to]=score[current]+1;
		    	}
		    }
		}
	}
}
