package s10.s1014;

import java.io.*;
import java.util.*;

public class BOJ_16933 {
	
	// 이동하지 않고 같은 칸에 머물기 가능 

	static int N,M,K;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y,cnt,len,state;
		Info(int x,int y, int cnt,int len,int state){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.len = len;
			this.state = state;
		}
	}
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 행
		M = Integer.parseInt(st.nextToken());  // 열
		K = Integer.parseInt(st.nextToken());  // 벽 부수기 최대 횟수
		
		arr = new int[N+1][M+1];
		visited = new boolean[2][K+1][N+1][M+1];
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
		q.add(new Info(r,c,0,1,1));  // 경로에 시작하는 칸을 포함해서 센다. 시작은 밤 : 1
		visited[1][0][r][c]=true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			//System.out.println(cur.x+" "+cur.y+" "+cur.cnt+" "+cur.len+" "+cur.state);
			
			if(cur.x==N && cur.y==M) {
				return cur.len;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx <=0 || ny<=0 || nx>N || ny >M) continue;
				
//				if(nx==N && ny==M) {
//					return cur.len+1;
//				}
				
				// 현재 낮, 다음날 밤 -> 벽이면 이동안함, 벽이 아니면 한칸 이동
				if(cur.state == 0) {
					if(arr[nx][ny]==1) {
						if(!visited[1][cur.cnt][cur.x][cur.y]) {
							q.add(new Info(cur.x,cur.y,cur.cnt,cur.len+1,1));
							visited[1][cur.cnt][cur.x][cur.y] = true;
						}
					}else {
						if(!visited[1][cur.cnt][nx][ny]) {
							q.add(new Info(nx,ny,cur.cnt,cur.len+1,1));
							visited[1][cur.cnt][nx][ny] = true;
						}
					}
				}
				
				
				// 현재 밤, 다음날 낮 -> 벽이면 뿌수고 이동, 벽이 아니면 한칸 이동
				if(cur.state==1) {
					if(arr[nx][ny]==1 && (cur.cnt+1)<=K) {
						if(!visited[0][cur.cnt+1][nx][ny]) {
							q.add(new Info(nx,ny,cur.cnt+1,cur.len+1,0));
							visited[0][cur.cnt+1][nx][ny]=true;
						}
					}
					else if(arr[nx][ny]==0){
						if(!visited[0][cur.cnt][nx][ny]) {
							q.add(new Info(nx,ny,cur.cnt,cur.len+1,0));
							visited[0][cur.cnt][nx][ny]=true;
						}
					}
				}
			}
		
		}
		return -1;
	}

}
