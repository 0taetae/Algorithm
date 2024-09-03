package s09.s0903;

import java.io.*;
import java.util.*;

public class BOJ_14503 {

	// 북동남서 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N,M;
	static int startRow, startCol, startDir;
	static int[][] room;
	static int count; // 청소하는 칸 개수 
	static boolean[][] check;
	
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		startRow = Integer.parseInt(st.nextToken());
		startCol = Integer.parseInt(st.nextToken());
		startDir = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		check = new boolean[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if(room[r][c]==0) {
					check[r][c]=true; // 청소되지 않은 상태 
				}
			}
		}
		bfs(startRow,startCol,startDir);
		
		System.out.println(count);
	}
	// 0은 청소 안한 상태, 1은 벽
	static void bfs(int r, int c, int dir) {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(r,c));
		
		while(!q.isEmpty()) {
			Info cur = q.poll(); // 현재 칸 
			// 현재 칸이 빈칸이고, 청소되지 않은 상태 
			if(room[cur.x][cur.y]==0 && check[cur.x][cur.y]) {
				count++;
				check[cur.x][cur.y] = false; // 청소 완료 
			}
			boolean isDurty = false;  // 청소되어 있지 않은 곳이 없으면 false 
			// 주변 4칸 탐색 
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				if(x<0 || y<0 || x>=N || y>=M ) continue;
				
				if(check[x][y]) {
					isDurty = true;  // 청소되어 있지 않은 곳이 있음 
				}

			}
			if(isDurty) {
				while(true) {
					int newDir = (dir+3)%4; // 반시계방향으로 90도 회전
					int newRow = cur.x + dx[newDir];
					int newCol = cur.y + dy[newDir];
					// 바라보는 방향을 기준으로 앞쪽 한 칸이 청소되지 않은 빈칸인 경우 한칸 전진
					if(room[newRow][newCol]==0 && check[newRow][newCol]) {
						q.offer(new Info(newRow, newCol));
						dir = newDir;
						break;
					}
					dir = newDir;
				}
				
			}else {
				int newRow = cur.x+dx[(dir+2)%4];
				int newCol = cur.y + dy[(dir+2)%4];
				// 바라보는 방향을 유지한 채로 한칸 후진할 수 있는 경우(벽이 아닌 경우)
				if(room[newRow][newCol]!=1) {
					q.offer(new Info(newRow,newCol));
				}else {
					return;
				}
			}
		}
		
		
	}

}
