package s11.s1102;

import java.io.*;
import java.util.*;

public class BOJ_7569 {

	static int M, N, H;
	static int[][][] map;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static class Info {
		int x, y,z;

		Info(int x, int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static Queue<Info> q = new LinkedList<>();
	static int cnt, totalCnt, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		cnt = 0;
		totalCnt = 0;
		res = 0;
		for(int s=0;s<H;s++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c][s] = Integer.parseInt(st.nextToken());
					if (map[r][c][s] == 1) {
						q.add(new Info(r, c,s));
					} else if (map[r][c][s] == 0) {
						totalCnt++;
					}
				}
			}
		}
		

		if (totalCnt == 0) {
			System.out.println(0);
			return;
		}

		bfs();

		if (cnt == totalCnt) {
			System.out.println(res - 1);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Info cur = q.poll();
			for (int dir = 0; dir < 6; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int nz = cur.z + dz[dir];

				if (nx < 0 || ny < 0 || nz<0 || nx >= N || ny >= M || nz>=H|| map[nx][ny][nz] != 0)
					continue;

				map[nx][ny][nz] = map[cur.x][cur.y][cur.z] + 1;
				q.offer(new Info(nx, ny,nz));
				cnt++;
				res = Math.max(res, map[nx][ny][nz]);
			}
		}
	}
}
