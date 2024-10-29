package s10.s1029;

import java.io.*;
import java.util.*;

public class BOJ_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][3];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] minDP = new int[3];
        int[] maxDP = new int[3];
        for(int i=0;i<3;i++) {
        	minDP[i] = arr[0][i];
        	maxDP[i] = arr[0][i];
        }

        for (int r = 1; r < N; r++) {
            int[] tempMinDP = minDP.clone();
            int[] tempMaxDP = maxDP.clone();

            for (int c = 0; c < 3; c++) {
                maxDP[c] = tempMaxDP[c] + arr[r][c];
                minDP[c] = tempMinDP[c] + arr[r][c];

                if (c - 1 >= 0) {
                    maxDP[c] = Math.max(maxDP[c], tempMaxDP[c - 1] + arr[r][c]);
                    minDP[c] = Math.min(minDP[c], tempMinDP[c - 1] + arr[r][c]);
                }
                if (c + 1 < 3) {
                    maxDP[c] = Math.max(maxDP[c], tempMaxDP[c + 1] + arr[r][c]);
                    minDP[c] = Math.min(minDP[c], tempMinDP[c + 1] + arr[r][c]);
                }
            }
        }

        int maxRes = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
        int minRes = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
        
        System.out.println(maxRes + " " + minRes);
    }
}
