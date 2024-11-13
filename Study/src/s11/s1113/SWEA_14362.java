package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_14362 {
	
	// 처음 방향 오른쪽, 원점 
	
	static char[] com;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			int len = str.length();
			com = new char[str.length()];
			for(int i=0;i<len;i++) {
				com[i] = str.charAt(i);
			}
			//System.out.println("len"+len);
			int dir=1;
			int x = 0;
			int y = 0;
			int res=0;
			boolean isOk = false;
			
			// 루틴 4번이면 처음과 동일한 방향으로 무조건 돌아옴
			for(int i=0;i<4;i++) {
				int nextDir = dir;
				for(int j=0;j<len;j++) {
					//System.out.println("j "+j);
					switch(com[j]) {
					case 'S':
						//System.out.println("직진");
						x += dx[dir];
						y += dy[dir];
						break;
					case 'L':
						//System.out.println("왼쪽");
						dir--;
						if(dir<0) dir=3;
						break;
					case 'R':
						//System.out.println("오른쪽");
						dir++;
						if(dir>=4) dir=0;
						break;
					}
					res = Math.max(res, x*x + y*y);
				}
				//System.out.println(x+" "+y);
				//System.out.println(dir +" "+nextDir);
				
			}
			if(x==0 && y==0) {
				isOk = true;
			}
			if(!isOk) {
				System.out.println("#"+tc+" "+"oo");
			}else {
				System.out.println("#"+tc+" "+res);
			}
			
		}

	}

}
