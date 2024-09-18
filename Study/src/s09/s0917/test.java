package s09.s0917;

import java.io.*;
import java.util.*;

public class test {

    static int N, M;
    static int[][] map, linked;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;

    static class Node implements Comparable<Node> {
        int from, to;
        double value;

        Node(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public int compareTo(Node o) {
            return Double.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 우주신 개수
        M = Integer.parseInt(st.nextToken()); // 연결 통로 개수

        map = new int[N][2];
        linked = new int[M][2];
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // N개의 줄 : 우주신 좌표
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); // 연결된 통로
            for(int j = 0; j < 2; j++) {
                linked[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        init();
        initNode();

        // 기존 연결통로 처리
        for (int i = 0; i < linked.length; i++) {
            union(linked[i][0]-1, linked[i][1]-1);
        }

        double total = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int from = find(node.from);
            int to = find(node.to);

            if (!isSame(from, to)) {
                total += node.value;
                union(node.from, node.to);
            }

        }

        System.out.printf("%.2f", total);

    }

    static void init() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    // 조합 + 길이 -> pq추가
    static void initNode() {
        int size = map.length;
        for (int i = 0; i < size - 1; i++) {
            int x1 = map[i][0], y1 = map[i][1];
            for (int j = i + 1; j < size; j++) {
                int x2 = map[j][0], y2 = map[j][1];
                double dist = calDist(x1, y1, x2, y2);
                pq.offer(new Node(i, j, dist));
            }
        }
    }

    static double calDist(int x1, int y1, int x2, int y2) {
        long w = x2 - x1;
        long h = y2 - y1;
        return Math.sqrt(w*w + h*h);
}

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
    }

    static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        return false;
    }
}
