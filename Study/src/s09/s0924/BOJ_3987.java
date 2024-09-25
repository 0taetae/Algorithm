package s09.s0924;

import java.io.*;
import java.util.*;

public class BOJ_3987 {

    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int PR, PC;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        PR = Integer.parseInt(st.nextToken()) - 1;
        PC = Integer.parseInt(st.nextToken()) - 1;

        int resTime = 0;
        char resDir = 'U';

        for (int i = 0; i < 4; i++) {
            int time = check(PR, PC, i);
            if (resTime < time) {
                switch (i) {
                    case 0: resDir = 'U'; break;
                    case 1: resDir = 'R'; break;
                    case 2: resDir = 'D'; break;
                    case 3: resDir = 'L'; break;
                }
                resTime = time;
            }
        }

        System.out.println(resDir);
        
        // 시그널이 항성계 내에서 무한히 전파
        if(resTime == Integer.MAX_VALUE) {
        	System.out.println("Voyager");
        }else {
        	System.out.println(resTime);
        } 
    }

    static int check(int r, int c, int dir) {
        int t = 1;
        boolean[][][] visited = new boolean[N][M][4];

        while (true) {
            int x = r + dx[dir];
            int y = c + dy[dir];
            
            // 시그널이 블랙홀이 있는 칸을 만나거나 항성계를 벗어남 
            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 'C') {
                return t;
            }
            // 같은 방향, 같은 위치 -> 시그널이 무한히 전파 
            if (visited[x][y][dir]) {
                return Integer.MAX_VALUE;
            }
            
            visited[x][y][dir] = true;

            if (map[x][y] == '/') {
                switch (dir) {
                    case 0: dir = 1; break;
                    case 1: dir = 0; break;
                    case 2: dir = 3; break;
                    case 3: dir = 2; break;
                }
            } else if (map[x][y] == '\\') {
                switch (dir) {
                    case 0: dir = 3; break;
                    case 1: dir = 2; break;
                    case 2: dir = 1; break;
                    case 3: dir = 0; break;
                }
            }
            t++; 
            r = x;
            c = y;
        }
    }
}
