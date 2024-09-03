package s09.s0903;

import java.io.*;
import java.util.*;

public class BOJ_4485 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int res;
	static int[][] minSum;
	
	static class Info{
		int x,y, sum;
		Info(int x, int y,int sum){
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			arr = new int[N][N];
			visited = new boolean[N][N];
			minSum = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(minSum[i], Integer.MAX_VALUE);
			}
			// 0,0 부터 시작 -> N-1, N-1 도착
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			bfs(0,0,0);
			System.out.println("진짜 답"+minSum[N-1][N-1]);
		}
	}
	public static void bfs(int r, int c,int sum) {
		Queue<Info> q = new LinkedList<Info>();
		visited[r][c] = true;
		q.offer(new Info(r,c,arr[r][c]));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x<0 || y<0 || x>=N || y>=N || minSum[cur.x][cur.y]>minSum[N-1][N-1]) continue;
				minSum[x][y] = Math.min(minSum[x][y], (cur.sum+arr[x][y]));
				System.out.println(x+" "+y+" "+minSum[x][y]);
				// 더한 값이 이전 값보다 작을 때만 큐에 넣기 
				q.offer(new Info(x,y,minSum[x][y]));
				visited[x][y] = true;
				
			}
		}
		
		
	}

}
