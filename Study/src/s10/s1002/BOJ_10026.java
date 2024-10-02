package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_10026 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int res1=0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs1(i,j);
					res1++;
				}
			}
		}
		System.out.print(res1+" ");
		
		int res2=0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs2(i,j);
					res2++;
				}
			}
		}
		System.out.print(res2);

	}
	// 적록색약이 아닌 사람
	public static void bfs1(int r, int c) {
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				
				if(map[cur.x][cur.y]=='R') {
					if(map[nx][ny]=='R') {
						q.add(new Info(nx,ny));
						visited[nx][ny] = true;
					}
				}else if(map[cur.x][cur.y]=='G') {
					if(map[nx][ny]=='G') {
						q.add(new Info(nx,ny));
						visited[nx][ny] = true;
					}
				}else {
					if(map[nx][ny]=='B') {
						q.add(new Info(nx,ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	// 적록색약인 사람
	public static void bfs2(int r, int c) {
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				
				if(map[cur.x][cur.y]=='R'|| map[cur.x][cur.y]=='G') {
					if(map[nx][ny]=='R' || map[nx][ny]=='G') {
						q.add(new Info(nx,ny));
						visited[nx][ny] = true;
					}
				}else {
					if(map[nx][ny]=='B') {
						q.add(new Info(nx,ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

}
