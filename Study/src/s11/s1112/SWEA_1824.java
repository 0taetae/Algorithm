package s11.s1112;

import java.io.*;
import java.util.*;

public class SWEA_1824 {
	
	static int R,C;
	static char[][] map;
	// 0,0에서 시작 오른쪽 방향으로 이동
	
	// 우, 하, 좌, 상 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][][][] visited;
	static boolean isOk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
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
			isOk = false;
			visited = new boolean[R][C][4][16];
			move(0,0,0,0);
			
			if(isOk) {
				System.out.println("#"+tc+" "+"YES");
			}else {
				System.out.println("#"+tc+" "+"NO");
			}
		}

	}
	public static void move(int r,int c,int dir,int num) {
		// 도착 가능할 때
		if(isOk) return;
		if(r<0) r=R-1;
		if(r>=R) r=0;
		if(c<0) c=C-1;
		if(c>=C) c=0;
		
		// 무한 반복 -> 도착 불가 
		if(visited[r][c][dir][num]) return;
		
		visited[r][c][dir][num] = true;
		
		int nextDir = dir;
		int nextNum = num;
		switch(map[r][c]) {
		case '<':
			nextDir = 2;
			break;
		case '>':
			nextDir = 0;
			break;
		case '^':
			nextDir = 3;
			break;
		case 'v':
			nextDir = 1;
			break;
		case '_':
			if(num==0) {
				nextDir = 0;
			}else {
				nextDir=2;
			}
			break;
		case '|':
			if(num==0) {
				nextDir = 1;
			}else {
				nextDir = 3;
			}
			break;
		case '?':
			for (int i = 0; i < 4; i++) {
				nextDir = (dir + i) % 4;
                move(r + dx[nextDir], c + dy[nextDir], nextDir, nextNum);
            }
			return;
		case '.':
			break;
		case '@':
			isOk = true;
			return;
		case '+':
			nextNum++;
			if(nextNum==16) {
				nextNum=0;
			}
			break;
		case '-':
			nextNum--;
			if(nextNum<0) {
				nextNum=15;
			}
			break;
		default:
			nextNum = map[r][c]-'0';
			break;
		
		}
		
		
		move(r+dx[nextDir],c+dy[nextDir],nextDir,nextNum);
		
	}

}
