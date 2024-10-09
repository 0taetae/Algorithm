package s10.s1009;

import java.io.*;
import java.util.*;

public class BOJ_13418 {

    static int N, M;

    static class Info {
        int start, end, state;

        Info(int start, int end, int state) {
            this.start = start;
            this.end = end;
            this.state = state;
        }
    }

    static ArrayList<Info> edges = new ArrayList<>();
    static int[] parent;

    static void make() {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i; 
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
        }
    }
    static int check(ArrayList<Info> edges) {
    	make();
        int up = 0;
        int cnt = 0;

        for (Info edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                if (edge.state == 0) {  // 오르막길   
                    up++;
                }
                cnt++;
                if (cnt == N) break; 
            }
        }
    	return up;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 건물의 개수
        M = Integer.parseInt(st.nextToken());  // 도로의 개수

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());  // 0 오르막길, 1 내리막길 
            edges.add(new Info(a, b, c));
        }

        // 최악의 코스: 내리막길 적게, 오르막길 많이
        Collections.sort(edges, (o1, o2) -> o2.state - o1.state);
        int worst = check(edges);

        // 최적의 코스: 내리막길 많이, 오르막길 적게
        Collections.sort(edges, (o1, o2) -> o1.state - o2.state); 
        int best = check(edges);
        
        // 최종 피로도의 차이 = 최악의 코스(오르막 개수) - 최적의 코스(오르막 개수)
        int res = worst * worst - best * best;
        System.out.println(Math.abs(res));
    }
}
