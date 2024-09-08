package s09.s0906;

import java.io.*;
import java.util.*;

public class BOJ_17244 {

    static int N, M;
    static char[][] house;
    static boolean[][] visited;
    static int startX, startY, endX, endY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Indx> lst = new ArrayList<>();
    static int[][] adj;
    static int res;

    static class Indx {
        int x, y;

        Indx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Info {
        int x, y, cnt;

        Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static boolean[] isSelected;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 열
        M = Integer.parseInt(st.nextToken());  // 행

        house = new char[M][N];
        for (int r = 0; r < M; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                house[r][c] = str.charAt(c);
                if (house[r][c] == 'S') {
                    startX = r;
                    startY = c;
                } else if (house[r][c] == 'E') {
                    endX = r;
                    endY = c;
                } else if (house[r][c] == 'X') {
                    lst.add(new Indx(r, c));
                }
            }
        }
        
        // 출발점과 도착점 추가
        lst.add(new Indx(startX, startY));  // 출발점
        lst.add(new Indx(endX, endY));      // 도착점
        int size = lst.size();
        adj = new int[size][size]; // 각 지점 간 거리
        isSelected = new boolean[size - 2]; // 시작점과 끝점 제외한 물건들
        select = new int[size - 2]; // 물건을 가져갈 순서
        res = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }

        //물건과 출발,도착지점 간 거리 구하기
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                bfs(i, j);
            }
        }
        if(lst.size()==2) {
        	System.out.println(adj[0][1]);
        	return;
        }
        // 물건 가져가는 순서에 대한 순열
        perm(0);
        System.out.println(res);
    }

    // BFS로 두 지점 간의 거리 구하기
    static void bfs(int a, int b) {
        Queue<Info> q = new LinkedList<>();
        visited = new boolean[M][N];
        q.offer(new Info(lst.get(a).x, lst.get(a).y, 0));
        visited[lst.get(a).x][lst.get(a).y] = true;

        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                // 범위를 벗어나거나, 방문했거나, 벽인 경우
                if (x < 0 || y < 0 || x >= M || y >= N || visited[x][y] || house[x][y] == '#') continue;

                if (x == lst.get(b).x && y == lst.get(b).y) {
                    adj[a][b] = Math.min(adj[a][b], cur.cnt + 1);
                    adj[b][a] = adj[a][b];
                    return;
                }

                q.offer(new Info(x, y, cur.cnt + 1));
                visited[x][y] = true;
            }
        }
    }

    // 물건 가져가는 순서에 대한 순열 생성
    static void perm(int cnt) {
        if (cnt == lst.size() - 2) {
            minLength(select);
            return;
        }

        for (int i = 0; i < lst.size() - 2; i++) {
            if (!isSelected[i]) {
                select[cnt] = i;
                isSelected[i] = true;
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    // 순열에 따라 거리합 최솟값 구하기
    static void minLength(int[] select) {
        int sum = 0;

        // 출발점에서 첫 번째 물건까지 거리
        if (adj[lst.size() - 2][select[0]] == Integer.MAX_VALUE) return;
        sum += adj[lst.size() - 2][select[0]];

        // 물건들 간의 거리
        for (int i = 0; i < lst.size() - 3; i++) {
            if (adj[select[i]][select[i + 1]] == Integer.MAX_VALUE) return;
            sum += adj[select[i]][select[i + 1]];
        }

        // 마지막 물건에서 도착점까지 거리
        if (adj[select[lst.size() - 3]][lst.size() - 1] == Integer.MAX_VALUE) return;
        sum += adj[select[lst.size() - 3]][lst.size() - 1];

        res = Math.min(res, sum);
    }
}
