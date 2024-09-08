package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17135 {
	
	static int N,M,D;
	static int[] select = new int[3];
	static int[][] map, copymap;
	static int res=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 행
		M = Integer.parseInt(st.nextToken());  // 열
		D = Integer.parseInt(st.nextToken());  // 공격 거리 제한
		map = new int[N][M];
		copymap = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				copymap[r][c] = map[r][c];
			}
		}
		comb(0,0);
		System.out.println(res);
	}
	
	// 조합으로 궁수 위치 선택
	static void comb(int cnt, int start) {
		if(cnt==3) {
			reset();
			res = Math.max(res, game());
			return;
		}
		for(int i=start;i<M;i++) {
			select[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	// 배열 원상복구 
	static void reset() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				map[r][c] = copymap[r][c];
			}
		}
	}
	
	static int game() {
		int cnt = 0;
		boolean remain = true;
		while(remain) {
			remain = false;
			boolean[][] visited = new boolean[N][M];
			for(int i=0;i<3;i++) {
				int archer = select[i];
				int minDist = Integer.MAX_VALUE;
				int targetRow = 0;
				int targetCol = 0;
				boolean isEnemy = false;
				for(int r=N-1;r>=0;r--) {
					for(int c=0;c<M;c++) {
						if(map[r][c] == 1) {
							remain = true;
							int dist = Math.abs(N-r)+Math.abs(archer - c);
							if(dist<=D) {
								if(dist<minDist || (dist==minDist && c<targetCol)) {
									minDist = dist;
									targetCol = c;
									targetRow = r;
									isEnemy = true;
								}
							}
						}
					}
				}
				if(isEnemy) {
					visited[targetRow][targetCol] = true;
				}
			}
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(visited[r][c]) {
						map[r][c] = 0;
						cnt++;
					}
				}
			}
			for(int c=0;c<M;c++) {
				for(int r=N-1;r>0;r--) {
					map[r][c] = map[r-1][c];
				}
				map[0][c] = 0;
			}
		}
		return cnt;
	}

}
