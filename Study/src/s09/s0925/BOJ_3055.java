package s09.s0925;

import java.io.*;
import java.util.*;

public class BOJ_3055 {

    static int R, C;
    static char[][] map;
    static int startR, startC;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] waterTime; // 물이 도달하는 시간
    static int[][] targetTime; // 고슴도치가 도달하는 시간
    static Queue<Info> waterQueue = new LinkedList<>(); // 물 확산 BFS 큐

    static class Info {
        int x, y, time;

        Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());  // 행
        C = Integer.parseInt(st.nextToken());  // 열
        map = new char[R][C];
        waterTime = new int[R][C];
        targetTime = new int[R][C];

        for (int r = 0; r < R; r++) {
            Arrays.fill(waterTime[r], Integer.MAX_VALUE); // 물의 시간 초기화
            Arrays.fill(targetTime[r], Integer.MAX_VALUE); // 고슴도치 시간 초기화
        }

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'S') {  // 고슴도치 시작 위치
                    startR = r;
                    startC = c;
                    targetTime[r][c] = 0; // 고슴도치 시작 시간 0
                } else if (map[r][c] == '*') {  // 물
                    waterQueue.add(new Info(r, c, 0));
                    waterTime[r][c] = 0; // 물이 있는 곳은 시간 0
                }
            }
        }

        spreadWater(); // 물 퍼짐 BFS
        int result = bfs(); // 고슴도치 이동 BFS

        if (result == -1) {
            System.out.println("KAKTUS"); // 비버의 굴에 도착 불가
        } else {
            System.out.println(result); // 최소 시간 출력
        }
    }

    // 물이 퍼지는 BFS
    static void spreadWater() {
        while (!waterQueue.isEmpty()) {
            Info cur = waterQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == 'X' || map[nx][ny] == 'D' || waterTime[nx][ny] != Integer.MAX_VALUE) continue;

                waterTime[nx][ny] = cur.time + 1;
                waterQueue.add(new Info(nx, ny, cur.time + 1));
            }
        }
    }

    // 고슴도치가 이동하는 BFS
    static int bfs() {
        Queue<Info> targetQueue = new LinkedList<>();
        targetQueue.add(new Info(startR, startC, 0));

        while (!targetQueue.isEmpty()) {
            Info cur = targetQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == 'X' || targetTime[nx][ny] != Integer.MAX_VALUE) continue;

                // 비버의 굴에 도착한 경우
                if (map[nx][ny] == 'D') {
                    return cur.time + 1;
                }

                // 물보다 빨리 도착
                if (targetTime[cur.x][cur.y] + 1 < waterTime[nx][ny]) {
                	targetTime[nx][ny] = cur.time + 1;
                	targetQueue.add(new Info(nx, ny, cur.time + 1));
                }
            }
        }
        return -1; // 비버의 굴에 도착할 수 없는 경우
    }
}
