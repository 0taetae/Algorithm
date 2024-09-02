package s09.s0903;

import java.io.*;
import java.util.*;

public class SWEA_2115 {
	
	// N*N 개의 벌통
	// 각 칸의 숫자는 각각의 벌통에 있는 꿀의 양
	
	// 선택한 벌통 정보 저장(시작 끝 인덱스, 총수익) -> 총 수익으로 내림차순 정렬 , 인덱스 안겹치게 하기
	// 

    static int N, M, C;
    static int[][] honey;
    static ArrayList<Info> lst ;
    static int result;

    static class Info {
        int x, y, profit;

        Info(int x, int y, int profit) {
            this.x = x;
            this.y = y;
            this.profit = profit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수 
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    honey[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            lst = new ArrayList<>();
            findMaxProfits();

            // 리스트를 이익 순으로 정렬
            lst.sort((o1, o2) -> o2.profit - o1.profit);

            result = 0;
            calculateMaxCombinedProfit();

            System.out.println("#" + i + " " + result);
        }
    }

    public static void findMaxProfits() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c <= N - M; c++) {
                int sum = 0;
                int profit = 0;

                // 벌통 M개에 대한 최대 수익 계산
                for (int i = 0; i < M; i++) {
                    int honeyAmount = honey[r][c + i];
                    if (sum + honeyAmount <= C) {
                        sum += honeyAmount;
                        profit += honeyAmount * honeyAmount;
                    }
                }

                // 가능한 최대 수익을 리스트에 추가
                lst.add(new Info(r, c, profit));
            }
        }
    }

    public static void calculateMaxCombinedProfit() {
        for (int i = 0; i < lst.size() - 1; i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                Info first = lst.get(i);
                Info second = lst.get(j);

                // 두 구간이 겹치지 않는지 확인
                if (first.x != second.x || (first.y + M <= second.y || second.y + M <= first.y)) {
                    result = Math.max(result, first.profit + second.profit);
                }
            }
        }
    }
}
/*
package s09.s0903;

import java.io.*;
import java.util.*;

public class SWEA_2115 {
    
    static int N, M, C;
    static int[][] honey;
    static int[][] maxProfit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수 
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            maxProfit = new int[N][N]; // 각 위치에서의 최대 수익 저장

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    honey[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 위치에서 최대 수익을 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    maxProfit[r][c] = calculateMaxProfit(r, c);
                }
            }

            // 두 구간이 겹치지 않게 최대 수익을 계산
            result = 0;
            findMaxCombinedProfit();

            System.out.println("#" + i + " " + result);
        }
    }

    // (r, c)부터 M개의 벌통을 선택했을 때의 최대 수익 계산
    public static int calculateMaxProfit(int r, int c) {
        int[] selectedHoney = new int[M];
        for (int i = 0; i < M; i++) {
            selectedHoney[i] = honey[r][c + i];
        }
        return getMaxProfit(selectedHoney, 0, 0, 0);
    }

    // 재귀적으로 최대 수익을 계산 (부분집합을 활용)
    public static int getMaxProfit(int[] honey, int idx, int currentSum, int currentProfit) {
        if (currentSum > C) {
            return 0;
        }
        if (idx == M) {
            return currentProfit;
        }
        // 선택하거나 선택하지 않거나
        int include = getMaxProfit(honey, idx + 1, currentSum + honey[idx], currentProfit + honey[idx] * honey[idx]);
        int exclude = getMaxProfit(honey, idx + 1, currentSum, currentProfit);
        return Math.max(include, exclude);
    }

    public static void findMaxCombinedProfit() {
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 <= N - M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    int startCol = (r1 == r2) ? c1 + M : 0;
                    for (int c2 = startCol; c2 <= N - M; c2++) {
                        result = Math.max(result, maxProfit[r1][c1] + maxProfit[r2][c2]);
                    }
                }
            }
        }
    }
}

 */


