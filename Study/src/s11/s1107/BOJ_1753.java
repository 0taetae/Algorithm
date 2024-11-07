package s11.s1107;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
	
	static class Info implements Comparable<Info>{
		int v,w;
		Info(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Info o) {
			return this.w - o.w;
			
		}
	}
	static ArrayList<ArrayList<Info>> adjList;
	static int[] dist;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		int K = Integer.parseInt(br.readLine());  // 시작 정점 번호
		adjList = new ArrayList<>();
		for(int i=0;i<=V;i++) {
			adjList.add(new ArrayList());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());  // 가중치
			adjList.get(u).add(new Info(v,w));
		}
		dist = new int[V+1];
		for(int i=0;i<=V;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[K] = 0;
		
		check(K);
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
			
		}

	}

	private static void check(int k) {
		PriorityQueue<Info> q = new PriorityQueue<>();
		q.add(new Info(k,0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			if(cur.w > dist[cur.v]) continue;
			
			for(Info next : adjList.get(cur.v)) {
				int nextDist = dist[cur.v] + next.w;
				if(nextDist >= dist[next.v]) continue;
				
				dist[next.v] = nextDist;
				q.add(new Info(next.v,dist[next.v]));
			}
		}
		
	}

}
