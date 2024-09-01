package s09.s0901;

import java.io.*;
import java.util.*;

public class BOJ_17472 {

    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] arr;  // 2차원 격자 
    static boolean[][] visited;  // 섬 탐색할 때, 방문 표시
    static int[][] bridgeMatrix;  // 다리길이 행렬
    static int islandTotal;  // 섬의 총 개수 
    static int num;  // 섬 번호 

    static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        markIslands();

        // 다리길이 행렬을 최대값으로 초기화
        bridgeMatrix = new int[islandTotal + 1][islandTotal + 1];
        for (int i = 1; i <= islandTotal; i++) {
            Arrays.fill(bridgeMatrix[i], Integer.MAX_VALUE);
        }

        // 다리 연결
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] != 0) {
                    num = arr[r][c];
                    for (int dir = 0; dir < 4; dir++) {
                        bridge(r, c, dir, 0);
                    }
                }
            }
        }

        System.out.println(kruskal());
    }

    // 섬의 번호 매기기 
    static void markIslands() {
        int islandNum = 1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] == 1 && !visited[r][c]) {
                    numCheck(r, c, islandNum);
                    islandNum++;
                }
            }
        }
        islandTotal = islandNum - 1;  // 섬의 총 개수
    }

    // 연결된 섬을 탐색하고 번호를 매김
    static void numCheck(int r, int c, int islandNum) {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(r, c));
        visited[r][c] = true;
        arr[r][c] = islandNum;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || arr[x][y] != 1) continue;

                q.offer(new Info(x, y));
                visited[x][y] = true;
                arr[x][y] = islandNum;
            }
        }
    }

    // 다리 길이 계산
    static void bridge(int r, int c, int dir, int cnt) {
        int x = r + dx[dir];
        int y = c + dy[dir];

        if (x < 0 || y < 0 || x >= N || y >= M) return;
        
        // 바다에만 다리 건설 
        if (arr[x][y] == 0) {
            bridge(x, y, dir, cnt + 1);
        } else if (arr[x][y] != num && cnt >= 2) { // 해당 섬 번호가 아님 && 다리 길이 2 이상 
            bridgeMatrix[num][arr[x][y]] = Math.min(cnt, bridgeMatrix[num][arr[x][y]]);
            bridgeMatrix[arr[x][y]][num] = bridgeMatrix[num][arr[x][y]];
        }
    }
    
    // 다리 정보를 저장 
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parents;

    static void make() {
        parents = new int[islandTotal + 1];
        Arrays.fill(parents, -1);
    }

    static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }
    // 모든 섬을 연결하는 다리 길이의 최솟값 
    static int kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= islandTotal; i++) {
            for (int j = i + 1; j <= islandTotal; j++) {
                if (bridgeMatrix[i][j] != Integer.MAX_VALUE) {
                    pq.offer(new Edge(i, j, bridgeMatrix[i][j]));
                }
            }
        }

        make();

        int cnt = 0;
        int cost = 0;
        while (!pq.isEmpty() && cnt < islandTotal - 1) {
            Edge edge = pq.poll();
            if (union(edge.from, edge.to)) {
                cost += edge.weight;
                cnt++;
            }
        }
        // 모든 섬을 연결하지 못하는 경우 
        if (cnt != islandTotal - 1) {
            return -1;
        }

        return cost;
    }
}
