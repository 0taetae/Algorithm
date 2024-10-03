package s10.s1003;

import java.io.*;
import java.util.*;

public class BOJ_16928 {
	
	static int N, M;
	static boolean[] visited;
	static int res;
	static class Info {
		int num, cnt;
		Info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	static Map<Integer, Integer> ladder = new HashMap<>();
	static Map<Integer, Integer> snake = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		visited = new boolean[101];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 사다리의 수
		M = Integer.parseInt(st.nextToken());  // 뱀의 수
		
		// 사다리 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startLadder = Integer.parseInt(st.nextToken());
			int endLadder = Integer.parseInt(st.nextToken());
			ladder.put(startLadder, endLadder);
		}
		// 뱀 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startSnake = Integer.parseInt(st.nextToken());
			int endSnake = Integer.parseInt(st.nextToken());
			snake.put(startSnake, endSnake);
		}
		
		res = Integer.MAX_VALUE;
		bfs(1);
		System.out.println(res);
	}

	public static void bfs(int start) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(start, 0));
		visited[start] = true;
		
		while (!q.isEmpty()) {
			Info cur = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int next = cur.num + i;
				
				// 100번 칸을 넘어간다면 이동 X
				if (next > 100) continue;
				
				// 100번 칸에 도착 
				if (next == 100) {
					res = Math.min(res, cur.cnt + 1);
					return;
				}
				
				if (ladder.containsKey(next)) {
					next = ladder.get(next);
				} else if (snake.containsKey(next)) {
					next = snake.get(next);
				}
				
				if (!visited[next]) {
					visited[next] = true;
					q.add(new Info(next, cur.cnt + 1));
				}
			}
		}
	}
}
