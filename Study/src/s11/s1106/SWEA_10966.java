package s11.s1106;

import java.io.*;
import java.util.*;

public class SWEA_10966 {

	static int N, M;
	static char[][] map;
	static int[][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static Queue<Info> water = new LinkedList<>();

	static class Info {
		int x, y, cnt;

		Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	// 물 W, 땅 L

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			dist = new int[N][M];  // 해당 땅 까지의 최소 거리 

			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = str.charAt(c);
					if (map[r][c] == 'W') {
						water.add(new Info(r, c,0));
					} else {
						dist[r][c] = Integer.MAX_VALUE;
					}
				}
			}
			int res = 0;
			bfs();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 'L') {
						res += dist[r][c];
					}
				}
			}
			System.out.println("#" + tc + " " + res);

		}
	}
	
	private static int bfs() {

		while (!water.isEmpty()) {
			Info cur = water.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (dist[nx][ny] > cur.cnt + 1) {
					dist[nx][ny] = cur.cnt + 1;
					water.add(new Info(nx, ny, cur.cnt + 1));
				}

			}
		}

		return 0;
	}

}
