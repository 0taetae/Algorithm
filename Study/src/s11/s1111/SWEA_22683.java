package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_22683 {
	
	
	
	// PQ 사용한 풀이 해결해보기
	
	
	
    
    static int N, K;
    static char[][] map;
    static int startX, startY, endX, endY;
    static class Info implements Comparator<Info>{
        int x, y, cnt, time, dir;
        Info(int x, int y, int dir, int cnt, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;  // 남은 나무 베기 횟수
            this.time = time;  // 조작 횟수 
        }
		@Override
		public int compare(Info o1, Info o2) {
			return o1.time-o2.time;
		}
    }
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 필드의 크기
            K = Integer.parseInt(st.nextToken());  // 나무를 벨 수 있는 횟수 
            map = new char[N][N];
            res = Integer.MAX_VALUE;
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == 'X') {
                        startX = r;
                        startY = c;
                    } else if (map[r][c] == 'Y') {
                        endX = r;
                        endY = c;
                    }
                }
            }
            bfs();
            if(res == Integer.MAX_VALUE) {
            	System.out.println("#" + tc + " " + (-1));
            }else {
            	System.out.println("#" + tc + " " + res);
            }
            
        }
    }

    public static void bfs() {
    	PriorityQueue<Info> q = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][N][K+1];  // 행, 열, 방향, 나무 베고 남은 횟수 
        q.add(new Info(startX, startY, 0, K, 0));
        visited[startX][startY][K] = true;
        
        while (!q.isEmpty()) {
            Info cur = q.poll();
            
            if (cur.x == endX && cur.y == endY) {
                res = Math.min(res, cur.time);
                continue;
            }
            
            // 우회전
            int nextDir = (cur.dir + 1) % 4;
            if (!visited[cur.x][cur.y][cur.cnt]) {
                q.add(new Info(cur.x, cur.y, nextDir, cur.cnt, cur.time + 1));
                visited[cur.x][cur.y][cur.cnt] = true;
            }
            
            // 좌회전
            nextDir = (cur.dir - 1 + 4) % 4;
            if (!visited[cur.x][cur.y][cur.cnt]) {
                q.add(new Info(cur.x, cur.y, nextDir, cur.cnt, cur.time + 1));
                visited[cur.x][cur.y][cur.cnt] = true;
            }
            
            // 직진
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            // 이동할 칸이 나무일 경우 
            if (map[nx][ny] == 'T') {
            	// 나무를 벨 수 있는 경우 
                if (cur.cnt > 0 && !visited[nx][ny][cur.cnt-1]) {
                    q.add(new Info(nx, ny, cur.dir, cur.cnt - 1, cur.time + 2));
                    visited[nx][ny][cur.cnt-1] = true;
                }
            } else if (!visited[nx][ny][cur.cnt]) {
                q.add(new Info(nx, ny, cur.dir, cur.cnt, cur.time + 1));
                visited[nx][ny][cur.cnt] = true;
            }
        }
    }
}