package s10.s1021;

import java.io.*;
import java.util.*;

public class BOJ_14499 {

	static int N, M, x, y, K;
	static int[][] map;
	// 동 서 북 남 (우 좌 상 하)
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[] comArr;

	// 1: 아랫면, 2: 앞면, 3: 오른쪽면, 4: 왼쪽면, 5: 뒷면, 6: 윗면
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()); // 주사위를 놓은 곳의 좌표
		y = Integer.parseInt(st.nextToken()); // 주사위를 놓은 곳의 좌표
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		comArr = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comArr[i] = Integer.parseInt(st.nextToken());
		}

		num = new int[7]; 

		for (int i = 0; i < K; i++) {
			int dir = comArr[i];
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			int[] temp = num.clone(); // 복사 

			// 동쪽으로 이동
			if (dir == 1) {
				num[1] = temp[4];
				num[3] = temp[1];
				num[6] = temp[3];
				num[4] = temp[6];
			}
			// 서쪽으로 이동
			else if (dir == 2) {
				num[1] = temp[3];
				num[4] = temp[1];
				num[6] = temp[4];
				num[3] = temp[6];
			}
			// 북쪽으로 이동
			else if (dir == 3) {
				num[1] = temp[2];
				num[2] = temp[6];
				num[6] = temp[5];
				num[5] = temp[1];
			}
			// 남쪽으로 이동
			else if (dir == 4) {
				num[1] = temp[5];
				num[5] = temp[6];
				num[6] = temp[2];
				num[2] = temp[1];
			}

			// 이동한 칸에 쓰여 있는 수가 0인 경우, 주사위의 바닥면에 쓰여진 수가 칸에 복사
			if (map[nx][ny] == 0) {
				map[nx][ny] = num[1];
			}
			// 이동한 칸에 쓰여 있는 수가 0이 아닌 경우, 칸의 수를 주사위의 바닥면에 복사
			else {
				num[1] = map[nx][ny]; 
				map[nx][ny] = 0;
			}

			// 주사위가 이동했을 때, 상단에 쓰여 있는 값 출력
			System.out.println(num[6]);

			x = nx;
			y = ny;
		}
	}
}
