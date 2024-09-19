package s09.s0919;

import java.io.*;
import java.util.*;

public class BOJ_14500 {
	
	static int N, M, res;
	static int[][] paper;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static class Info{
		int x,y;
		int cnt,val;
		Info(int x, int y, int cnt, int val){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		res=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				bfs(r,c,0,0);
			}
		}
		System.out.println(res);
		

	}
	static void bfs(int r, int c, int cnt,int val) {
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[N][M];
		visited[r][c] = true;
		System.out.println("Ω√¿€:::::"+r+" "+c+" "+(cnt+1)+" "+(val+paper[r][c]));
		q.add(new Info(r,c,cnt+1, val+paper[r][c]));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			if(cur.cnt ==4) {
				//res = Math.max(res, cur.val);
				if(res < cur.val) {
					res = cur.val;
					System.out.println(r+" "+c+" "+cur.x+" "+cur.y+" "+cur.val+"!!!!!");
				}
			}
			else {
				for(int i=0;i<4;i++) {
					int x = cur.x + dx[i];
					int y = cur.y + dy[i];
					if(x<0 || y<0 || x>=N || y>=M || visited[x][y]) continue;
					q.add(new Info(x,y,cur.cnt+1,cur.val+paper[x][y]));
					visited[x][y] = true;
					System.out.println(x+" "+y+" "+(cur.cnt+1)+" "+(cur.val+paper[x][y]));
				}
			}
		}
	}
}
