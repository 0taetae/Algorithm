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
	static int newCnt;
	
	/*
	8x8 체스판
	빈칸 또는 벽
	7,0 -> 0,7 이동
	1초마다 모든 벽이 아래에 있는 행으로 한칸씩 내려감
	가장 아래에 벽이 있어서 아래에 행이 없다면, 벽이 사라짐
	캐릭터는 1초에 인접한 한칸 또는 대각선 방향으로 한칸 이동 or 현재 위치에 서있을 수 있음
	이동할 때는 빈칸으로만 이동 가능  
	1초동안 욱제의 캐릭터가 먼저 이동, 그 다음 벽이 이동
	벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없음
	욱제의 캐릭터가 가장 오른쪽 윗 칸으로 이동 가능한지 -> 도착 가능 1, 불가능 0
	 */


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		for(int r=0;r<8;r++) {
			String str = br.readLine();
			for(int c=0;c<8;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		bfs(7,0);
		if(isSuccess) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	static void bfs(int r, int c) {
		//System.out.println("시작");
		// 8방향 + 자기자리,  벽이 아니면 이동 가능 
		// 벽이 내려간 후에 본인 자리가 벽이면 종료 
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(r,c));
		newCnt = 1;
		
		while(!q.isEmpty()) {
			for(int k=1;k<=newCnt;k++) {
				cnt = 0;
				Info cur = q.poll();
				if(cur.x==0 && cur.y==7) {
					System.out.println("도착 성공");
					isSuccess = true;
					return;
				}
				if(map[cur.x][cur.y] != '#') {
					System.out.println(cur.x+" "+cur.y+"현재위치가 벽아님");
					
					if(check(cur.x,cur.y)==0) {
						System.out.println(cur.x+" "+cur.y+"부터 오른쪽 위 벽이 없음");
						isSuccess = true;
						return;
					}
					// 8방향 + 현재위치 탐색
					for(int i=0;i<9;i++) {
						int x = cur.x + dx[i];
						int y = cur.y + dy[i];
						
						if(x<0 || y<0 || x>=8 || y>=8 ||map[x][y]=='#') continue;
						
						System.out.println(x+" "+y+" 해당 위치 벽 아님 ");
						q.offer(new Info(x,y));
						cnt++;
						System.out.println(cnt);
					}
				}
				
			}		
			newCnt = cnt;
			//System.out.println(newCnt);
			// 벽 아래에 있는 행으로 한칸씩 내려감, 0행에 빈칸으로 채워줌
			
			downWall();
			
			//System.out.println("벽 내리기");
			
			//continue;
//			for(int i=0;i<8;i++) {
//				for(int j=0;j<8;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
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
