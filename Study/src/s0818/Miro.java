package s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Miro {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] visit;
	static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10;i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			visit = new boolean[100][100];
			int startX=0;
			int startY=0;
			for(int r=0;r<100;r++) {
				String str = br.readLine();
				for(int c=0;c<100;c++) {
					arr[r][c] = str.charAt(c)-'0';
					if(arr[r][c] == 2) {
						startX = r;
						startY = c;
					}
				}
			}
			result=0;
			dfs(startX, startY);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	public static void dfs(int r, int c) {
		for(int i=0;i<4;i++) {
			
			int x = r + dx[i];
			int y = c + dy[i];
			
			if(x<0 || x>=100 || y<0 || y>=100 || visit[x][y] || arr[x][y]==1 ) continue;
			
			if(arr[x][y]==3) {
				result=1;
				break;
			}
			visit[x][y] = true;
			dfs(x,y);
			visit[x][y] = false;
			
		}
	}

}
