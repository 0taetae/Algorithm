package s10.s1011;

import java.io.*;
import java.util.*;

public class BOJ_5427 {
	
	static int w,h;
	static char[][] map;
	static int startR, startC;
	
	/*
	. : 빈 공간
	# : 벽
	@ : 상근이의 시작 위치
	* : 불
	 
	q 담기, 
	list 담기 -> 개수 세기
	=> 불 퍼짐
	
	옮겨진 칸 or 불이 붙으려는 칸
	이동할 칸 + 이동할 칸의 4방향 모두 불이 없음 -> 상근이 이동
	
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());  // 너비, 열
			h = Integer.parseInt(st.nextToken());  // 높이, 행
			map = new char[h][w];
			
			// map 생성
			for(int r=0;r<h;r++) {
				String str = br.readLine();
				for(int c=0;c<w;c++) {
					map[r][c] = str.charAt(c);
					// 상근이의 시작 위치
					if(map[r][c]=='@') {
						startR = r;
						startC = c;
					}
				}
			}
			int time=0;
			while(true) {
				move();
				
				fire();
				time++;
			}
			
			
			
		}

	}

	private static void fire() {
		// TODO Auto-generated method stub
		
	}

	private static void move() {
		// TODO Auto-generated method stub
		
	}

}
