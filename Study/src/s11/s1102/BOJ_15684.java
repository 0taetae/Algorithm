package s11.s1102;

import java.io.*;
import java.util.*;

public class BOJ_15684 {
	
	static int N, M, H;
	static boolean[][] map;
	static int res = Integer.MAX_VALUE; // 추가해야하는 가로선 개수의 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  // 세로선의 개수, 열의 개수
		M = Integer.parseInt(st.nextToken());  // 가로선의 개수, 최대로 놓을 가로선 개수 
		H = Integer.parseInt(st.nextToken());  // 세로선마다 가로선을 놓을 수 있는 위치의 개수 , 행의 개수 
		map = new boolean[H + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;  // b번 세로선과 b+1번 세로선을 a번 위치에서 연결
		}
		
		dfs(1, 1, 0);
		
		if (res == Integer.MAX_VALUE) {  // 가로선을 3개 이상 추가한 경우 or 불가능한 경우 
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}

	public static void dfs(int x, int y, int cnt) {
		if (cnt >= res) return;  // 추가해야하는 가로선 개수의 최솟값보다 큰 경우 
		if (check()) { 
			res = Math.min(res, cnt);
			return;
		}
		if (cnt == 3) return; // 가로선 최대 3개 
		
		// x행인 경우 
		for(int j=y;j<N;j++) {
			if (!map[x][j] && !map[x][j + 1]) { 
				map[x][j] = true;
				dfs(x, j + 2, cnt + 1); 
				map[x][j] = false;
			}
		}
		// x+1 행부터 
		for (int i = x+1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (!map[i][j] && !map[i][j + 1]) { 
					map[i][j] = true;
					dfs(i, j + 2, cnt + 1); 
					map[i][j] = false;
				}
			}
		}
	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) { // i번 세로선
			int cur = i;
			for (int j = 1; j <= H; j++) {
				// 오른쪽으로 이동
				if (map[j][cur]) cur++; 
				// 왼쪽으로 이동
				else if (cur > 1 && map[j][cur - 1]) cur--; 
			}
			// i번 세로선 결과가 i번이 나오지 않는 경우 
			if (cur != i) return false;
		}
		return true;
	}
}
