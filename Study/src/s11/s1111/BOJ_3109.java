package s11.s1111;

import java.io.*;
import java.util.*;

public class BOJ_3109 {
	
	static int R,C;
	static char[][] map;
	// 오른쪽 위, 오른쪽 , 오른쪽 아래 
	static int[] dx= {-1,0,1};
	static int[] dy= {1,1,1};
	static boolean[][] visited;
	static int res;
	static boolean isOk;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		res = 0;
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			isOk = false;
			dfs(i,0);
			//System.out.println("----------------------");
		}
		System.out.println(res);
		
		
	}
	public static void dfs(int r,int c) {
		//System.out.println(r+" "+c);
		if(c==C-1) {
			//System.out.println("도착");
			
			res++;
			isOk = true;
			return;
		}
		
		for(int dir=0;dir<3;dir++) {
			int nx = r + dx[dir];
			int ny = c + dy[dir];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C || visited[nx][ny] || map[nx][ny]=='x') continue;
			
			visited[nx][ny] = true;
			dfs(nx,ny);
			if(isOk){
				break;
			}
		}
		
		
	}

}
