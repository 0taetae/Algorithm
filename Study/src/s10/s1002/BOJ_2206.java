package s10.s1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	
	static class Info{
		int x,y;  // 위치
		int len;  // 이동 거리
		int cnt;  // 벽 부순 횟수
		Info(int x, int y, int len, int cnt){
			this.x = x;
			this.y = y;
			this.len = len;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static boolean[][][] visited;
	static int[][] map;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];  // 벽을 부순적 있는 경로에도 방문체크
		
		for(int r=0;r<N;r++) {
			String str = br.readLine();
			for(int c=0;c<M;c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		if(N==1 && M==1) {
			System.out.println(1);
		}else {
			System.out.println(bfs(0,0));
		}
	}
	public static int bfs(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(r,c,1,0));
		visited[r][c][0] = true;
		visited[r][c][0] = true;
		visited[r][c][0] = true;
		visited[r][c][0] = true;
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 맵의 범위를 벗어나거나 방문한적 있는 경우 
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny][cur.cnt]) continue;
				
				// 도착 지점
				if(nx == N-1 && ny == M-1) {
					return cur.len+1;
				}
				
				// 이동할 칸이 벽인 경우
				if(map[nx][ny]==1) {
					// 부순적 있는 경우
					if(cur.cnt==1) {
						continue;
					}else {
						q.add(new Info(nx, ny, cur.len+1, 1));
						visited[nx][ny][1] = true;
					}
				}else {  // 이동할 칸이 벽이 아닌 경우 
					q.add(new Info(nx, ny, cur.len+1, cur.cnt));
					visited[nx][ny][cur.cnt] = true;
				}
			}
		}
		return -1;
	}

}
/*
6 5
00000
11110
00000
01111
01111
00010
=> 18
 */


