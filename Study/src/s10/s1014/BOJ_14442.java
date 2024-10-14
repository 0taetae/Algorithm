package s10.s1014;

import java.io.*;
import java.util.*;

public class BOJ_14442 {
	
	static int N,M,K;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y,cnt,len;
		Info(int x,int y, int cnt,int len){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.len = len;
		}
	}
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 행
		M = Integer.parseInt(st.nextToken());  // 열
		K = Integer.parseInt(st.nextToken());  // 벽 부수기 최대 횟수
		
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][K+1];
		for(int i=1;i<=N;i++) {
			
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j+1] = str.charAt(j)-'0';
			}
		}
		System.out.println(check(1,1));

	}

	public static  int check(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(r,r,0,1));  // 경로에 시작하는 칸을 포함해서 센다.1
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			if(cur.x==N && cur.y==M) {
				return cur.len;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx <=0 || ny<=0 || nx>N || ny >M) continue;
				if(arr[nx][ny]==0) {
					if(!visited[nx][ny][cur.cnt]) {
						q.add(new Info(nx,ny,cur.cnt,cur.len+1));
						visited[nx][ny][cur.cnt] = true;
					}
					
				}else {
					if(cur.cnt+1<=K) {
						if(!visited[nx][ny][cur.cnt+1]) {
							q.add(new Info(nx,ny,cur.cnt+1, cur.len+1));
							visited[nx][ny][cur.cnt+1] = true;
						}
					}
				}
			}
		}
		return -1;
		
	}

}
