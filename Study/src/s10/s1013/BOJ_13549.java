package s10.s1013;

import java.io.*;
import java.util.*;

public class BOJ_13549 {

	static class Info implements Comparable<Info> {
        int num;
        int time;

        Info(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    public static int bfs(int num) {
        PriorityQueue<Info> q = new PriorityQueue<>();
        int[] visited = new int[100001]; 
        Arrays.fill(visited, Integer.MAX_VALUE);  

        q.add(new Info(num, 0));
        visited[num] = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            if (cur.num == K) {
                return cur.time;
            }

            if (cur.num * 2 <= 100000 && visited[cur.num * 2] > cur.time) {
                visited[cur.num * 2] = cur.time;
                q.add(new Info(cur.num * 2, cur.time));
            }

            if (cur.num + 1 <= 100000 && visited[cur.num + 1] > cur.time + 1) {
                visited[cur.num + 1] = cur.time + 1;
                q.add(new Info(cur.num + 1, cur.time + 1));
            }

            if (cur.num - 1 >= 0 && visited[cur.num - 1] > cur.time + 1) {
                visited[cur.num - 1] = cur.time + 1;
                q.add(new Info(cur.num - 1, cur.time + 1));
            }
        }
        return -1; 
    }
}
