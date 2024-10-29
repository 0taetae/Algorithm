package s10.s1023;

import java.io.*;
import java.util.*;

public class BOJ_5972 {
	
    static int N, M; 
    static List<Info>[] adj;
    static int[] dist;
    
    static class Info implements Comparable<Info> {
        int barn, cnt;
        public Info(int barn, int cnt) {
            this.barn = barn;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Info o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 헛간 개수
        M = Integer.parseInt(st.nextToken());  // 소들의 길 개수 
        
        // 2차원 리스트 
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
        	adj[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 헛간 a
            int b = Integer.parseInt(st.nextToken());  // 헛간 b
            int cnt = Integer.parseInt(st.nextToken());  // 소
            adj[a].add(new Info(b, cnt));
            adj[b].add(new Info(a, cnt));
        }
        
        check(1);

        System.out.println(dist[N]);
    }

    static void check(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
        	Info cur = pq.poll();
            int curbarn = cur.barn;
            int curCnt = cur.cnt;

            if (curCnt > dist[curbarn]) continue;
            
            for(int i=0;i<adj[curbarn].size();i++) {
            	int newDist = curCnt + adj[curbarn].get(i).cnt;
                if (newDist < dist[adj[curbarn].get(i).barn]) {
                    dist[adj[curbarn].get(i).barn] = newDist;
                    pq.add(new Info(adj[curbarn].get(i).barn, newDist));
                }
            }
        }
    }

}
