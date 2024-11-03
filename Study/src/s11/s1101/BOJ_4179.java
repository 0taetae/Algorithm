package s11.s1101;

import java.io.*;
import java.util.*;

public class BOJ_4179 {
	
	static int R,C;
	static int startR,startC;
	static char[][] map;
	static int[][] fireMap, personMap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Info> fire = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		fireMap = new int[R][C];
		personMap = new int[R][C];
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='J') {
					startR = r;
					startC = c;
				}else if(map[r][c]=='F') {
					fire.add(new Info(r,c));
				}
			}
		}
		spread();
		int res = move();
		if(res==-1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(res);
		}
		

	}
	// 불 퍼뜨리기
	public static void spread() {
        while (!fire.isEmpty()) {
            Info cur = fire.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                // 범위를 벗어나거나 벽인 경우
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#') continue;
                
                if (fireMap[nx][ny] == 0) {
                    fireMap[nx][ny] = fireMap[cur.x][cur.y] + 1;
                    fire.offer(new Info(nx, ny));
                }
            }
        }
	}
	// 지훈이 이동
	public static int move() {
		Queue<Info> q = new LinkedList<>();
        q.offer(new Info(startR, startC));

        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                // 미로를 탈출할 수 있는 경우 
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    return personMap[cur.x][cur.y] + 1;
                }
                
                // 지나갈 수 있는 공간인 경우
                if (map[nx][ny] == '.' && personMap[nx][ny] == 0) {
                	// 불이 없는 공간, 불 보다 먼저 간 공간 
                    if (fireMap[nx][ny] == 0 || personMap[cur.x][cur.y] + 1 < fireMap[nx][ny]) {
                        personMap[nx][ny] = personMap[cur.x][cur.y] + 1;
                        q.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return -1;
	}

}
