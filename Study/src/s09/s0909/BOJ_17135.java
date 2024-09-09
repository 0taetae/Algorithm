package s09.s0909;

import java.io.*;
import java.util.*;

public class BOJ_17135 {
	
	static int N, M, D, res;
	static int[][] map, copy;
	static int[] select;
	//static boolean[] isSelected;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken()); // 공격 제한 거리
		
		map = new int[N][M];
		copy = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				copy[r][c] = map[r][c];
			}
		}
		select = new int[3];
		//isSelected = new boolean[M];
		res = Integer.MIN_VALUE;
		// 궁수 배치
		comb(0,0);
		System.out.println(res);

	}
	// 궁수 배치하기 위한 조합
	static void comb(int cnt, int start) {
		if(cnt==3) {
			//System.out.println("궁수 세명 선택됨");
			reset();
			res = Math.max(game(),res);
			return;
		}
		for(int i=start;i<M;i++) {
			select[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	static int game() {
		int count=0;  // 제거한 적의 수 

		while(true) {
			boolean[][] visited = new boolean[N][M];
			boolean remain = false;
			for(int i=0;i<3;i++) {
				int archer = select[i]; // 선택한 궁수
				int targetRow = 0;  // 제거할 적의 행
				int targetCol = 0;  // 제거할 적의 열
				int minDist = Integer.MAX_VALUE;  // 가까운 적을 선택하기 위함
				boolean isTarget = false;  // 제거할 적이 존재 
				for(int r=N-1;r>=0;r--) {
					for(int c=0;c<M;c++) {
						if(map[r][c]==1) {
							remain = true; // 적이 남아 있음  
							int dist = Math.abs(N-r) + Math.abs(archer-c);
							if(dist<=D) {  // 제한거리 안에 있으면
								if(dist<minDist || (dist==minDist && c<targetCol)) {
									minDist = dist;
									targetRow = r;
									targetCol = c;
									isTarget = true;
								}
							}
						}
					}
				}
				// 해당 조건을 만족하는 적 선택
				if(isTarget) {
					//System.out.println("해당 궁수가 적을 선택");
					visited[targetRow][targetCol] = true;
				}
			}
			// 남아있는 적이 없으면 게임 끝
			if(!remain) {
				//System.out.println("남아있는 적이 없음");
				break;
			}
			// 선택한 적을 제거
			for(int r=0;r<N;r++) {
				for(int c=0; c<M;c++) {
					if(visited[r][c]) {
						map[r][c] = 0;
						count++;
					}
				}
			}
			// 적을 아래로 한칸 이동
			for(int c=0;c<M;c++) {
				for(int r=N-1;r>0;r--) {
					map[r][c] = map[r-1][c];
				}
				map[0][c] = 0;
			}
		}
		
		return count;
	}
	static void reset() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				map[r][c] = copy[r][c];
			}
		}
	}

}
