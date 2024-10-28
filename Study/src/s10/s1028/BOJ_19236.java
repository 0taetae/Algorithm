package s10.s1028;

import java.io.*;
import java.util.*;

public class BOJ_19236 {
	// 물고기가 이동할 수 없으면 반시계방향으로 45도 회전
	// 이동할 수 있는 칸이 없으면 이동 x

	// 상어는 물고기를 먹으면, 그 물고기의 방향을 가짐,
	// 이동할 수 있는 칸이 없으면 공간을 벗어나 집으로 간다.

	static Info[][] map = new Info[4][4]; // 물고기 번호와 방향 배열
	static int[][] fisharr = new int[17][3];
	// 0, 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	// static boolean[][] visited=new boolean[4][4];
	static int res = 0;

	// static boolean isEnd = false;
	// static int startX = 0;
	// static int startY = 0;
	static int sharkDir = 0;

	static class Info {
		int num;
		int dir;

		Info(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Info[][] map = new Info[4][4];
		// ArrayList<Node> fishList = new ArrayList<>();
		for (int r = 0; r < 4; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 4; c++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = new Info(num, dir);
				fisharr[num][0] = r;
				fisharr[num][1] = c;
				fisharr[num][2] = dir;
			}
		}

		// int res=0;
		// visited[0][0] = true;
		int sum = map[0][0].num;
		sharkDir = map[0][0].dir;
		map[0][0] = new Info(-1, sharkDir);
		fisharr[sum][2] = 0;

		sharkMove(0, 0, sum);
		System.out.println(res);
	}

	// 상어 이동 -> 백트래킹
	public static void sharkMove(int startX, int startY, int sum) {
		res = Math.max(res, sum);

		fishMove();

		for (int a = 1; a < 4; a++) {
			int curDir = sharkDir;
			int nx = startX + dx[curDir] * a;
			int ny = startY + dy[curDir] * a;

			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny].num == 0)
				continue;
			int nextNum = map[nx][ny].num;
			int nextDir = map[nx][ny].dir;

			map[startX][startY] = new Info(0, 0);
			map[nx][ny] = new Info(-1, nextDir);
			fisharr[nextNum][2] = 0;
			sharkDir = nextDir;

			sharkMove(nx, ny, sum + nextNum);

			sharkDir = curDir;
			map[nx][ny] = new Info(nextNum, nextDir);
			fisharr[nextNum][2] = nextDir;

		}
	}

	// 물고기 이동
	public static void fishMove() {
		for (int i = 1; i <= 16; i++) {
			int x = fisharr[i][0];
			int y = fisharr[i][1];
			int dir = fisharr[i][2];

			if (dir == 0)
				continue;

			for (int j = 0; j < 8; j++) {
				int nd = (dir + j) % 8;
				int nx = x + dx[nd];
				int ny = y + dy[nd];

				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
					continue;

				if (map[nx][ny].num > 0) {
					fisharr[map[nx][ny].num][0] = x;
					fisharr[map[nx][ny].num][1] = y;
					fisharr[map[nx][ny].num][2] = dir;

					// 현재 물고기 위치 수정
					fisharr[i][0] = nx;
					fisharr[i][1] = ny;
					fisharr[i][2] = nd;

					// map 수정
					map[nx][ny] = new Info(i, nd);
					map[x][y] = new Info(map[x][y].num, dir);
					break;
				}
			}
		}
	}

}
