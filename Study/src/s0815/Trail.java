package s0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Trail {
	
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visit;
	static Queue<Idx> q;
	static int[][] map;
	static int K;
	static ArrayList<Idx> list;
	static int qsize;
	
	public static class Idx {
		int r;
		int c;
		public Idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			highFind(map);
			int max=0;
			
			for(int n=0;n<qsize;n++) {
				int count=0;
				while(!q.isEmpty()) {
					dfs(q.peek().r,q.peek().c,count);
					q.poll();
					max = Math.max(max,count);
				}
				
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
			
			
		}
		System.out.println(sb);

	}
	public static void dfs(int r, int c, int count) {
		visit[r][c] = true;
		
		for(int i=0;i<4;i++) {
			int x = r + dr[i];
			int y = c + dc[i];
			
			if(x<0 || y<0 || x>=N || y>=N) {
				continue;
			}
			if(map[r][c]<map[x][y]) {
				continue;
			}
			if(!visit[x][y]) {
				if(map[r][c]==map[x][y]) {
					map[x][y] -= map[x][y];
					dfs(x,y,count+1);
				}
				int dif = map[r][c] - map[x][y];
				if(dif<=K) {
					for(int j=1; j<=dif;j++) {
						map[x][y] = map[x][y] - j;
						dfs(x,y,count+1);
					}
				}
				if(dif>K) {
					for(int j=1; j<=K;j++) {
						map[x][y] = map[x][y] - j;
						dfs(x,y,count+1);
					}
				}
				
			}
		}
	}
	
	public static int highFind(int[][] map) {
		Queue<Idx> q = new LinkedList<>();
		ArrayList<Idx> list = new ArrayList<Idx>();
		int max = 0;
		int qsize=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(max==map[r][c]) {
					q.offer(new Idx(r,c));
					list.add(new Idx(r,c));
					qsize++;
				}
			}
		}
		return max;
		
	}

}
