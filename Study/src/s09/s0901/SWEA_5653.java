package s09.s0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int N,M,K;
	static Queue<Info> q = new LinkedList<Info>();
	
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1};
	
	static class Info{
		int x,y;
		int vitality;// 생명력
		int state; // 줄기세포 상태(죽은 상태:-1, 비활성 상태:0, 활성 상태:1)
		Info(int x,int y, int vitality, int state){
			this.x = x;
			this.y = y;
			this.vitality = vitality;
			this.state = state;
		}
	}
	
	// 24.09.01 13:00 ~
	// 생명력 X -> X 시간 동안 비활성, X 시간이 지나는 순간 활성 상태
	// 활성 상태 -> X 시간 동안 살아 있음, X 시간이 지나면 죽음(소멸x, 죽은 상태로 셀 차지)
	// 1시간 동안 상하좌우 동시에 번식(번식된 줄기 세포는 비활성 상태)
	// 배양 시간 K시간이 주어질 때, K 시간 후 살아있는 줄기 세포(활성 상태, 비활성 상태) 개수?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N+2*K][M+2*K];
			visited = new boolean[N+2*K][M+2*K];
			// 초기 줄기세포 분포
			for(int r=K;r<N+K;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=K;c<M+K;c++) {
					//int a = Integer.parseInt(st.nextToken());
					arr[r][c] = Integer.parseInt(st.nextToken());
					if(arr[r][c]!=0) {
						q.offer(new Info(r,c,arr[r][c], 0));
					}
				}
			}
			
			
			
		}
	}
	// 시간이 생명력만큼 흘렀으면 활성 상태로 바뀜, 시간이 생명력의 두배만큼 흘렀으면 죽음 
	// 줄기세포 번식
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			visited[cur.x][cur.y] = true;
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x<0 || y<0 || x>=N+2*K || y>=M+2*K || visited[x][y]) continue;
			}
			
			
		}
	}

}
