package s11.s1112;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
	
	static int N,W,H;
	static int[][] map;
	static int[] selected;
	static int[][] copyMap;
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
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 구슬 쏘는 횟수 
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copyMap = new int[H][W];
			for(int r=0;r<H;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<W;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					copyMap[r][c] = map[r][c];
				}
			}
			res = Integer.MAX_VALUE;
			selected = new int[N];
			perm(0);
			
			System.out.println("#"+tc+" "+res);
		}

	}
	
	// 중복 순열로 구슬 쏠 위치 정하기
	public static void perm(int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				shoot(selected[i]);
			}
			res = Math.min(res, cal());
			// 원상복구 
			reset();
			return;
		}
		for(int i=0;i<W;i++) {
			selected[cnt] = i;
			perm(cnt+1);
		}
	}
	
	// 구슬 쏘기
	public static void shoot(int num) {
		Queue<Info> q = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		// 첫 벽돌이 있는 행 찾기
		for(int r=0;r<H;r++) {
			if(map[r][num]!=0) {
				q.add(new Info(r,num,map[r][num]));
				visited[r][num] = true;
				break;
			}
		}
		while(!q.isEmpty()) {
			Info cur = q.poll();
			map[cur.x][cur.y] = 0;
			
			for(int dir=0;dir<4;dir++) {
				for(int i=1;i<=cur.num-1;i++) {
					int nx = cur.x + dx[dir]*i;
					int ny = cur.y + dy[dir]*i;
					
					if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
					if(map[nx][ny]==0 || visited[nx][ny]) continue;
					q.add(new Info(nx,ny,map[nx][ny]));
					visited[nx][ny]=true;
				}
				
			}
			
		}
		
		
		down();
	}
	
	// 빈칸 채우기
	public static void down() {
		for(int c=0;c<W;c++) {
			for(int r=H-1;r>=1;r--) {
				if(map[r][c]==0) {
					for(int s=r-1;s>=0;s--) {
						if(map[s][c]!=0) {
							map[r][c] = map[s][c];
							map[s][c] = 0;
							break;
						}
					}
				}
			}
		}
		
	}
	
	// 남은 구슬 세기
	public static int cal() {
		int sum=0;
		for(int r=0;r<H;r++) {
			for(int c=0;c<W;c++) {
				if(map[r][c]!=0) {
					sum++;
				}
			}
		}
		
		return sum;
	}
	
	// 배열 원상 복구
	public static void reset() {
		for(int r=0;r<H;r++) {
			for(int c=0;c<W;c++) {
				map[r][c] = copyMap[r][c];
			}
		}
	}

}
