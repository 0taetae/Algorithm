package s10.s1015;

import java.io.*;
import java.util.*;

public class BOJ_21608 {
	
    // 상 좌 우 하
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    static int N;
    static int[][] room, likeNum;
    static ArrayList<Info> likeList;

    static class Info {
        int x, y, likeCnt, noCnt;
        Info(int x, int y, int likeCnt, int noCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.noCnt = noCnt;
        }
    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];

        likeNum = new int[N * N][5]; // 학생 번호와 그 학생이 좋아하는 학생 4명의 번호 
        
        for (int i = 0; i <= N * N; i++) {  // 
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            likeNum[i][0] = num;
            for (int j = 1; j <= 4; j++) {
                likeNum[i][j] = Integer.parseInt(st.nextToken());
                list.get(num).add(likeNum[i][j]);
            }
        }

        for (int i = 0; i < N * N; i++) {
            likePeople(i);
            if (likeList.size() > 1) {
                Collections.sort(likeList, (o1, o2) -> {
                    if (o1.likeCnt == o2.likeCnt) {
                        if (o1.noCnt == o2.noCnt) {
                            if (o1.x == o2.x) return o1.y - o2.y;  // y좌표 오름차순
                            return o1.x - o2.x;  // x좌표 오름차순
                        }
                        return o2.noCnt - o1.noCnt;  // 인접한 칸에 빈칸 수 내림차순 
                    }
                    return o2.likeCnt - o1.likeCnt;  // 인접한 칸에 좋아하는 사람 수 내림차순
                });
            }
            room[likeList.get(0).x][likeList.get(0).y] = likeNum[i][0];
        }

        System.out.println(check());
    }

    // 학생 만족도 총합
    public static int check() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    
                    // 좋아하는 사람에 포함되는지 확인
                    if (list.get(room[i][j]).contains(room[nx][ny])) {
                        cnt++;
                    }
                }
                switch (cnt) {
                    case 0:
                        res += 0;
                        break;
                    case 1:
                        res += 1;
                        break;
                    case 2:
                        res += 10;
                        break;
                    case 3:
                        res += 100;
                        break;
                    case 4:
                        res += 1000;
                        break;
                }
            }
        }
        return res;
    }

    // 좋아하는 학생이 인접한 칸에 몇명 있는지, 빈 칸이 인접한 칸에 몇개 있는지 
    public static void likePeople(int num) {
        likeList = new ArrayList<>();
        int maxLikeCnt = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j] != 0) continue;

                int cnt = 0;
                int noCnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    
                    // 인접한 칸의 빈칸 수 
                    if (room[nx][ny] == 0) {
                        noCnt++;
                    } 
                    // 인접한 칸의 좋아하는 사람 수 
                    else if (list.get(likeNum[num][0]).contains(room[nx][ny])) {
                        cnt++;
                    }
                }

                if (cnt > maxLikeCnt) {
                    maxLikeCnt = cnt;
                    likeList.clear();  // 이전보다 인접한 칸에 좋아하는 사람 수가 많은 경우 리스트 초기화 
                    likeList.add(new Info(i, j, cnt, noCnt));
                } else if (cnt == maxLikeCnt) {
                    likeList.add(new Info(i, j, cnt, noCnt));
                }
            }
        }
    }
}
