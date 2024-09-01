package s08.s0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BattleField {
	
	static int[] dx = {-1, 0, 1, 0};  // up, right, down, left
	static int[] dy = {0, 1, 0, -1};
	static int startX, startY;
	static int dir;
	static int H, W, N;
	static char[][] map;
	static char[] arr;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];  // 게임 맵
			for(int r=0;r<H;r++) {
				String mapStr = br.readLine();
				for(int c=0;c<W;c++) {
					map[r][c] = mapStr.charAt(c);
					if(map[r][c]=='<' || map[r][c]=='>' || map[r][c] =='v' || map[r][c] =='^') {
						startX = r;
						startY = c;
					}
					if(map[r][c] == '<') {
						dir = 3;
					}else if(map[r][c] == '>') {
						dir = 1;
					}else if(map[r][c] == 'v') {
						dir = 2;
					}else if(map[r][c] == '^') {
						dir = 0;
					}
					
				}
			}
			N = Integer.parseInt(br.readLine());
			arr = new char[N];
			String arrStr = br.readLine();  // 동작 
			for(int j=0;j<N;j++) {
				arr[j] = arrStr.charAt(j);
			}
			
			for(int j=0;j<N;j++) {
				game(startX, startY,j);
			}
			
			if(dir == 0) {
				map[startX][startY] = '^';
			}else if(dir == 1) {
				map[startX][startY] = '>';
			}else if(dir == 2) {
				map[startX][startY] = 'v';
			}else if(dir == 3) {
				map[startX][startY] = '<';
			}
			System.out.print("#"+i+" ");
			for(int r=0;r<H;r++) {
				for(int c=0;c<W;c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}
	}
	public static void game(int r, int c, int idx) {
		if(idx==0) {
			map[r][c] ='.';
		}
		if(arr[idx] == 'U') {

			dir = 0;
			if(r + dx[dir]>=H || c + dy[dir]>=W || r + dx[dir]<0 || c + dy[dir]<0) {
				return;
			}
			if(map[r + dx[dir]][c + dy[dir]]=='.') {
				startX = r + dx[dir];
				startY = c + dy[dir];
			}

		}else if(arr[idx]=='D') {

			dir = 2;
			if(r + dx[dir]>=H || c + dy[dir]>=W || r + dx[dir]<0 || c + dy[dir]<0) {
				return;
			}
			if(map[r + dx[dir]][c + dy[dir]]=='.') {
				startX = r + dx[dir];
				startY = c + dy[dir];
			}
		}else if(arr[idx]=='L') {

			dir = 3;
			if(r + dx[dir]>=H || c + dy[dir]>=W || r + dx[dir]<0 || c + dy[dir]<0) {
				return;
			}
			if(map[r + dx[dir]][c + dy[dir]]=='.') {
				startX = r + dx[dir];
				startY = c + dy[dir];
			}
		}else if(arr[idx]=='R') {

			dir = 1;
			if(r + dx[dir]>=H || c + dy[dir]>=W || r + dx[dir]<0 || c + dy[dir]<0) {
				return;
			}
			if(map[r + dx[dir]][c + dy[dir]]=='.') {
				startX = r + dx[dir];
				startY = c + dy[dir];
			}
		}else if(arr[idx]=='S'){

			while(true) {
				r+=dx[dir];
				c+=dy[dir];
				if(r>=H || c>=W || r<0 || c<0) {
					return;
				}
				if(map[r][c]=='*') {
					map[r][c]='.';
					break;
				}else if(map[r][c]=='#') {
					break;
				}
			}
		}
		
//		int x = r + dx[dir];
//		int y = c + dy[dir];
//		if(r>=H || c>=W || r<0 || c<0) {
//			return;
//		}
		//System.out.println("다음 타겟:"+ x + y);
		
	}
}

