package s09.s0910;

import java.io.*;
import java.util.*;

public class SWEA_2382 {
    
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, 0, -1, 1};
    static ArrayList<Info> micro;
    static Info[][] arr;
    
    static class Info {
        int x, y, cnt, dir;
        Info(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            micro = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                micro.add(new Info(r, c, cnt, dir));
            }


            for (int time = 0; time < M; time++) {
                arr = new Info[N][N]; 

                for (int i = 0; i < micro.size(); i++) {
                    Info cur = micro.get(i);
                    if (cur.cnt <= 0) continue;

                    int nx = cur.x + dx[cur.dir];
                    int ny = cur.y + dy[cur.dir];

                    // 약물 칠해진 셀에 도착하는 경우 
                    if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
                        cur.cnt /= 2; 
                        if (cur.dir == 1) cur.dir = 2;
                        else if (cur.dir == 2) {
                        	cur.dir = 1;
                        }
                        else if (cur.dir == 3) {
                        	cur.dir = 4;
                        }
                        else if (cur.dir == 4) {
                        	cur.dir = 3;
                        }
                    }
                    
                    // 두개 이상의 군집이 한 셀에 모이는 경우 
                    if (arr[nx][ny] != null) {
                        Info temp = arr[nx][ny];
                        if (temp.cnt < cur.cnt) {
                        	temp.dir = cur.dir;
                        }
                        temp.cnt += cur.cnt;
                    } else {
                    	arr[nx][ny] = new Info(nx, ny, cur.cnt, cur.dir);
                    }
                }

                micro.clear();
                // 미생물이 남아있는 군집 
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != null && arr[i][j].cnt > 0) {
                            micro.add(arr[i][j]);
                        }
                    }
                }
            }

            // 미생물 수 구하기 
            int res = 0;
            for (Info info : micro) {
                res += info.cnt;
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
}


