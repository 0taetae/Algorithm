package s10.s1030;

import java.io.*;
import java.util.*;

public class SWEA_1210 {

    // 좌, 우, 상 
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static boolean isOk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            map = new int[100][100];
            visited = new boolean[100][100];
            isOk = false;
            int startX = 0;
            int startY = 0;

            for (int r = 0; r < 100; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 100; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] == 2) {
                        startX = r;
                        startY = c;
                    }
                }
            }

            int res = check(startX, startY);
            System.out.println("#" + T + " " + res);
        }
    }

    private static int check(int x, int y) {
        if (x == 0) {
            isOk = true;
            return y;
        }

        visited[x][y] = true;

        for (int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100 && map[nx][ny] == 1 && !visited[nx][ny]) {
                int res = check(nx, ny);
                if (isOk) return res; 
            }
        }

        return -1;
    }
}
