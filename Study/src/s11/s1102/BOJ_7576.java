package s11.s1102;

import java.io.*;
import java.util.*;

public class BOJ_7576 {

    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Info> q = new LinkedList<>();
    static int cnt, totalCnt, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt = 0;
        totalCnt = 0;
        res = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    q.add(new Info(r, c));
                } else if (map[r][c] == 0) {
                    totalCnt++;  
                }
            }
        }

        if (totalCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        if (cnt == totalCnt) {
            System.out.println(res - 1);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;

                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.offer(new Info(nx, ny));
                cnt++;
                res = Math.max(res, map[nx][ny]);
            }
        }
    }
}
