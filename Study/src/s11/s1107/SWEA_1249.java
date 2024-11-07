package s11.s1107;

import java.io.*;
import java.util.*;

public class SWEA_1249 {

	static int N;
	static int[][] map,dist;

	static class Info {
		int x, y;

		Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = line.charAt(c) - '0';
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = map[0][0];
			
			check(0, 0);
			System.out.println("#"+tc+" "+dist[N-1][N-1]);
		}

	}

	private static void check(int i, int j) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(i,j));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(dist[cur.x][cur.y] + map[nx][ny] < dist[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
					q.add(new Info(nx, ny));
				}
			}
		}

	}

}
