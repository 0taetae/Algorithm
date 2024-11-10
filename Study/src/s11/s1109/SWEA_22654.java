package s11.s1109;

import java.io.*;
import java.util.*;

public class SWEA_22654 {
	
	static int N, Q;
	static char[][] map;
	static int startR,startC,endR,endC;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int dir;
	static int x,y;
	static boolean isOk;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수 
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());  // 필드 수 
			map = new char[N][N];
			for(int r=0;r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<N;c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c]=='X') {  // 현재 RC 카 위치
						startR = r;
						startC = c;
					}else if(map[r][c]=='Y') {  // RC카를 이동 시키고자 하는 위치 
						endR = r;
						endC = c;
					}
				}
			}
			Q = Integer.parseInt(br.readLine());  // 조종 횟수 
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<Q;i++) {
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());  // 커맨드 길이 
				String com = st.nextToken();  // 커맨드 
				// 조종 시작할 때마다 방향, 시작점, 목적지 도달 여부 초기화 
				dir=0;
				x= startR;
				y = startC;
				isOk = false;
				
				move(com);
				
				if(isOk) {
					sb.append(1).append(" ");
				}else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}

	private static void move(String com) {
		for(int i=0;i<com.length();i++) {
			switch(com.charAt(i)) {
			// 앞으로 이동
			case 'A':
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				// 나무가 있는 곳이나, 필드를 벗어나는 경우 
				if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]=='T') continue;
				x = nx;
				y = ny;
				break;
			// 왼쪽으로 90도 회전
			case 'L':
				dir = (dir-1+4)%4;
				break;
			// 오른쪽으로 90도 회전 
			case 'R':
				dir = (dir+1)%4;
				break;
			}
			
		}
		// 커맨드 전부 실행 후 목적지 도달 여부 확인 
		if(x==endR && y==endC) {
			isOk = true;
		}
		
	}

}
