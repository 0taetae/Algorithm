package s11.s1112;

import java.io.*;
import java.util.*;

public class SWEA_10966 {
	
	static int N,M;
	static char[][] map;
	static Queue<Info> q ;
	static class Info{
		int x,y,cnt;
		Info(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int[][] dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			dist = new int[N][M];
			q = new LinkedList<>();
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<M;c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c]=='W') {
						q.add(new Info(r,c,0));
					}else {
						dist[r][c] = Integer.MAX_VALUE;
					}
				}
			}
			bfs();
			int res=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					res+=dist[r][c];
				}
			}
			System.out.println("#"+tc+" "+res);
		}

	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				
				if(dist[nx][ny]>cur.cnt+1) {
					dist[nx][ny] = cur.cnt + 1;
					q.add(new Info(nx,ny,cur.cnt+1));
				}
			}
			
			
		}
	}

}
