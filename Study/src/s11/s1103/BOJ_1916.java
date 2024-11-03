package s11.s1103;

import java.io.*;
import java.util.*;

public class BOJ_1916 {
	
	static int N, M;
	static class Info implements Comparable<Info> {
		int end, weight;
		Info(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
	}
	static ArrayList<ArrayList<Info>> adjLst;
	static int[] dist;
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjLst = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjLst.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjLst.get(a).add(new Info(b, w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		dijkstra();
		System.out.println(dist[end]);
	}

	private static void dijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info cur = pq.poll();

			if (cur.weight > dist[cur.end]) {
				continue;
			}

			for (Info next : adjLst.get(cur.end)) {
				int newDist = dist[cur.end] + next.weight;
				if (newDist < dist[next.end]) {
					dist[next.end] = newDist;
					pq.add(new Info(next.end, newDist));
				}
			}
		}
	}
}
