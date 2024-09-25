package s09.s0925;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxCnt;
    static char[][] map;
    static char ans;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[] dir = {'U', 'R', 'D', 'L'};

    static class Point {
        int x, y, cnt;
        char initDir;

        public Point(int x, int y, int cnt, char initDir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.initDir = initDir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        maxCnt = 0;

        bfs(r, c);
        System.out.println(ans);
        if (maxCnt > 250000) {
            System.out.println("Voyager");
        } else {
            System.out.println(maxCnt);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            int direction = i;
            q.offer(new Point(x, y, cnt, dir[direction]));
            while (!q.isEmpty()) {
                Point tmp = q.poll();

                if (tmp.cnt > 250000) {
                    maxCnt = tmp.cnt;
                    ans = tmp.initDir;
                    return; // Voyager
                } else if (tmp.cnt > maxCnt) {
                    maxCnt = tmp.cnt;
                    ans = tmp.initDir;
                }

                int nx = tmp.x + dx[direction];
                int ny = tmp.y + dy[direction];


                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'C') {
                    if (map[nx][ny] == '/' || map[nx][ny] == '\\') {
                        direction = change(direction, map[nx][ny]);
                    }
                    cnt++;
                    q.offer(new Point(nx, ny, cnt, tmp.initDir));

                } else {
                    break;
                }
            }
        }
    }

    static int change(int d, char c) {
        // U -> / -> R
        if (dir[d] == 'U' && c == '/') {
            return 1;
        }
        // U -> \ -> L
        else if (dir[d] == 'U' && c == '\\') {
            System.out.println("U -> R");
            return 3;
        }
        // R -> / -> D
        else if (dir[d] == 'R' && c == '/') {
            return 2;
        }
        // R -> \ -> U
        else if (dir[d] == 'R' && c == '\\') {
            return 0;
        }
        // D -> / -> L
        else if (dir[d] == 'D' && c == '/') {
            return 3;
        }
        // D -> \ -> R
        else if (dir[d] == 'D' && c == '\\') {
            return 1;
        }
        // L -> / -> U
        else if (dir[d] == 'L' && c == '/') {
            return 0;
        }
        // L -> \ -> D
        else if (dir[d] == 'L' && c == '\\') {
            return 2;
        }
        return -1;
    }
}