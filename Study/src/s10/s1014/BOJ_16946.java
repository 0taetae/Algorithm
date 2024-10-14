package s10.s1014;

import java.util.*;
import java.io.*;

public class BOJ_16946 {

    static int N, M;
    static int[][] arr;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num = 1;
    
    static class Info {
        int x, y, cnt;
        Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        area = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j+1] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    int areaCnt = bfs(i, j);
                    map.put(num, areaCnt);
                    num++;
                }
            }
        }

        HashSet<Integer> set;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 1) {
                    int res = 0;
                    set = new HashSet<>();
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];
                        if (x < 1 || y < 1 || x > N || y > M || set.contains(area[x][y]) || arr[x][y] == 1) continue;
                        set.add(area[x][y]);
                        res += map.get(area[x][y]);
                    }
                    res++;
                    System.out.print(res % 10);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    // 0의 영역 구하기
    public static int bfs(int r, int c) {
        Queue<Info> q = new LinkedList<>();
        ArrayList<Info> lst = new ArrayList<>();
        visited[r][c] = true;
        area[r][c] = num;
        q.add(new Info(r, c, 1));
        lst.add(new Info(r, c, 1));

        while (!q.isEmpty()) {
            Info cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny] || arr[nx][ny] == 1) 
                    continue;

                q.add(new Info(nx, ny, cur.cnt + 1));
                lst.add(new Info(nx, ny, cur.cnt + 1));
                visited[nx][ny] = true;
                area[nx][ny] = num;
            }
        }

        return lst.size();
    }
}
