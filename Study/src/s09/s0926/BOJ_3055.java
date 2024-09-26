package s09.s0926;

import java.io.*;
import java.util.*;

public class BOJ_3055 {

	static int R, C;
	static char[][] map;
	static int startR, startC;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] waterTime; // 물이 해당 위치에 도착하는 시간
	static int[][] targetTime; // 고슴도치가 해당 위치에 도착하는 시간
	static Queue<Info> waterQueue = new LinkedList<>();
	static int res = Integer.MAX_VALUE;

	static class Info {
		int x, y, time;

		Info(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		map = new char[R][C];
		waterTime = new int[R][C];
		targetTime = new int[R][C];

		for (int r = 0; r < R; r++) {
			Arrays.fill(waterTime[r], Integer.MAX_VALUE);
			Arrays.fill(targetTime[r], Integer.MAX_VALUE);
		}

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'S') { // 고슴도치 위치
					startR = r;
					startC = c;
					targetTime[r][c] = 0;
				} else if (map[r][c] == '*') {
					waterQueue.add(new Info(r, c, 0));  // 처음 물의 위치를 큐에 담기 
					waterTime[r][c] = 0;
				}
			}
		}

		spreadWater();
		bfs();

		if (res == Integer.MAX_VALUE) { // 고슴도치가 비버의 굴로 이동 불가
			System.out.println("KAKTUS");
		} else {
			System.out.println(res);
		}
	}

	static void spreadWater() {
		while (!waterQueue.isEmpty()) {
			Info cur = waterQueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				// 물은 돌을 통과할 수 없고, 비버의 소굴로 이동 X
				if (map[nx][ny] == 'X' || map[nx][ny] == 'D' || waterTime[nx][ny] != Integer.MAX_VALUE)
					continue;

				waterTime[nx][ny] = cur.time + 1;
				waterQueue.add(new Info(nx, ny, cur.time + 1));
			}
		}
	}

	static void bfs() {
		Queue<Info> targetQueue = new LinkedList<>();
		targetQueue.add(new Info(startR, startC, 0));

		while (!targetQueue.isEmpty()) {
			Info cur = targetQueue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				// 고슴도치는 돌을 통과할 수 없음
				if (map[nx][ny] == 'X' || targetTime[nx][ny] != Integer.MAX_VALUE)
					continue;

				// 비버의 굴에 도착한 경우
				if (map[nx][ny] == 'D') {
					res = Math.min(cur.time + 1, res);
				}

				// 물이 찰 예정인 칸으로 이동하지 않는 경우
				if (targetTime[cur.x][cur.y] + 1 < waterTime[nx][ny]) {
					targetTime[nx][ny] = cur.time + 1;
					targetQueue.add(new Info(nx, ny, cur.time + 1));
				}
			}
		}
	}
}
