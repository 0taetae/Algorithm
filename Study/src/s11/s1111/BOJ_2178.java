package s11.s1111;

import java.io.*;
import java.util.*;

public class BOJ_2178 {
	
	static int N,M;
	static int res;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y,time;
		Info(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	// 1 이동할 수 있는 칸
	// 0 이동할 수 없는 칸

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int r=0;r<N;r++) {
			String str = br.readLine();
			for(int c=0;c<M;c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		res = Integer.MAX_VALUE;
		bfs();
		System.out.println(res+1);
		
	}
	public static void bfs() {
		Queue<Info> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Info(0,0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			
			for(int dir=0;dir<4;dir++) {
				
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx==N-1 && ny==M-1) {
					res = Math.min(res, cur.time+1);
				}
				
				if(nx<0 || ny<0 || nx>=N ||ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
				
				q.add(new Info(nx,ny,cur.time+1));
				visited[nx][ny] = true;
				
				
			}
		}
	}

}
