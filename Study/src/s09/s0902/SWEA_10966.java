package s09.s0902;

import java.io.*;
import java.util.*;

public class SWEA_10966 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N,M;
	static char[][] map;
	static int sum;
	static boolean[][] visited;
	static int move;
	
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
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<M;c++) {
					map[r][c] = str.charAt(c);
				}
			}
			sum=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(map[r][c]=='L') {
						//System.out.println("r "+r+" c "+c);
						bfs(r,c);
						sum+=move;
						//System.out.println("해당 땅에서 물까지 거리"+sum);
					}
					
				}
			}
			System.out.println("#"+i+" "+sum);
		}

	}
	public static void bfs(int r, int c) {
		move =Integer.MAX_VALUE;
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[N][M];
		visited[r][c] = true;
		q.offer(new Info(r,c));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x<0 || y<0 || x>=N || y>=M || visited[x][y]) continue;
				q.offer(new Info(x,y));
				visited[x][y]=true;
				
				if(map[x][y]=='W') {
					//System.out.println("x "+x+" y "+y);
					int a = Math.abs(r-x)+Math.abs(c-y);
					move = Math.min(move, a);
					//System.out.println("이동"+move);
				}
			}
		}
		
	}

}
