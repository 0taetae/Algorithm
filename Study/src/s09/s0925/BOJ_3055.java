package s09.s0925;

import java.io.*;
import java.util.*;

public class BOJ_3055 {
	
	static int R,C;
	static char[][] map;
	static int startR, startC;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static ArrayList<Info> lst = new ArrayList<Info>();
	static boolean[][][] visit;
	//static boolean canEnd;
//	static class Node{
//		int x,y;
//		Node(int x, int y){
//			this.x=x;
//			this.y = y;
//		}
//	}
	static int[][] waterTime;
	static class Info{
		int x,y,cnt;
		Info(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());  // 행
		C = Integer.parseInt(st.nextToken());  // 열
		map = new char[R][C];
		visited = new boolean[R][C];
		visit = new boolean[R][C][4];  // 위치, 방향 일치하면 -> 비버의 굴로 이동할 수 없음 
		waterTime = new int[R][C];
		Arrays.fill(waterTime, -1);
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='S') {  // 고슴도치 위치 
					startR = r;
					startC = c;
				}else if(map[r][c]=='*') {  // 물
					//lst.add(new Info(r,c,0));
					spread(r,c);
				}
			}
		}
		bfs(startR,startC);
		
		

	}
	static void spread(int r,int c) {// 물 퍼짐 
		Queue<Info> q = new LinkedList<Info>();
		visited = new boolean[R][C];
		q.add(new Info(r,c,0));
		visited[r][c] = true;
		waterTime[r][c] = 0;
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x+dx[i];
				int y = cur.x+dy[i];
				if(x<0 || y<0 || x>=R || y>=C || visited[x][y]|| map[x][y]=='X' || waterTime[x][y]<cur.cnt+1) continue;
				q.add(new Info(x,y,cur.cnt+1));
				visited[x][y] = true;
				waterTime[x][y] = cur.cnt+1;
			}
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Info> q = new LinkedList<Info>();
		visited = new boolean[R][C];
		q.add(new Info(r,c,0));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x<0 || y<0 || x>=R || y>=C || visited[x][y]|| map[x][y]=='X' || visit[x][y][i]) continue;
				visited[x][y] = true;
				q.add(new Info(x,y,cur.cnt+1));
				visit[x][y][i] = true;
			}
		}
	}

}
