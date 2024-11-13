package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_22683 {
	
	static int N,K;
	static char[][] map;
	static int startR,startC,endR,endC;
	static class Info implements Comparable<Info>{
		int x,y;
		int dir;
		int cnt;
		int len;
		Info(int x, int y, int dir, int cnt, int len){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
			this.len = len;
		}
		@Override
		public int compareTo(Info o) {
			return this.len - o.len;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int res;
	static boolean isOk;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());  // 나무 벨 수 있는 횟수 
			
			map = new char[N][N];
			
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<N;c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c]=='X') {  // 현재 RC카 위치
						startR = r;
						startC = c;
					}else if(map[r][c]=='Y') {  // RC 카를 이동시키고자 하는 위치 
						endR = r;
						endC = c;
					}
				}
			}
			isOk = false;
			res = Integer.MAX_VALUE;
			move();
			
			if(isOk) {
				System.out.println("#"+tc+" "+res);
			}else {
				System.out.println("#"+tc+" "+(-1));
			}
			
		}
		
	}
	
	public static void move() {
		Queue<Info> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][N][4][K+1];
		q.add(new Info(startR,startC,0,K,0));
		visited[startR][startC][0][K] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			// 도착 
			if(cur.x==endR && cur.y==endC) {
				res = Math.min(res, cur.len);
				isOk = true;
				return;
			}
			
			// 좌회전
			int nextDir = cur.dir-1;
			if(nextDir<0) nextDir = 3;
			if(!visited[cur.x][cur.y][nextDir][cur.cnt]) {
				visited[cur.x][cur.y][nextDir][cur.cnt] = true;
				q.add(new Info(cur.x,cur.y,nextDir,cur.cnt,cur.len+1));
			}
			
			
			// 우회전
			nextDir = cur.dir+1;
			if(nextDir>=4) nextDir = 0;
			if(!visited[cur.x][cur.y][nextDir][cur.cnt]) {
				visited[cur.x][cur.y][nextDir][cur.cnt] = true;
				q.add(new Info(cur.x,cur.y,nextDir,cur.cnt,cur.len+1));
			}
			
			
			// 직진
			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];
			
			// 범위 벗어나는 경우 
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			
			// 다음 위치에 나무가 있는 경우 
			if(map[nx][ny]=='T') {
				// 나무를 벨 수 있는 경우 
				if(cur.cnt>0) {
					// 방문하지 않은 경우 
					if(!visited[nx][ny][cur.dir][cur.cnt-1]) {
						visited[nx][ny][cur.dir][cur.cnt-1] = true;
						q.add(new Info(nx,ny,cur.dir,cur.cnt-1,cur.len+1));
					}
				}
			}else {
				if(!visited[nx][ny][cur.dir][cur.cnt]) {
					visited[nx][ny][cur.dir][cur.cnt] = true;
					q.add(new Info(nx,ny,cur.dir,cur.cnt,cur.len+1));
				}
			}
			
			
			
		}
		
	}

}
