package s0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CastleDefence {
    static int N, M, D; 
    static int[][] arr; 
    static int result;
    static int[][] copyarr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

        arr = new int[N][M]; 
        copyarr = new int[N][M];
        result = 0; 


        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] select = new int[3]; 
        archer(0, 0, select); 
        System.out.println(result);
    }

    // 조합으로 궁수 선택
    public static void archer(int cnt, int start, int[] select) {
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
            archer(cnt + 1, i + 1, select);
        }
    }

    public static void game(int[] select) {
        int count = 0; // 제거된 적의 수

        while (true) {
            boolean[][] visit = new boolean[N][M]; // 적의 공격 여부
            boolean isTarget = false; // 현재 적이 존재하는지 여부

            for (int j = 0; j < 3; j++) {
                int archerCol = select[j]; 
                int closestDist = D+1;
                int targetRow = -1, targetCol = -1; // 공격할 적의 위치

                for (int r = N - 1; r >= 0; r--) {
                    for (int c = 0; c < M; c++) {
                        if (copyarr[r][c] == 1) {
                            int dist = Math.abs(N - r) + Math.abs(archerCol - c); // 궁수와 적의 거리 계산
                            if (dist <= D) { // 거리 제한 내에 있는 경우
                            	// 더 가까운 적을 선택
                                if (dist < closestDist || (dist == closestDist && c < targetCol)) {
                                    closestDist = dist; 
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
                    isTarget = true; // 적이 공격당했으므로 true
                }
            }

            if (!isTarget) {
                break;
            }

            // 적 제거
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visit[r][c]) {
                    	copyarr[r][c] = 0; // 공격받은 적 제거
                        count++;
                    }
                }
            }

            // 적을 아래로 한 칸 이동
            for (int c = 0; c < M; c++) {
                for (int r = N - 1; r > 0; r--) {
                	copyarr[r][c] = copyarr[r - 1][c];
                }
                copyarr[0][c] = 0;
            }
            result = Math.max(count, result);
        }
    }
}

