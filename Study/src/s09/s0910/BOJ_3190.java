package s09.s0910;

import java.io.*;
import java.util.*;

public class BOJ_3190 {
    static ArrayList<Info> lst = new ArrayList<>();
    static int N, K, L;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};  // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Idx> snake = new ArrayList<>();
    static int time;

    static class Info {
        int sec;
        String dir;

        Info(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    static class Idx {
        int x, y;

        Idx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());  // 보드의 크기
        K = Integer.parseInt(br.readLine());  // 사과의 개수
        arr = new int[N + 1][N + 1];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr[R][C] = 1;
        }
        
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            lst.add(new Info(sec, dir));
        }
        
        game(1, 1, 1); // (1,1) 시작, 오른쪽 방향 
        System.out.println(time);
    }

    static void game(int r, int c, int dir) {
        time = 0;
        snake.add(new Idx(r, c));

        while (true) {
        	time++;
            int nx = r + dx[dir];
            int ny = c + dy[dir];

            // 벽에 부딪히면 게임 끝
            if (nx < 1 || ny < 1 || nx > N || ny > N) return;

            // 자기자신과 부딪히면 게임 끝
 			for(int i=0;i<snake.size();i++) {
 				Idx cur = snake.get(i);
 				if(cur.x==nx && cur.y==ny) return;
 			}

            // 이동한 칸에 사과가 있는 경우
            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                snake.add(new Idx(nx, ny));
            } else {
                snake.add(new Idx(nx, ny));
                // 꼬리가 위치한 칸 비워줌 
                snake.remove(0);
            }
            
            // 방향 변환 정보 체크
            if (!lst.isEmpty() && lst.get(0).sec == time) {
                if (lst.get(0).dir.equals("D")) {
                    dir = (dir + 1) % 4;
                } else if (lst.get(0).dir.equals("L")) {
                    dir = (dir + 3) % 4;
                }
                lst.remove(0);
            }
            

            r = nx;
            c = ny;
        }
    }
}
