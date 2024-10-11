package s10.s1011;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
	
	static int N,W,H;
	static int[][] map,copy;
	static int[] selected;
	static boolean[][] visited;
	static int res;
	static class Info{
		int x,y,num;
		Info(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());  // 테스트케이스 수
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 구슬 수
			W = Integer.parseInt(st.nextToken());  // 열
			H = Integer.parseInt(st.nextToken());  // 행
			
			map = new int[H][W];
			copy = new int[H][W];
			selected = new int[N];
			res = Integer.MAX_VALUE;
			for(int r=0;r<H;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<W;c++) {
					int num = Integer.parseInt(st.nextToken());
					map[r][c] =num;
					copy[r][c] = num;
				}
			}
			perm(0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	// 중복순열로 구슬 쏠 위치 정하기
	public static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				shoot(selected[i]);  // 구슬 쏘기
			}
			res = Math.min(cntN(),res);  // 벽돌 수 구하기
			reset(); // 배열 원상복구 
			return;
		}
		for(int i=0;i<W;i++) {
			selected[cnt] = i;
			perm(cnt+1);
		}
	}

	// 구슬 쏘기
	static void shoot(int idx) {
		for(int i=0;i<H;i++) {
			if(map[i][idx]!=0) {
				clear(i, idx,map[i][idx]);  // 벽돌 깨트리기 
				return;
			}
		}
	}
	static void clear(int r,int c, int num) {
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[H][W];
		q.add(new Info(r,c,num));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			map[cur.x][cur.y] = 0;
			for(int dir=0;dir<4;dir++) {
				for(int i=0;i<=cur.num-1;i++) {
					int nx = cur.x+dx[dir]*i;
					int ny = cur.y+dy[dir]*i;
					
					// 배열 범위 넘어가는 경우
					if(nx<0 || nx>=H || ny<0 || ny>=W || map[nx][ny]==0 || visited[nx][ny]) continue;
					q.add(new Info(nx,ny,map[nx][ny]));
					visited[nx][ny] = true;
				}
			}
		}
		down(r,c,num);   // 벽돌 내리기
	}
	
	// 구슬을 쏜 후 빈공간 생김 -> 벽돌 내림
	static void down(int r,int c,int num) {
		// 열
		for(int i=0;i<W;i++) {
			// 행
			for(int j=H-1;j>0;j--) {
				if(map[j][i]==0) {
					// 위 행의 벽돌 중 0이 아닌 벽돌 찾기
					for(int k=j-1;k>=0;k--) {
						if(map[k][i]!=0) {
							map[j][i] = map[k][i];
							map[k][i]=0;
							break;
						}
						
					}
				}
			}
		}
	}
	// 배열 원상복구 
	static void reset() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	// 남은 벽돌 수 구하기 
	private static int cntN() {
		int cnt = 0;
		for(int j=0;j<W;j++) {
			for(int i=H-1;i>=0;i--) {
				if(map[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}