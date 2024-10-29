package s10.s1029;

import java.io.*;
import java.util.*;

public class BOJ_19236 {
	// 물고기가 이동할 수 없으면 반시계방향으로 45도 회전
	// 이동할 수 있는 칸이 없으면 이동 x

	// 상어는 물고기를 먹으면, 그 물고기의 방향을 가짐,
	// 이동할 수 있는 칸이 없으면 공간을 벗어나 집으로 간다.

	//static int[][] map = new int[4][4]; // 물고기 번호와 방향 배열
	//static int[][] fisharr = new int[17][3];
	// 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int res = 0;

	//static int sharkDir = 0;

	static class Info {
		int num;
		int dir;

		Info(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[4][4];
		int[][] fisharr = new int[17][3];
		
		for (int r = 0; r < 4; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 4; c++) {
				int num = Integer.parseInt(st.nextToken()); // 물고기 번호
				int dir = Integer.parseInt(st.nextToken()) - 1;  // 물고기 방향
				map[r][c] = num;
				// 물고기 위치, 방향
				fisharr[num][0] = r;
				fisharr[num][1] = c;
				fisharr[num][2] = dir;
			}
		}
		
		// (0,0) 상어 시작 위치 (0,0)에 있는 물고기 먹음 
		//int startNum = map[0][0];
		//sharkDir = fisharr[startNum][2];  // 먹은 물고기 방향 = 상어 방향
		//map[0][0] = -1;   // 
		//fisharr[startNum][2] = -1;  // 상어가 먹은 물고기 -> 없어짐 

		sharkMove(0, 0, 0, map,fisharr,0);  // (0,0)에서 시작, 먹은 물고기
		System.out.println(res);
	}

	// 상어 이동 -> 백트래킹
	public static void sharkMove(int startX, int startY, int sum, int[][] map, int[][] fisharr,int sharkDir) {
		System.out.println("상어 방향"+sharkDir);
		
		sum+=map[startX][startY]; // 먹은 물고기 합 
		sharkDir = fisharr[map[startX][startY]][2];  // 상어 방향 = 먹은 물고기 방향 
		fisharr[map[startX][startY]][2] = -1;  // 먹은 물고기의 방향을 -1로 하기 
		map[startX][startY] = -1;  // 상어 위치 업데이트 
		
		
		res = Math.max(res, sum);  // 상어가 먹을 수 있는 물고기 번호의 합의 최댓값
		
		System.out.println("상어 이동 후 = 물고기 먹은 후 ");
		for(int r=0;r<4;r++) {
			for(int c=0;c<4;c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
		
		fishMove(fisharr,map);  // 물고기 모두 이동 
		System.out.println("물고기 이동 후 ");
		for(int r=0;r<4;r++) {
			for(int c=0;c<4;c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");

		for (int a = 1; a < 4; a++) {
			int curDir = sharkDir;
			int nx = startX + dx[curDir] * a;
			int ny = startY + dy[curDir] * a;
			
			// 물고기가 없는 칸이거나 범위가 벗어난 경우 
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] <= 0) continue;
			//System.out.println("상어 이동 할게!!!!!!!");
			
			map[startX][startY] = 0;
			
			
			int[][] tempMap = new int[4][4];
			int[][] tempFisharr = new int[17][3];
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					tempMap[i][j] = map[i][j]; 
				}
			}
			for(int i=1;i<=16;i++) {
				tempFisharr[i][0] = fisharr[i][0];
				tempFisharr[i][1] = fisharr[i][1];
				tempFisharr[i][2] = fisharr[i][2];
			}
			
			//int nextNum = map[nx][ny];  // 먹을 물고기 번호
			//int nextDir = fisharr[nextNum][2]; // 먹을 물고기 방향 
			

			//map[startX][startY] = 0; // 상어가 있었던 자리 
			//fisharr[map[nx][ny]][2] = -1;  // 상어가 먹은 물고기 -> 없앤 처리 
			//map[nx][ny] = -1;  // 상어가 이동한 자리 
			
			//sharkDir = nextDir;  // 상어가 먹은 물고기 방향 = 상어 방향 
			
			
			sharkMove(nx, ny, sum, map, fisharr,sharkDir);
			
			// 원상복구 
//			sharkDir = curDir;  // 원래 상어 방향 
//			map[nx][ny] = nextNum;
//			fisharr[nextNum][2] = nextDir;
//			map[startX][startY] = -1;
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					map[i][j] = tempMap[i][j]; 
				}
			}
			for(int i=1;i<=16;i++) {
				fisharr[i][0] = tempFisharr[i][0];
				fisharr[i][1] = tempFisharr[i][1];
				fisharr[i][2] = tempFisharr[i][2];
			}
			

		}
		
		
		
	}

	// 물고기 이동
	public static void fishMove(int[][] fisharr, int[][] map) {
		for (int i = 1; i <= 16; i++) {
			System.out.println(i+"번 물고기 살펴보자");
//			for(int j=1;j<=16;j++) {
//				System.out.print(fisharr[j][2]+" ");
//			}
//			System.out.println();
			
			int x = fisharr[i][0];
			int y = fisharr[i][1];
			int dir = fisharr[i][2];
			//System.out.println(dir);
			
			// 물고기의 방향이 0 = 해당 번호 물고기 없음
			if (dir < 0) {
				//System.out.println(i+"번 물고기 없음 !!!!");
				//System.out.println("---------------------------------------");
				continue;
			}

			for (int j = 0; j < 8; j++) {
				int nd = (dir + j) % 8;
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				//System.out.println(nd+"이 방향 한번 보자 ");

				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
					//System.out.println("범위 벗어나");
					continue;
				}
				
				// 다음 위치에 물고기가 있는 경우 또는 없는 경우 물고기 이동 가능 
				if (map[nx][ny] >= 0) {
					fisharr[map[nx][ny]][0] = x;
					fisharr[map[nx][ny]][1] = y;

					// 현재 물고기 위치 수정
					fisharr[i][0] = nx;
					fisharr[i][1] = ny;

					// map 수정
					
					map[x][y] = map[nx][ny];
					map[nx][ny] = i;
//					for(int r=0;r<4;r++) {
//						for(int c=0;c<4;c++) {
//							System.out.print(map[r][c]+" ");
//						}
//						System.out.println();
//					}
//					System.out.println("---------------------------------------");
					break;
				}
			}
			// 이동할 수 있는 칸이 없으면 이동하지 않음 
		}
	}

}
