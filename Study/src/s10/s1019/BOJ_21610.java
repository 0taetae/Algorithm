package s10.s1019;

import java.io.*;
import java.util.*;

public class BOJ_21610 {

    static int N, M;
    static int[][] map;
    static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    static ArrayList<Info> cloudList = new ArrayList<>();
    static boolean[][] visited;

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

        map = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); // 해당 칸(바구니)에 저장되어 있는 물의 양
            }
        }

        // 비바라기를 시전 -> 비구름 생김
        cloudList.add(new Info(N, 1));
        cloudList.add(new Info(N, 2));
        cloudList.add(new Info(N - 1, 1));
        cloudList.add(new Info(N - 1, 2));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            // 1. 모든 구름이 d 방향으로 s칸 이동
            move(d, s);

            // 3. 물복사 버그 마법 시전 (구름이 사라지기 전 적용해야 함)
            for (int j = 0; j < cloudList.size(); j++) {
                Info cur = cloudList.get(j);
                magic(cur.x, cur.y);
            }

            // 4. 구름이 모두 사라짐
            cloudList.clear();
            
            // 5. 새로운 구름 생성
            cloudMake();
        }

        // 바구니에 들어있는 물의 양의 합
        int res = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                res += map[r][c];
            }
        }
        System.out.println(res);
    }

    public static void move(int d, int s) {
        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i < cloudList.size(); i++) {
            Info cur = cloudList.get(i);

            int nx = (cur.x + dx[d] * s) % N;
            int ny = (cur.y + dy[d] * s) % N;

            if (nx <= 0) nx += N;
            if (ny <= 0) ny += N;

            // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양 1 증가
            map[nx][ny]++;
            visited[nx][ny] = true;

            cloudList.set(i, new Info(nx, ny));
        }
    }

    // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수 만큼 물의 양 증가
    public static void magic(int r, int c) {
        int cnt = 0;
        for (int i = 2; i <= 8; i += 2) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx > 0 && ny > 0 && nx <= N && ny <= N && map[nx][ny] > 0) {
                cnt++;
            }
        }
        map[r][c] += cnt;
    }

    public static void cloudMake() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                // 구름이 생겼던 칸이 아니고, 바구니에 저장된 물의 양이 2이상인 모든 칸 
                if (!visited[r][c] && map[r][c] >= 2) {
                    cloudList.add(new Info(r, c));
                    // 물의 양 2 감소 
                    map[r][c] -= 2;
                }
            }
        }
    }
}
