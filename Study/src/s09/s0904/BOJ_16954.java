package s09.s0904;

import java.io.*;
import java.util.*;

public class BOJ_16954 {
	
	static char[][] map;
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int wallCnt;
	static boolean isSuccess = false;
	// 북, 북동, 동, 남동, 남, 남서, 서, 북서, 현재위치
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1,0};
	static int[] dy = {0, 1, 1, 1, 0,-1,-1,-1,0};
	static int cnt;
	static int newCnt=0;
	static int time=0;
	static boolean isOk;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		for(int r=0;r<8;r++) {
			String str = br.readLine();
			for(int c=0;c<8;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		// (7,0)에서 시작 
		bfs(7,0);
		if(isSuccess) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	static void bfs(int r, int c) {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(r,c));
		newCnt = 1;
		
		while(!q.isEmpty()) {
			isOk = false;
			// 1초 지날때마다 한칸씩 벽이 내려옴 -> 8*8 체스판이므로 8초면 모두 벽이 사라짐 
			if(time>=8) {
				isSuccess = true;
				return;
			}
			time++;
			cnt = 0; // 이동 가능한 칸 개수 
			for(int k=1;k<=newCnt;k++) {
				Info cur = q.poll();
				// (0,7)에 도착하는 경우 
				if(cur.x==0 && cur.y==7) {
					isSuccess = true;
					return;
				}
				// 현재 위치가 벽이 아닌 경우 
				if(map[cur.x][cur.y] != '#') {
					// 현재 위치에서 오른쪽 위에 벽이 없는 경우 -> 무조건 도착 가능 
					if(check(cur.x,cur.y)==0) {
						isSuccess = true;
						return;
					}
					// 8방향 + 현재위치 탐색
					for(int i=0;i<9;i++) {
						int x = cur.x + dx[i];
						int y = cur.y + dy[i];
						
						if(x<0 || y<0 || x>=8 || y>=8 ||map[x][y]=='#') continue;
						q.offer(new Info(x,y));
						cnt++;
						isOk = true;
					}
				}
				
			}	
			// 이동 가능한 칸 개수, 즉 해당 초에 탐색할 칸 개수 
			newCnt = cnt;  
			// 8방향 + 현재위치로 모두 이동 불가능 
			if(!isOk) return;
			// 벽 내리기 
			downWall();
		}
	}
	static int check(int r, int c) {
		wallCnt=0;
		for(int i=0;i<r;i++) {
			for(int j=c+1;j<8;j++) {
				if(map[i][j]=='#') {
					wallCnt++;
				}
			}
		}
		return wallCnt;
	}
	
	static void downWall() {
		for(int j=0;j<8;j++) {
			for(int i=7;i>=1;i--) {
				map[i][j] = map[i-1][j];
			}
		}
		Arrays.fill(map[0], '.');
	}

}
