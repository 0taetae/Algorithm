package s09.s0903;

import java.io.*;
import java.util.*;

public class SWEA_10966 {
    
    static int[] dx = {-1, 1, 0, 0};  // 행, 상하좌우  
    static int[] dy = {0, 0, -1, 1};  // 열
    static int N, M;
    static char[][] map;
    static int[][] minMove;
    
    static class Info {
        int x, y, cnt;
        Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            minMove = new int[N][M];  // 해당 땅까지 이동횟수 저장하는 배열 
            
            Queue<Info> q = new LinkedList<>();
            
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == 'W') {  // 물인 칸은 큐에 넣기
                        q.offer(new Info(r, c, 0));
                        minMove[r][c] = 0;
                    } else {
                    	minMove[r][c] = Integer.MAX_VALUE;
                    }
                }
            }
            
            while (!q.isEmpty()) {
                Info cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur.x + dx[j];
                    int y = cur.y + dy[j];
                    
                    if (x < 0 || y < 0 || x >= N || y >= M) continue;
                    
                    if (minMove[x][y] > cur.cnt + 1) {
                    	minMove[x][y] = cur.cnt + 1;
                        q.offer(new Info(x, y, cur.cnt + 1));
                    }
                }
            }
            
            int sum = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 'L') {
                        sum += minMove[r][c];
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
