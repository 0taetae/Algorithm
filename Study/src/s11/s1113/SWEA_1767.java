package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_1767 {

	static int N;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Info> cores;
	static int maxCores, minLen;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			cores = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리를 제외한 코어를 리스트에 추가
					if (arr[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
						cores.add(new Info(i, j));
					}
				}
			}

			maxCores = 0;
			minLen = Integer.MAX_VALUE;

			for (int i = cores.size(); i >= 1; i--) {
				comb(0, 0, i, new boolean[cores.size()]);
				// 최대 코어 수에서 최소 길이를 찾았다면 더 이상 탐색할 필요가 없음
				if (maxCores > 0)
					break;
			}

			System.out.println("#" + t + " " + minLen);
		}
	}

	// 조합으로 연결할 코어 선택
	static void comb(int start, int cnt, int M, boolean[] selected) {
		if (cnt == M) {
			dfs(0, 0, 0, selected);
			return;
		}
		for (int i = start; i < cores.size(); i++) {
			selected[i] = true;
			comb(i + 1, cnt + 1, M, selected);
			selected[i] = false;
		}
	}

	static void dfs(int index, int connected, int wireLen, boolean[] selected) {
		// 모든 코어를 다 확인했을 때
		if (index == cores.size()) {
			if (connected > maxCores) {
				maxCores = connected;
				minLen = wireLen;
			} else if (connected == maxCores) {
				// 연결된 코어 수가 같으면 최소 길이 선택
				minLen = Math.min(minLen, wireLen);
			}
			return;
		}

		// 선택되지 않은 core는 패스
		if (!selected[index]) {
			dfs(index + 1, connected, wireLen, selected);
			return;
		}

		int r = cores.get(index).r;
		int c = cores.get(index).c;

		for (int i = 0; i < 4; i++) {
			int x = r;
			int y = c;
			int len = 0;
			boolean canConnect = true;

			while (true) {
				x += dx[i];
				y += dy[i];

				if (x < 0 || y < 0 || x >= N || y >= N)
					break;
				// 가는 방향에 코어가 있거나 이미 전선이 있는 경우 연결할 수 없음
				if (arr[x][y] != 0) {
					canConnect = false;
					break;
				}
				len++;
			}
			// 연결 가능한 경우
			if (canConnect) {
				x = r;
				y = c;
				// 연결한 부분을 -1로 채우기
				for (int j = 0; j < len; j++) {
					x += dx[i];
					y += dy[i];
					arr[x][y] = -1;
				}

				// 다음 코어로 이동
				dfs(index + 1, connected + 1, wireLen + len, selected);

				// 원상복구
				x = r;
				y = c;
				for (int j = 0; j < len; j++) {
					x += dx[i];
					y += dy[i];
					arr[x][y] = 0;
				}
			}
		}
		// 현재 코어를 연결하지 않고 진행
		dfs(index + 1, connected, wireLen, selected);
	}

}
