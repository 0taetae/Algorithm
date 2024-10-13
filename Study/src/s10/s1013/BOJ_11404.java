package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 정점의 수
        int M = Integer.parseInt(br.readLine());  // 간선의 수

        int[][] dist = new int[N + 1][N + 1]; 

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 10000001);
            dist[i][i] = 0;  
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c); 
        }

        for (int k = 1; k <= N; k++) {  
            for (int i = 1; i <= N; i++) { 
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 10000001) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j] + " "); 
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
