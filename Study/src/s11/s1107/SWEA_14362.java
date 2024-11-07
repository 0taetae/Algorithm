package s11.s1107;

import java.io.*;
import java.util.*;

public class SWEA_14362 {
	
	// S : 자신이 바라보는 방향으로 1만큼 이동
	// L : 로봇이 왼쪽으로 90도 회전
	// R : 로봇이 오른쪽으로 90도 회전
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	//  규칙이 있을 것 같다!!!!!
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String C = br.readLine();
			int x = 0;
			int y = 0;
			//int nx = 0;
			//int ny = 0;
			int dir=1;
			int res = 0;
			int cnt = 0;
			int up = 0;
			while(cnt<10000) {
				int startDir = dir;
				for (int i = 0; i < C.length(); i++) {
	            	//int startX = x; 
	                //int startY = y;
	                switch (C.charAt(i)) {
	                    case 'S':
	                        x += dx[dir];
	                        y += dy[dir];
	                        res = Math.max(res,x*x+y*y);
	                        break;
	                    case 'L':
	                        dir = (dir - 1 + 4) % 4;
	                        break;
	                    case 'R':
	                        dir = (dir + 1) % 4;
	                        break;
	                }
	                
//	                cnt++;
//	                if(res < x*x + y*y){
//	                	res = x*x + y*y;
//	                	up++;
//	                }
	                //res = Math.max(res, Math.sqrt(Math.pow((x), 2) + Math.pow((y), 2)));
	            }
				if(x==0 && y==0) {
					break;
				}
				if(startDir==dir) {
					res = -1;
					break;
				}
	            //System.out.println(res*2);
	            //cnt++;
			}
			if(res==-1) {
				System.out.println("#"+tc+" oo");
			}else {
				System.out.println("#"+tc+" "+res);
			}

            
			
			//System.out.println("------");
			
		}
		

	}

}
