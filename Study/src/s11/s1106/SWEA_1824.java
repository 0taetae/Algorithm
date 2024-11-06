package s11.s1106;

import java.io.*;
import java.util.*;

public class SWEA_1824 {

	static int R, C;
	static char[][] map;
	static int mem; // 메모리에 저장된 수
	static boolean isOk;
	// 왼쪽,오른쪽, 위, 아래
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Info {
		int x, y, dir;

		Info(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			mem = 0;
			isOk = false;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int r = 0; r < R; r++) {
				String str = br.readLine();
				for (int c = 0; c < C; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			move(0,0,0,0);
			
			if(isOk) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}

		}
	}

	public static void move(int x, int y, int dir, int mem) {
		

	}

}
