package s11.s1108;

import java.io.*;
import java.util.*;

public class SWEA_14362 {
	
	// S : 자신이 바라보는 방향으로 1만큼 이동
	// L : 로봇이 왼쪽으로 90도 회전
	// R : 로봇이 오른쪽으로 90도 회전
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String C = br.readLine();
			// 원점에서 시작
			int x = 0;
			int y = 0;
			// 처음은 오른쪽 방향 
			int dir=1;
			int res = 0;  // R^2
			while(true) {
				int startDir = dir;
				for (int i = 0; i < C.length(); i++) {
	                switch (C.charAt(i)) {
	                	// 바라보는 방향으로 1만큼 이동 
	                    case 'S':
	                        x += dx[dir];
	                        y += dy[dir];
	                        res = Math.max(res,x*x+y*y);
	                        break;
	                    // 왼쪽으로 90도 회전
	                    case 'L':
	                        dir = (dir - 1 + 4) % 4;  // 나머지 연산 보다 if문으로 dir<0이면, dir=3으로 수정하는 것이 효율적 
	                        break;
	                    // 오른쪽으로 90도 회전 
	                    case 'R':
	                        dir = (dir + 1) % 4;
	                        break;
	                }
	            }
				// 모든 명령어를 수행했을 때 다시 원점으로 돌아오는 경우 -> 작업이 무한히 반복되어도 동일 
				if(x==0 && y==0) {
					break;
				}
				// 모든 명령어를 수행했을 때 다시 원점으로 돌아오지 않으면서, "모든 명령 실행 시작전 방향 == 모든명령 실행 후 방향" 인 경우 
				// => R=oo
				if(startDir==dir) {
					res = -1;
					break;
				}
			}
			if(res==-1) {
				System.out.println("#"+tc+" oo");
			}else {
				System.out.println("#"+tc+" "+res);
			}
		}
	}
}
/*
4
SLSSLLSSRS  => 원점으로 돌아옴 
LS => 
S   => 명령 실행 시작전 방향 == 명령 실행 후 방향 
LLLLC  => 명령 실행 후 원점에 위치 
 */
