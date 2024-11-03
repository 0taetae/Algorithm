package s11.s1103;

import java.io.*;
import java.util.*;

public class BOJ_6593 {

	static int L, R, C;
	// 북, 남, 서, 동, 하, 상
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static char[][][] map;
	static int startR,startC, startL;
	static int endR, endC,endL;
	// 지나갈 수 없는 칸 #
	// 비어있는 칸 .
	// 시작지점 S
	// 탈출구 E
	static class Info{
		int x,y,z;
		int cnt;
		Info(int x,int y, int z, int cnt){
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[L][R][C];
			if(L==0 && R==0 && C==0) break;
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String str = br.readLine();
					for(int s=0;s<C;s++) {
						map[i][j][s] = str.charAt(s);
						if(map[i][j][s]=='S') {
							startL = i;
							startR = j;
							startC = s;
						}else if(map[i][j][s]=='E') {
							endL = i;
							endR = j;
							endC = s;
						}
					}
				}
				br.readLine();
			}
			int res = bfs();
			if(res==0) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in "+res+" minute(s).");
			}
			
		}

	}
	private static int bfs() {
		Queue<Info> q = new LinkedList<>();
		boolean[][][] visited = new boolean[L][R][C];
		q.add(new Info(startR,startC,startL,0));
		visited[startL][startR][startC]=true;
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<6;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = cur.z + dz[i];
				if(nx<0 || ny<0 || nz<0 ||nx>=R || ny>=C || nz>=L || visited[nz][nx][ny] || map[nz][nx][ny]=='#') continue;
				if(nx==endR && ny ==endC && nz==endL) return cur.cnt+1;
				
				visited[nz][nx][ny] = true;
				q.add(new Info(nx,ny,nz,cur.cnt+1));
				
			}
		}
		
		return 0;
	}

}
