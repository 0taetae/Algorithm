package s0828;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CastleDefence {
    static int N, M, D;
    static int[][] arr;
    static int[][] copyarr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; // 적의 위치
        copyarr = new int[N][M]; // 원본 배열 복사
        result = 0; // 최대 제거 적의 수

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                copyarr[r][c] = arr[r][c]; // 원본 배열 복사
            }
        }

        int[] select = new int[3];
        
        archerSelect(0, 0, select);
        System.out.println(result);
    }

    // 조합으로 궁수 배치
    public static void archerSelect(int cnt, int start, int[] select) {
        if (cnt == 3) {
        	for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    copyarr[r][c] = arr[r][c];
                }
            }
            game(select);
            return;
        }
        for (int i = start; i < M; i++) {
            select[cnt] = i;
            archerSelect(cnt + 1, i + 1, select);
        }
    }
    public static void game(int[] select) {
    	int count = 0; // 제거된 적의 수

        while (true) {
            boolean[][] visit = new boolean[N][M]; // 적의 공격 여부
            boolean remain = false; // 현재 적이 존재하는지 여부

            // 각 궁수의 공격 처리
            for (int j = 0; j < 3; j++) {
                int archerCol = select[j]; // 현재 궁수의 열 위치
                int minDist = Integer.MAX_VALUE;
                int targetRow = -1, targetCol = -1; // 공격할 적의 위치

                // 모든 적을 대상으로 거리 계산
                for (int r = N - 1; r >= 0; r--) {
                    for (int c = 0; c < M; c++) {
                        if (arr[r][c] == 1) {
                            int dist = Math.abs(N - r) + Math.abs(archerCol - c); // 궁수와 적의 거리
                            if (dist <= D) { // 거리 제한 내에 있는 경우
                                if (dist < minDist || (dist == minDist && c < targetCol)) {
                                	minDist = dist; // 더 가까운 적을 선택
                                    targetRow = r;
                                    targetCol = c;
                                }
                            }
                        }
                    }
                }

                // 가장 가까운 적을 공격
                if (targetRow != -1 && targetCol != -1) {
                    visit[targetRow][targetCol] = true;
                    remain = true; // 적이 공격당했으므로 true
                }
            }

            // 현재 적이 없으면 게임 종료
            if (!remain) {
                break;
            }

            // 적 제거
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visit[r][c]) {
                        arr[r][c] = 0;
                        count++;
                    }
                }
            }

            // 적을 아래로 한 칸 이동
            for (int c = 0; c < M; c++) {
                for (int r = N - 1; r > 0; r--) {
                    arr[r][c] = arr[r - 1][c];
                }
                arr[0][c] = 0; 
            }

            result = Math.max(count, result);
        }
    }
}

