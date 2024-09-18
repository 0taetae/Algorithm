package s09.s0917;

import java.io.*;
import java.util.*;

public class BOJ_1774 {
	
	static int N, M;
	static class Info {
		int x, y;
		Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;
		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static Info[] nodes;
	static ArrayList<Edge> edges;
	static int[] parents;

	static void make() {
		parents = new int[N + 1];
		Arrays.fill(parents, -1);
	}

	static int findSet(int a) {
		if (parents[a]<0) return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make();

		// 각 우주신들의 x, y 좌표
		nodes = new Info[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Info(x, y);
		}

		// 이미 연결된 통로
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 우주신 간의 거리 
		edges = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double w = Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
				edges.add(new Edge(i, j, w));
			}
		}

		// 통로의 길이를 기준으로 오름차순 정렬
		Collections.sort(edges);

		double res = 0;
		for (Edge edge : edges) {
			// 연결되지 않은 두 우주신 연결
			if (union(edge.start, edge.end)) {
				res += edge.weight;
			}
		}

		System.out.printf("%.2f", res);
	}
}
