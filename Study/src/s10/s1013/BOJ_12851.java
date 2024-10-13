package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_12851 {

    static class Info {
        int num;
        int cnt;

        Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int N, K;
    static int res = Integer.MAX_VALUE; 
    static int cnt = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(res);
        System.out.println(cnt);
    }

    public static void bfs(int num) {
        Queue<Info> q = new LinkedList<>();
        int[] visited = new int[100001]; 
        Arrays.fill(visited, -1);        

        q.add(new Info(num, 0));
        visited[num] = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            if (cur.cnt > res) continue;

            if (cur.num == K) {
                if (cur.cnt < res) {
                    res = cur.cnt;
                    cnt = 1; 
                } else if (cur.cnt == res) {
                    cnt++; 
                }
            }

            int[] nextPositions = {cur.num - 1, cur.num + 1, cur.num * 2};

            for (int next : nextPositions) {
                if (next < 0 || next > 100000) continue;

                if (visited[next] == -1 || visited[next] == cur.cnt + 1) {
                    visited[next] = cur.cnt + 1;
                    q.add(new Info(next, cur.cnt + 1));
                }
            }
        }
    }
}
