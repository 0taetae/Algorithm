package s10.s1021;

import java.io.*;
import java.util.*;

public class BOJ_20057 {

    static int N;
    static int[][] map;
    static int[][] sandSpread = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}
    }; // 모래 퍼지는 비율
    
    // 좌 하 우 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    // 격자의 밖으로 나간 모래의 양 
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int startR = N / 2;
        int startC = N / 2;

        int dir = 0;
        int move = 1; 

        while (startR != 0 || startC != 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < move; j++) {
                    int nextR = startR + dx[dir];
                    int nextC = startC + dy[dir];

                    if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                        continue;  
                    }

                    spread(nextR, nextC, dir);

                    startR = nextR;
                    startC = nextC;

                    if (startR == 0 && startC == 0) {
                    	System.out.println(res);
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }

        
    }

    private static void spread(int r, int c, int dir) {
        // 모래가 없는 경우
        if (map[r][c] == 0) return;

        int cur = map[r][c];
        int total = 0;

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (sandSpread[i + 2][j + 2] > 0) {
                    int spreadR = r + i;
                    int spreadC = c + j;
                    
                    if (spreadR < 0 || spreadC < 0 || spreadR >= N || spreadC >= N) {
                        res += (cur * sandSpread[i + 2][j + 2]) / 100;
                    } else {
                        int spreadSand = (cur * sandSpread[i + 2][j + 2]) / 100;
                        total += spreadSand;
                        map[spreadR][spreadC] += spreadSand;
                    }
                }
            }
        }

        // 남은 모래는 바로 앞에 쏟아짐
        int tempR = r + dx[dir];
        int tempC = c + dy[dir];
        int remainSand = cur - total;

        if (tempR < 0 || tempC < 0 || tempR >= N || tempC >= N) {
            res += remainSand;
        } else {
            map[tempR][tempC] += remainSand;
        }

        // 현재 좌표의 모래는 전부 없어짐
        map[r][c] = 0; 
    }
}
