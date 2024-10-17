package s10.s1017;

import java.io.*;
import java.util.*;

public class BOJ_8972 {
	
	/*
	1. 아두이노를 8방향 이동 or 그대로
	2. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우 게임 끝 -> lose
	3. "미친 아두이노"는 종수의 위치, 미친 아두이노의 위치 거리차가 가장 작아지는 방향으로 이동 |r1-r2| + |s1-s2|
	4. 미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한 경우 게임 끝 -> lose
	5. 2개 이상의 미친 아두이노가 같은 칸에 이쓴ㄴ 경우 큰 폭발이 일어남 -> 그 칸에 있는 아두이노는 모두 파괴
	
	. 빈칸 R 미친 아두이노 I 종수의 위치
	5는 그자리에 있는 것 
	 */
	
	static int R,C;
	static char[][] map;
	
	// 좌하, 하, 우하, 좌, 정지, 우, 좌상, 상, 우상 
	static int[] dx = {1,1,1,0,0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,0,1,-1,0,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		String command = br.readLine();

	}
	
	// 종수 이동
	// 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한지 확인
	public static void personMove() {
		
	}
	
	
	// 미친 아두이노 이동
	// 미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한지 확인
	public static void madMove() {
		
	}
	
	
	// 2개 이상의 미친 아두이노가 같은 칸에 있는지 확인 
	public static void check() {
		
	}
	

}
