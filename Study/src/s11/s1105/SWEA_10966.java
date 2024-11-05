package s11.s1105;

import java.io.*;
import java.util.*;

public class SWEA_10966 {

	static int N, M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Info {
		int x, y, cnt;

		Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	// 물 W, 땅 L

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			ArrayList<Node> list = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = str.charAt(c);
					if (map[r][c] == 'W') {
						list.add(new Node(r, c));
					}
				}
			}
			int res = 0;
			for (Node cur : list) {
				res+=bfs(cur.x, cur.y);
			}
			System.out.println("#"+tc+" "+res);

		}
	}

	private static int bfs(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Info(x, y, 0));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Info cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
				
				if(map[nx][ny]=='L') {
					return cur.cnt+1;
				}
				
				q.add(new Info(nx,ny,cur.cnt+1));
				visited[nx][ny] = true;
			}
		}

		return 0;
	}

}
