package s10.s1024;

import java.io.*;
import java.util.*;

public class BOJ_20057 {

	static int N;
    static int[][] map;
    
    // 모래 퍼지는 비율
    // 왼쪽으로 이동 
    static int[][] sandSpread1 = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}
    }; 
    // 아래로 이동
    static int[][] sandSpread2 = {
    		{0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {2, 7, 0, 7, 2},
            {0, 10, 0, 10, 0},
            {0, 0, 5, 0, 0}
    		
    };
    // 오른쪽으로 이동
    static int[][] sandSpread3 = {
    		{0, 0, 2, 0, 0},
            {0, 1, 7, 10, 0},
            {0, 0, 0, 7, 5},
            {0, 1, 7, 10, 0},
            {0, 0, 2, 0, 0}
    };
    // 위로 이동
    static int[][] sandSpread4 = {
    		{0, 0, 5, 0, 0},
            {0, 10, 0, 10, 0},
            {2, 7, 0, 7, 2},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0}
    };
    
    
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
        
        // startR, startC : x
        int startR = N / 2;
        int startC = N / 2;
        int dir = 0;
        int move = 1; 
        while (startR != 0 || startC != 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < move; j++) {
                	// nextR, nextC : y
                    int nextR = startR + dx[dir];
                    int nextC = startC + dy[dir];
                    if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                        continue;  
                    }
                    
                    // 모래 퍼뜨리기 
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
        int cur = map[r][c];  // 현재 칸의 모래 양
        int total = 0;        // 퍼진 모래 합
        int[][] spreadMap;
        if (dir == 0) spreadMap = sandSpread1;
        else if (dir == 1) spreadMap = sandSpread2;
        else if (dir == 2) spreadMap= sandSpread3;
        else spreadMap = sandSpread4;
        // 퍼지는 모래 계산
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (spreadMap[i + 2][j + 2] > 0) {
                    int spreadR = r + i;
                    int spreadC = c + j;
                    int spreadAmount = (cur * spreadMap[i + 2][j + 2]) / 100;
                    
                    // 격자 밖으로 나간 모래
                    if (spreadR < 0 || spreadC < 0 || spreadR >= N || spreadC >= N) {
                        res += spreadAmount;  
                    } else {
                        map[spreadR][spreadC] += spreadAmount;
                    }
                    total += spreadAmount;
                }
            }
        }
        int tempR = r + dx[dir];
        int tempC = c + dy[dir];
        int remainingSand = cur - total;  // 남은 모래 
        
        // 격자 밖으로 나간 모래
        if (tempR < 0 || tempC < 0 || tempR >= N || tempC >= N) {
            res += remainingSand;  
        } else {
            map[tempR][tempC] += remainingSand; 
        }
        map[r][c] = 0;
    }
}
