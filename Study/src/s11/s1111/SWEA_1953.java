package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_1953 {
    
    static int N,M,R,C,L;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Info{
        int x,y,dir,cnt;
        Info(int x, int y, int dir, int cnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int r=0;r<N;r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<M;c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            res = 1;
            bfs();
            System.out.println("#" + tc + " " + res);
        }
    }
    
    public static void bfs() {
        Queue<Info> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[R][C] = true;
        q.add(new Info(R,C,0,1));
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            if(cur.cnt>=L) {
                continue;
            }
            
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
                if(check(cur.x, cur.y, nx, ny, dir)) {
                    visited[nx][ny] = true;
                    q.add(new Info(nx,ny,dir,cur.cnt+1));
                    res++;
                }
            }
        }
    }

    private static boolean check(int x, int y, int nx, int ny, int dir) {
        int cur = map[x][y];
        int next = map[nx][ny];
        
        switch (dir) {
        case 0: // 상
            return (cur == 1 || cur == 2 || cur == 4 || cur == 7) &&
                   (next == 1 || next == 2 || next == 5 || next == 6);
        case 1: // 우
            return (cur == 1 || cur == 3 || cur == 4 || cur == 5) &&
                   (next == 1 || next == 3 || next == 6 || next == 7);
        case 2: // 하
            return (cur== 1 || cur == 2 || cur== 5 || cur == 6) &&
                   (next == 1 || next == 2 || next == 4 || next == 7);
        case 3: // 좌
            return (cur== 1 || cur == 3 || cur== 6 || cur== 7) &&
                   (next == 1 || next == 3 || next == 4 || next == 5);
        }
        return false;
    }
}