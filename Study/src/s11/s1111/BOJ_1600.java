package s11.s1111;

import java.io.*;
import java.util.*;

public class BOJ_1600 {

	static int K, W, H;
	static int[][] map;

	static class Info {
		int x, y, cnt, time;

		Info(int x, int y, int cnt, int time) {
			this.x = x;
			this.y = y;
			this.cnt = cnt; // L자 이동 횟수
			this.time = time;
		}
	}

	// 상 하 좌 우
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 횟수

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		H = Integer.parseInt(st.nextToken()); // 세로 길이

		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MAX_VALUE;
		bfs(0, 0);
		if (res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}

	}

	public static void bfs(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[H][W][4][K + 1];

		q.add(new Info(r, c, K, 0));
		visited[r][c][0][K] = true;

		while (!q.isEmpty()) {
			Info cur = q.poll();
			if (cur.x == H - 1 && cur.y == W - 1) {
				res = Math.min(res, cur.time);
			}

			for (int dir = 0; dir < 4; dir++) {
				
				// 말 이동 왼쪽
				int nx = cur.x + dx[dir] * 2 + dx[(dir - 1 + 4) % 4];
				int ny = cur.y + dy[dir] * 2 + dy[(dir - 1 + 4) % 4];
				
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && cur.cnt>0 && !visited[nx][ny][(dir - 1 + 4) % 4][cur.cnt-1] && map[nx][ny]==0) {
					//System.out.println("말 이동 왼쪽 "+nx+" "+ny);
					q.add(new Info(nx,ny,cur.cnt-1,cur.time+1));
					visited[nx][ny][(dir - 1 + 4) % 4][cur.cnt-1] = true;
				}
				
				// 말 이동 오른쪽 
				nx = cur.x + dx[dir] * 2 + dx[(dir + 1) % 4];
				ny = cur.y + dy[dir] * 2 + dy[(dir + 1) % 4];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W && cur.cnt>0  && !visited[nx][ny][(dir + 1) % 4][cur.cnt-1] && map[nx][ny]==0) {
					//System.out.println("말 이동 오른쪽 "+nx+" "+ny);
					q.add(new Info(nx,ny,cur.cnt-1,cur.time+1));
					visited[nx][ny][(dir + 1) % 4][cur.cnt-1] = true;
				}
				
				// 일반 이동 
				nx = cur.x + dx[dir];
				ny = cur.y + dy[dir];
				
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny]==0  && !visited[nx][ny][dir][cur.cnt]) {
					//System.out.println("일반 이동 "+nx+" "+ny);
					q.add(new Info(nx,ny,cur.cnt,cur.time+1));
					visited[nx][ny][dir][cur.cnt] = true;
				}
			}
		}

	}

}
/*
2
8 12
0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 0
0 1 1 1 1 1 1 0
0 1 1 0 0 0 0 0
0 1 1 0 1 1 1 1
0 1 1 0 1 1 1 1
0 1 1 0 0 0 0 0
0 1 1 0 1 1 1 0
0 1 1 1 1 1 1 0
1 1 0 0 0 0 1 1
1 1 1 1 1 1 1 1
1 1 1 0 1 1 0 0
=> 14

1
7 8
0 0 0 0 0 0 0
1 1 1 1 1 1 0
1 1 1 1 1 1 0
0 0 0 1 1 1 0
0 1 1 1 0 0 0
0 1 1 1 1 1 1
0 1 1 1 1 1 1
0 0 0 0 0 0 0
=> 25

30
7 10
0 1 1 1 0 1 1
1 1 0 1 1 1 0
1 1 1 1 1 1 1
1 1 1 1 1 0 1
1 1 1 0 1 1 1
1 0 1 1 1 1 1
1 1 1 1 1 1 1
1 1 0 1 1 1 1
1 1 1 1 0 1 1
1 1 1 1 1 1 0
=> 9

2
2 6
0 1
1 1
1 0
1 1
0 1
0 0
=>4

 */
