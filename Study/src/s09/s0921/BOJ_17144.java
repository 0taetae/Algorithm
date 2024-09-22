package s09.s0921;

import java.io.*;
import java.util.*;

public class BOJ_17144 {
	
	static int R,C,T;
	static int[][] room;
	static int macUp, macDown;   // 공기청정기 위치 
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());  // 행
		C = Integer.parseInt(st.nextToken());  // 열
		T = Integer.parseInt(st.nextToken());  // 초
		room = new int[R][C];  // 미세먼지양 
		macUp = 0;
		macDown = 0;
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if(room[r][c]==-1) {
					if(macUp==0) macUp = r;
					else macDown = r;
				}
			}
		}
		for (int time = 0; time < T; time++) {
			spread();
			operate();
		}
		int res = 0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(room[r][c] > 0) {
					res += room[r][c];
				}
			}
		}
		System.out.println(res);

	}
	
	static void spread() {
		int[][] temp = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] > 0) {
					int cnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nx = r + dx[dir];
						int ny = c + dy[dir];
						if(nx<0 || ny <0 || nx>=R || ny >= C || room[nx][ny]==-1) continue;
						temp[nx][ny] += room[r][c] / 5;  // A/5 만큼 확산
						cnt++;
					}
					temp[r][c] += room[r][c] - (room[r][c] / 5 * cnt);  // 남은 미세먼지의 양 = A - (A/5)*(확산된 방향 개수)
				}
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] != -1) room[r][c] = temp[r][c];
			}
		}
	}
	static void operate() {
		// 위 : 반시계방향으로 순환 
		// 아래쪽으로 이동
		for(int i=macUp-1;i>0;i--) {
			room[i][0] = room[i-1][0];
		}
		// 왼쪽으로 이동
		int temp1 = room[0][0];
		for(int i=0;i<C-1;i++) {
			room[0][i] = room[0][i+1];
		}
		// 위쪽으로 이동
		for(int i=0;i<macUp;i++) {
			room[i][C-1] = room[i+1][C-1];
		}
		// 오른쪽으로 이동
		for(int i=C-1;i>1;i--) {
			room[macUp][i] = room[macUp][i-1];
		}
		
		room[macUp][1] = 0;  // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		
		// 아래 : 시계방향으로 순환 
		// 위쪽으로 이동
		for(int i=macDown+1;i<R-1;i++) {
			room[i][0] = room[i+1][0];
		}
		// 왼쪽으로 이동
		for(int i=0;i<C-1;i++) {
			room[R-1][i] = room[R-1][i+1];
		}
		// 아래쪽으로 이동
		for(int i=R-1;i>macDown;i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		// 오른쪽으로 이동 
		for(int i=C-1;i>1;i--) {
			room[macDown][i] = room[macDown][i-1];
		}
		room[macDown][1] = 0;  // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		
	}

}
