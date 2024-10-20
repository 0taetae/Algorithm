package s10.s1020;

import java.io.*;
import java.util.*;

public class BOJ_12100 {
	static int N;
	static int[][] map;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxBlock = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(map, 0);
		System.out.println(maxBlock);
	}

	// 최대 5번 이동 
	private static void dfs(int[][] map, int moveCnt) {
		if (moveCnt == 5) {
			find(map);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int[][] newMap = move(map, dir);
			dfs(newMap, moveCnt + 1);
		}
	}

	private static int[][] move(int[][] map, int dir) {
		int[][] newMap = new int[N][N];
		boolean[][] check = new boolean[N][N];  // 이미 합쳐진 것 체크 
		
		// map 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		if (dir == 0) { // 상
			for (int c = 0; c < N; c++) {
				for (int r = 1; r < N; r++) {
					if (newMap[r][c] == 0) continue;
					int nextR = r;
					// 빈칸을 만난 경우 위로 이동 
					while (nextR > 0 && newMap[nextR - 1][c] == 0) {
						newMap[nextR - 1][c] = newMap[nextR][c];
						newMap[nextR][c] = 0;
						nextR--;
					}
					// 이미 합쳐진 것이 아닌 경우, 동일한 값의 블록을 만나면 합치기 
					if (nextR > 0 && newMap[nextR - 1][c] == newMap[nextR][c] && !check[nextR - 1][c]) {
						newMap[nextR - 1][c] *= 2;
						newMap[nextR][c] = 0;
						check[nextR - 1][c] = true;
					}
				}
			}
		} else if (dir == 1) { // 하
			for (int c = 0; c < N; c++) {
				for (int r = N - 2; r >= 0; r--) {
					if (newMap[r][c] == 0) continue;
					int nextR = r;
					// 빈칸을 만난 경우 아래로 이동 
					while (nextR < N - 1 && newMap[nextR + 1][c] == 0) {
						newMap[nextR + 1][c] = newMap[nextR][c];
						newMap[nextR][c] = 0;
						nextR++;
					}
					// 이미 합쳐진 것이 아닌 경우, 동일한 값의 블록을 만나면 합치기
					if (nextR < N - 1 && newMap[nextR + 1][c] == newMap[nextR][c] && !check[nextR + 1][c]) {
						newMap[nextR + 1][c] *= 2;
						newMap[nextR][c] = 0;
						check[nextR + 1][c] = true;
					}
				}
			}
		} else if (dir == 2) { // 좌
			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					if (newMap[r][c] == 0) continue;
					int nextC = c;
					// 빈칸을 만난 경우 왼쪽으로 이동 
					while (nextC > 0 && newMap[r][nextC - 1] == 0) {
						newMap[r][nextC - 1] = newMap[r][nextC];
						newMap[r][nextC] = 0;
						nextC--;
					}
					// 이미 합쳐진 것이 아닌 경우, 동일한 값의 블록을 만나면 합치기
					if (nextC > 0 && newMap[r][nextC - 1] == newMap[r][nextC] && !check[r][nextC - 1]) {
						newMap[r][nextC - 1] *= 2;
						newMap[r][nextC] = 0;
						check[r][nextC - 1] = true;
					}
				}
			}
		} else if (dir == 3) { // 우
			for (int r = 0; r < N; r++) {
				for (int c = N - 2; c >= 0; c--) {
					if (newMap[r][c] == 0) continue;
					int nextC = c;
					// 빈칸을 만난 경우 오른쪽으로 이동 
					while (nextC < N - 1 && newMap[r][nextC + 1] == 0) {
						newMap[r][nextC + 1] = newMap[r][nextC];
						newMap[r][nextC] = 0;
						nextC++;
					}
					// 이미 합쳐진 것이 아닌 경우, 동일한 값의 블록을 만나면 합치기
					if (nextC < N - 1 && newMap[r][nextC + 1] == newMap[r][nextC] && !check[r][nextC + 1]) {
						newMap[r][nextC + 1] *= 2;
						newMap[r][nextC] = 0;
						check[r][nextC + 1] = true;
					}
				}
			}
		}

		return newMap;
	}
	
	// 얻을 수 있는 최대 블록 찾기 
	private static void find(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxBlock = Math.max(maxBlock, map[i][j]);
			}
		}
	}
}
