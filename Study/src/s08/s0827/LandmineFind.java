package s08.s0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LandmineFind {
	static ArrayList<Info> lst;
	static char[][] arr;
	static int N;
	static int AreaCount;
	
	// 8방향 탐색
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			AreaCount=0;
			// 배열 요소 입력받고 채우기
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<N;c++) {
					arr[r][c] = str.charAt(c);
				}
			}
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					// 한번 클릭했을 때 자동으로 숫자를 표시해주는 영역 찾기 
					if(arr[r][c]=='.' && findZero(r,c)) {
						AreaCount++;
						bfs(r,c);
					}
				}
			}
			// 위에서 찾은 영역 외에 지뢰가 아닌 곳 찾기 
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(arr[r][c] == '.') {
						AreaCount++;
					}
				}
			}
			sb.append("#").append(i).append(" ").append(AreaCount).append("\n");
		}
		System.out.println(sb);

	}
	// 주변에 지뢰가 없으면 true, 있으면 false
	public static boolean findZero(int r, int c) {
		for(int i=0;i<8;i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if(x<0 || y<0 || x>=N || y>=N) continue;
			if(arr[x][y]=='*') {
				return false;
			}
		}
		return true;
	}
	// 주변에 지뢰가 없는 위치 찾기
	public static void bfs(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(r,c));
		arr[r][c] = '1';
		
		while(!q.isEmpty()) {
			Info temp = q.poll();
			
			// 주변에 지뢰가 있는 위치
			if(!findZero(temp.x,temp.y)) continue;
			
			for(int i=0;i<8;i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				// 배열 범위 벗어남 
				if(x<0 || y<0 || x>=N || y>=N || arr[x][y]!='.') continue;
				arr[x][y] = '1';
				q.offer(new Info(x, y));
			}
		}
	}
}
