package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_2105 {
	
	static int N;
	static int[][] map;
	static int startR,startC;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static int res;
	static boolean[][] visited;
	static boolean[] selected;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res = 0;
			startR = 0;
			startC = 0;
			for(int r=0;r<N-1;r++) {
				for(int c=1;c<N-1;c++) {
					//System.out.println(r+" "+c+" 시작점");
					visited = new boolean[N][N];
					selected = new boolean[101];
					startR = r;
					startC = c;
					visited[r][c] = true;
					selected[map[r][c]] = true;
					dfs(r,c,1,0);
					
				}
			}
			if(res<4) {
				System.out.println("#"+tc+" "+(-1));
			}else {
				System.out.println("#"+tc+" "+res);
			}
			
		}

	}
	public static void dfs(int r, int c, int cnt,int dir ) {
		
		for(int i=dir;i<4;i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			//System.out.println("다음 점 "+nx+" "+ny);
			
			if(nx==startR && ny==startC) {
				//System.out.println("성공");
				//System.out.println(cnt);
				res = Math.max(res, cnt);
				return;
			}
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) {
				//System.out.println("범위 벗어난 곳 ");
				continue;
			}
			if(visited[nx][ny]) {
				//System.out.println("방문 한 곳");
				continue;
			}
			if(selected[map[nx][ny]]) {
				//System.out.println("이미 먹은 디저트");
				continue;
			}
			
			selected[map[nx][ny]] = true;
			visited[nx][ny] = true;
			dfs(nx,ny,cnt+1,i);
			visited[nx][ny] = false;
			selected[map[nx][ny]] = false;
		}
	}

}
