package s11.s1109;

import java.io.*;
import java.util.*;

public class SWEA_2105 {
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int N;
	static int[][] map;
	//static boolean[][] visited;
	static boolean[] num;
	static int res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res = 0;
			for(int r=0;r<=N-3;r++) {
				for(int c=1;c<=N-2;c++) {
					num = new boolean[101];
					num[map[r][c]] = true;
					check(r,c,0,1,r,c);
				}
			}
			if(res<4) {
				System.out.println("#"+tc+" "+-1);
			}else {
				System.out.println("#"+tc+" "+res);
			}
			
			
		}
		

	}

	private static void check(int r, int c, int dir, int cnt, int startR, int startC) {
		for(int i=dir;i<4;i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			
			if(x<0 || y<0 || x>=N || y>=N) continue;
			if(x== startR && y==startC) {
				res = Math.max(res, cnt);
				return;
			}
			if(!num[map[x][y]]) {
				num[map[x][y]] = true;
				check(x,y,i,cnt+1,startR,startC);
				num[map[x][y]] = false;
			}
		}
		
	}

}
