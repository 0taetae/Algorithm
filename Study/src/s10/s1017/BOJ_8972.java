package s10.s1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_8972 {

    static int R, C;
    static int startR, startC;
    
    static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static ArrayList<Integer> comList = new ArrayList<>();
    static ArrayList<Info> madList = new ArrayList<>();
    static boolean isLose = false;

    // 좌하, 하, 우하, 좌, 정지, 우, 좌상, 상, 우상
    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'I') {
                    startR = r;
                    startC = c;
                } else if (map[r][c] == 'R') {
                    madList.add(new Info(r, c));
                }
            }
        }

        // 종수가 움직이려는 방향
        String command = br.readLine();
        for (int i = 0; i < command.length(); i++) {
            comList.add(command.charAt(i) - '0');
        }

        for (int i = 0; i < comList.size(); i++) {
            personMove(comList.get(i) - 1);
            if (isLose) {
                System.out.println("kraj " + (i + 1));
                return;
            }
            madMove();
            if (isLose) {
                System.out.println("kraj " + (i + 1));
                return;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }

    // 종수 이동
    public static void personMove(int com) {
        int nextR = startR + dx[com];
        int nextC = startC + dy[com];

        if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
            isLose = true;  
            return;
        }

        map[startR][startC] = '.';
        startR = nextR;
        startC = nextC;

        if (map[startR][startC] == 'R') {
            isLose = true;
        } else {
            map[startR][startC] = 'I';
        }
    }

    // 미친 아두이노 이동
    public static void madMove() {
        int[][] tempMap = new int[R][C]; 
        ArrayList<Info> newMadList = new ArrayList<>(); 

        for (int i = 0; i < madList.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            int targetX = 0;
            int targetY = 0;

            for (int dir = 0; dir < 9; dir++) {
                int nx = madList.get(i).x + dx[dir];
                int ny = madList.get(i).y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    int dist = Math.abs(nx - startR) + Math.abs(ny - startC);
                    if (dist < minDist) {
                        minDist = dist;
                        targetX = nx;
                        targetY = ny;
                    }
                }
            }

            if (map[targetX][targetY] == 'I') {
                isLose = true;
                return;
            }

            tempMap[targetX][targetY]++;
            newMadList.add(new Info(targetX, targetY));
        }

        for (int i = 0; i < madList.size(); i++) {
            map[madList.get(i).x][madList.get(i).y] = '.';
        }

        madList = newMadList;
        check(tempMap);
    }

    // 2개 이상의 미친 아두이노가 같은 칸에 있는지 확인
    public static void check(int[][] tempMap) {
        ArrayList<Info> updatedMadList = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (tempMap[r][c] == 1) { 
                    map[r][c] = 'R';
                    updatedMadList.add(new Info(r, c));
                } else if (tempMap[r][c] > 1) { 
                    map[r][c] = '.';
                }
            }
        }

        madList = updatedMadList; 
    }
}
