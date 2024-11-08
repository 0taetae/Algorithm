package s11.s1108;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

	static int V, E;

	static class Info implements Comparable<Info> {
		int start, end, weight;

		Info(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int compareTo(Info o) {
			return this.weight - o.weight;

		}

	}

	static int[] parent;

	static void make() {
		parent = new int[V + 1];
		Arrays.fill(parent, -1);
	}

	static int findset(int a) {
		if (parent[a] < 0) return a;
		return parent[a] = findset(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if (aRoot == bRoot) return false;

		parent[aRoot] += parent[bRoot];
		parent[bRoot] = aRoot;
		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());  // 정점 개수
		E = Integer.parseInt(st.nextToken());  // 간선 개수 
		Info[] Edge =new Info[E];
		

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Edge[i] = new Info(start, end, weight);
		}
		Arrays.sort(Edge);
		make();
		int res = 0;
		int cnt=0;
		for(int i=0;i<E;i++) {
			if(union(Edge[i].start, Edge[i].end)) {
				res+=Edge[i].weight;
				cnt++;
			}
			if(cnt==V-1) {
				break;
			}
		}
		System.out.println(res);

	}

}
