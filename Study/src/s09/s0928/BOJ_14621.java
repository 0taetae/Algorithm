package s09.s0928;

import java.io.*;
import java.util.*;

public class BOJ_14621 {
    
    static int N, M;
    static ArrayList<Edge> lst;
    static class Edge implements Comparable<Edge> {
        int start, end, weight;
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static String[] school;
    static int[] parents;

    static void make() {
        parents = new int[N + 1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        parents[bRoot] = aRoot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        school = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            school[i] = st.nextToken();
        }

        lst = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lst.add(new Edge(u, v, d));
        }

        make();
        Collections.sort(lst);

        int cnt = 0;
        int res = 0;
        for (Edge edge : lst) {
        	// 남초 대학교와 여초 대학교만 연결 
            if (findSet(edge.start) != findSet(edge.end) && !school[edge.start].equals(school[edge.end])) {
                cnt++;
                res += edge.weight;
                union(edge.start, edge.end);
            }
        }

        if (cnt < N - 1) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}
