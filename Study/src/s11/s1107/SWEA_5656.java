package s11.s1107;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
	static int[] selected;
	static int[][] map, copy;
	static int N, W, H;
	static int res;

	static class Info {
		int x, y, num;

		Info(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			selected = new int[N];
			map = new int[H][W];
			copy = new int[H][W]; // 원상복귀를 위한 배열
			res = Integer.MAX_VALUE;

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					copy[r][c] = map[r][c];
				}
			}
			perm(0);
			System.out.println("#"+tc+" "+res);

		}

	}

	// 중복순열
	public static void perm(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				shoot(selected[i]); // 구슬 쏘기
				
			}
			res = Math.min(cal(), res); // 벽돌 수 구하기
			reset(); // 배열 원상복구
			return;
		}
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			perm(cnt + 1);

		}
	}

	// 구슬 쏘기
	private static void shoot(int c) {
		for (int i = 0; i < H; i++) {
			// 벽돌을 발견하면
			if (map[i][c] != 0) {
				clear(i, c, map[i][c]);
				return;
			}
		}
		

	}

	private static void clear(int r, int c, int num) {
		//System.out.println(r+" "+c+" "+num);
		Queue<Info> q = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		q.add(new Info(r, c, num));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Info cur = q.poll();
			map[cur.x][cur.y] = 0;
			
			for(int dir=0;dir<4;dir++) {
				for(int i=0;i<cur.num;i++) {
					int nx = cur.x+dx[dir]*i;
					int ny = cur.y+dy[dir]*i;
					if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
					if(map[nx][ny]==0 || visited[nx][ny]) continue;
					q.add(new Info(nx,ny,map[nx][ny]));
					visited[nx][ny]=true;
				}
			}
		}
		// 벽돌 내리기
		down();
		
		

	}

	private static void down() {
		for(int i=0;i<W;i++) {//열
			for(int j=H-1;j>=0;j--) {//행
				if(map[j][i]==0) {
					// 0이 아닌 행 찾기 
					for(int s=j-1;s>=0;s--) {
						if(map[s][i]!=0) {
							map[j][i] = map[s][i];
							map[s][i]=0;
							break;
						}
					}
				}
			}
		}
	}

	// 깨고 남은 벽돌 수 구하기
	private static int cal() {
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 배열 원상복구
	private static void reset() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				map[r][c] = copy[r][c];
			}
		}
	}

}
