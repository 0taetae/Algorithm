package s09.s0904;

import java.io.*;
import java.util.*;

public class SWEA_1952 {

    static int[] price = new int[4];  // 1일권, 1달권, 3달권, 1년권
    static int[] plan = new int[12];  // 각 달의 이용 계획
    static int[] pay = new int[12];  // 각 달까지의 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            // 1월
            pay[0] = Math.min(price[0] * plan[0], price[1]);  // base case 초기화 
            for (int i = 1; i < 12; i++) {
                
                // 1일권 또는 1달권을 사용하는 경우 비교 
                pay[i] = pay[i - 1] + Math.min(price[0] * plan[i], price[1]);
                // 3달권을 사용하는 경우와 비교
                if (i >= 2) {
                    int cost3Month = price[2] + (i >= 3 ? pay[i - 3] : 0);
                    pay[i] = Math.min(pay[i], cost3Month);
                }
            }

            // 1년권과 비교
            int res = Math.min(price[3], pay[11]);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}
