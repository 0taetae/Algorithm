package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_1249 {
	
	static int N;
	static int[][] map, dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info implements Comparable<Info>{
		int x,y,cost;
		Info(int x, int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
//			for(int r=0;r<N;r++) {
//				for(int c=0;c<N;c++) {
//					System.out.print(map[r][c]+" ");
//				}
//				System.out.println();
//			}
			dist[0][0] = 0;
			bfs();
			sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.println(sb);

	}
	public static void bfs() {
		PriorityQueue<Info> q = new PriorityQueue<>();
		//boolean[][] visited = new boolean[N][N];
		q.add(new Info(0,0,dist[0][0]));
		//visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N|| ny>=N) continue;
				
				if(dist[nx][ny] > dist[cur.x][cur.y]+map[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y]+map[nx][ny];
					q.add(new Info(nx,ny,dist[nx][ny]));
				}
			}
		}
		
	}

}
