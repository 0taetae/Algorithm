package s0821;

import java.io.*;
import java.util.*;


public class Game2048 {
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1 ,0, -1};
	static int N;

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st;
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			//st = new StringTokenizer(br.readLine());
			N = sc.nextInt();
			map = new int[N][N];
			String S = sc.next();
			for(int r=0;r<N;r++) {
				//st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = sc.nextInt();
				}
			}
			if(N==1) {
				sb.append("#").append(i).append("\n");
				sb.append(map[0][0]).append("\n");
				continue;
			}
			if(S.equals("left")) {
				for(int r=0;r<N;r++) {
					play(r,0,1);
				}
			}else if(S.equals("right")){
				for(int r=0;r<N;r++) {
					play(r,N-1,3);
				}
			}else if(S.equals("up")) {
				for(int c=0;c<N;c++) {
					play(0,c,2);
				}
			}else if(S.equals("down")) {
				for(int c=N-1;c>=0;c--) {
					play(N-1,c,0);
				}
			}
			sb.append("#").append(i).append("\n");
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					sb.append(map[r][c]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		
	}
	public static void play(int r, int c, int dir) {
		if(r<0 || c<0 || r>=N || c>=N || r+dx[dir]<0 || c+dy[dir]<0 || r+dx[dir]>=N || c+dy[dir]>=N) {
			return;
		}
		// 요소가 0이면 교체  
		if(map[r][c]==0) {
			int a = zeroMove(r, c, dir);
			// 해당 열이나 행에서 해당 요소 이후에 0만 있는 경우
			if(a==1) {
				return;
			}
			play(r,c,dir);
		}
		else if(map[r+dx[dir]][c+dy[dir]]==0) {
			int a = zeroMove(r+dx[dir],c+dy[dir],dir);
			if(a==1) {
				return;
			}
			play(r,c,dir);
		}
		// 같은 수이면 합하기 
		else if(map[r][c]==map[r+dx[dir]][c+dy[dir]]) {
			map[r][c] *= 2;
			map[r+dx[dir]][c+dy[dir]]=0;
			play(r+dx[dir],c+dy[dir],dir);
		}else {
			play(r+dx[dir],c+dy[dir],dir);
		}
	}
	// 0인 요소와 아닌 요소 교체하기, 다음에 0만 남은 경우 확인하기 
	public static int zeroMove(int r, int c, int dir) {
		int startX = r;
		int startY = c;
		int a=0;
		while(true) {
			r = r + dx[dir];
			c = c + dy[dir];
			
			if(r<0 || c<0 || r>=N || c>=N) {
				a=1;
				break;
			}
			
			if(map[r][c]!=0) {
				map[startX][startY] = map[r][c];
				map[r][c] = 0;
				break;
			}
			
		}
		return a;
		
	}

}
