package s11.s1112;

import java.io.*;
import java.util.*;

public class SWEA_1249 {
	
	// 출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
	// => 최단 경로 
	
	// 출발지 : 0,0
	// 도착지 : N-1,N-1
	
	static int N;
	static int[][] map;
	static int[][] dist;
	static class Info{
		int x, y;
		Info(int x, int y){
			this.x =x;
			this.y = y;
		}
		
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<N;c++) {
					map[r][c] = str.charAt(c)-'0';
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			
			check();
			System.out.println("#"+tc+" "+dist[N-1][N-1]);
		}

	}
	// 다익스트라 
	public static void check() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0,0));
		dist[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				if(dist[nx][ny]>dist[cur.x][cur.y]+map[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y]+map[nx][ny];
					q.add(new Info(nx,ny));
				}
			}
		}
	}

}
