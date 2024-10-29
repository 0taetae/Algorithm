package s10.s1029;

import java.io.*;
import java.util.*;

public class BOJ_19236 {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int res = 0;

    static class Info {
        int x, y, dir;

        Info(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Info[] fishArr = new Info[17];
        int[][] map = new int[4][4];

        for (int r = 0; r < 4; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 4; c++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[r][c] = num;
                fishArr[num] = new Info(r, c, dir);
            }
        }

        int startFish = map[0][0];
        int startDir = fishArr[startFish].dir;
        fishArr[startFish].dir = -1; // 물고기 죽음
        map[0][0] = -1; // 상어 위치
        dfs(0, 0, startDir, map, fishArr, startFish);

        System.out.println(res);
    }

    static void dfs(int startX, int startY, int startDir, int[][] map, Info[] fishArr, int sum) {
        res = Math.max(res, sum);

        // 물고기 이동
        moveFish(map, fishArr);

        // 상어 이동
        for (int step = 1; step < 4; step++) {
            int nx = startX + dx[startDir] * step;
            int ny = startY + dy[startDir] * step;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] == 0) continue;

            int[][] tempMap = copyMap(map);
            Info[] tempFish = copyFish(fishArr);

            int target = tempMap[nx][ny];
            int newDir = tempFish[target].dir;

            tempFish[target].dir = -1; // 물고기 죽음
            tempMap[startX][startY] = 0;
            tempMap[nx][ny] = -1;  // 상어 위치 

            dfs(nx, ny, newDir, tempMap, tempFish, sum + target);
        }
    }

    static void moveFish(int[][] map, Info[] fishArr) {
        for (int i = 1; i <= 16; i++) {
            if (fishArr[i].dir == -1) continue;

            for (int j = 0; j < 8; j++) {
                int ndir = (fishArr[i].dir + j) % 8;
                int nx = fishArr[i].x + dx[ndir];
                int ny = fishArr[i].y + dy[ndir];

                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] == -1) continue;
                // 물고기가 있는 칸 
                if (map[nx][ny] > 0) {
                    int tempFish = map[nx][ny];
                    fishArr[tempFish].x = fishArr[i].x;
                    fishArr[tempFish].y = fishArr[i].y;
                    map[fishArr[i].x][fishArr[i].y] = tempFish;
                } 
                // 물고기가 없는 칸 
                else {
                    map[fishArr[i].x][fishArr[i].y] = 0;
                }

                fishArr[i].x = nx;
                fishArr[i].y = ny;
                fishArr[i].dir = ndir;
                map[nx][ny] = i;
                break;
            }
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[4][4];
        for(int r=0;r<4;r++) {
        	for(int c=0;c<4;c++) {
        		newMap[r][c]=map[r][c];
        	}
        }
        return newMap;
    }

    static Info[] copyFish(Info[] fishArr) {
    	Info[] newFish = new Info[17];
        for (int i = 1; i <= 16; i++) {
        	Info cur = fishArr[i];
            newFish[i] = new Info(cur.x, cur.y, cur.dir);
        }
        return newFish;
    }

}
