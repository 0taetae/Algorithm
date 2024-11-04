package s11.s1104;

import java.io.*;
import java.util.*;

public class BOJ_1719 {
    
    static int N, M;
    static int[][] dist, first;
    static ArrayList<ArrayList<Info>> adjLst;
    
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjLst = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjLst.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjLst.get(a).add(new Info(b, w));
            adjLst.get(b).add(new Info(a, w));
        }
        
        dist = new int[N + 1][N + 1];
        first = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    System.out.print("- ");
                } else {
                    System.out.print(first[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        dist[start][start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            int curNode = cur.end;
            int curWeight = cur.weight;

            if (curWeight > dist[start][curNode]) continue;

            for (Info next : adjLst.get(curNode)) {
                int nextNode = next.end;
                int nextWeight = curWeight + next.weight;

                if (nextWeight < dist[start][nextNode]) {
                    dist[start][nextNode] = nextWeight;
                    pq.add(new Info(nextNode, nextWeight));

                    if (curNode == start) {
                        first[start][nextNode] = nextNode;
                    } else {
                        first[start][nextNode] = first[start][curNode];
                    }
                }
            }
        }
    }
}
