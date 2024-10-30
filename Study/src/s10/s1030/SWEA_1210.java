package s10.s1030;

import java.io.*;
import java.util.*;

public class SWEA_1210 {
	
	// 백트래킹 -> 도착점 찾기 
	
	// 좌, 하, 우
	static int[] dx = {0,1,0};
	static int[] dy = {-1,0,1};
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for(int r=0;r<100;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<100;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			//int res=0;
			boolean[][] visited = new boolean[100][100];
			for(int c=0;c<100;c++) {
				if(map[0][c]==1) {
					check(0, c,visited);
				}
			}
			
			System.out.print("#"+T+" ");
		}
	}

	private static void check(int startX, int startY, boolean[][] visited) {
		if(startX==99) {
			if(map[startX][startY]==2) {
				System.out.println(startY);
			}
			return;
		}
		
		for(int dir=0;dir<3;dir++) {
			int nx = startX + dx[dir];
			int ny = startY + dy[dir];
			
			if(nx<0 || ny<0 || nx>=100 || ny>=100 || map[nx][ny]==0 || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			check(nx,ny, visited);
			visited[nx][ny] = false;
		}
		
	}

}
