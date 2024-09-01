package s08.s0831;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

    static int V;
    static int[] parents;

    static void make() {
        parents = new int[V + 1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;

        return parents[a] = findSet(parents[a]);  // 집합의 대표자를 자신의 부모로 변경
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges);  // 간선의 가중치 기준으로 오름차순 정렬
        make();  // 모든 정점을 분리집합으로 

        int cnt = 0;
        int cost = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                cnt++;
                cost += edge.weight;
                if (cnt == V - 1) break;  // 최소신장트리 완성
            }
        }
        System.out.println(cost);
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
