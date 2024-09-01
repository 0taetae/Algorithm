package s08.s0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105 {
	
	// 시계방향 탐색 
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int[][] arr;
	static boolean[] visited;
	static int N, startX, startY, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res =0;
			for(int r=0;r<N-1;r++) {
				for(int c=1;c<N-1;c++) {
					// visited 초기화
					visited = new boolean[101];
					startX = r;
					startY = c;
					dfs(r, c, 0, 1);
				}
			}
			// 디저트를 먹은 개수가 최소 4
			if(res<4) {
				System.out.println("#"+i+ " "+(-1));
			}else {
				System.out.println("#"+i+ " "+res);
			}
		}
	}
	
	public static void dfs(int r, int c, int dir, int cnt) {
		
		for(int i=dir;i<4;i++) {
			visited[arr[r][c]]=true;
			int x = r+dx[i];
			int y = c+dy[i];
			if(x<0 || y<0 || x>=N || y>=N) continue;
			// 시작점에 도착하면 디저트 먹은 개수 구하기
			if(x== startX && y == startY && visited[arr[x][y]]) {
				res = Math.max(res, cnt);
				return;
			}
			int target = arr[x][y];
			if(!visited[target]) {
				visited[target] = true;
				dfs(x, y, i,cnt+1);
				visited[target] = false;
			}
		}
	}
}
