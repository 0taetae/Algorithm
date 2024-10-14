package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
	
	static int V, E, start;
	static class Info implements Comparable<Info>{
		int end, weight;
		Info(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
        public int compareTo(Info o) {  // 가중치를 기준으로 정렬
            return this.weight - o.weight;
        }
	}
	
	static ArrayList<ArrayList<Info>> adjlst;
	static int[] dist;
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		// 2차원 인접리스트 
		adjlst = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			adjlst.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjlst.get(u).add(new Info(v, w)); 
		}
		
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0; 

		check(start);


		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	static void check(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info cur = pq.poll();

			if (cur.weight > dist[cur.end]) {
				continue;
			}

			for (Info next : adjlst.get(cur.end)) {
				int newDist = dist[cur.end] + next.weight;
				// 최단경로 
				if (newDist < dist[next.end]) {
					dist[next.end] = newDist;
					pq.add(new Info(next.end, newDist));
				}
			}
		}
	}
}
