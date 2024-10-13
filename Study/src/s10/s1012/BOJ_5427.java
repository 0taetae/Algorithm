package s10.s1012;

import java.io.*;
import java.util.*;

public class BOJ_5427 {

    static int w, h;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Info {
        int x, y, time;
        Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static Queue<Node> fireQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());  // 너비
            h = Integer.parseInt(st.nextToken());  // 높이
            map = new char[h][w];

            fireQueue = new LinkedList<>();
            int startR = 0;
            int startC = 0;
            for (int r = 0; r < h; r++) {
                String line = br.readLine();
                for (int c = 0; c < w; c++) {
                    map[r][c] = line.charAt(c);
                    if (map[r][c] == '@') {  // 상근이 위치
                    	startR = r;
                    	startC = c;
                        map[r][c] = '.'; 
                    } else if (map[r][c] == '*') {  // 불의 위치
                        fireQueue.add(new Node(r, c));
                    }
                }
            }

            int res = bfs(startR,startC);  
            if (res == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(res);
            }
        }
    }

    private static int bfs(int r, int c) {
    	Queue<Info> personQueue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        
        personQueue.add(new Info(r,c,0));  // 상근이 시작 위치 

        while (!personQueue.isEmpty()) {

            // 불 확산
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Node fire = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        fireQueue.add(new Node(nx, ny));
                    }
                }
            }

            // 상근이 이동
            int personSize = personQueue.size();
            for (int i = 0; i < personSize; i++) {
                Info person = personQueue.poll();
                int x = person.x;
                int y = person.y;
                int time = person.time;

                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                    return time + 1;  
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        personQueue.add(new Info(nx, ny, time + 1));
                    }
                }
            }
        }

        return -1; 
    }
}


