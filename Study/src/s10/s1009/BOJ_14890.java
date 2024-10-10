package s10.s1009;

import java.io.*;
import java.util.*;

public class BOJ_14890 {
	
	static int N,L;
	static int[][] map,ramp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 맵 크기 
		L = Integer.parseInt(st.nextToken());  // 경사로 길이
		
		map = new int[N][N];
		ramp = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		// 가로 탐색 
		for(int i=0;i<N;i++) {
			System.out.println(i+"번째");
			if(downcheck1(i)) {
				res++;
				System.out.println(i+"번째 가로 가능");
			}
		}
		
		// 세로 탐색
//		for(int i=0;i<N;i++) {
//			if(upcheck2(i) && downcheck2(i)) {
//				res++;
//			}
//		}
		System.out.println("답"+res);

	}
	
	

	// 다음 칸이 1 감소할때 경사로 놓기 
	private static boolean downcheck1(int r) {
		for(int i=0;i<N-1;i++) {
			System.out.println(i+"번째 칸");
			// 1 감소할 때
			if(map[r][i]-1 == map[r][i+1]) {
				int num = map[r][i+1];
				System.out.println(num+" 경사로 시작지점 높이");
				System.out.println((i+1+L-1)+"칸까지 경사로 둬야함");
				// 경사로 길이만큼 
				if(i+1+L-1>=N) {
					System.out.println();
					return false;
				}
				System.out.println((i+1)+"부터 경사로 두기");
				for(int j=i+1;j<i+1+L;j++) {
					
					// 경사로 두는 곳은 높이가 같아야 함
					if(map[r][j]== num) {
						ramp[r][j] = 1;
						System.out.println(r+" "+j);
					}else {
						System.out.println("하강 경사로 안댐 "+j);
						return false;
					}
					
				}
				
			}
		}
		return true;
		
	}
	
	// 다음 칸이 1 증가할 대 경사로 놓기 -> 역순으로 확인하여 1감소할 때 경사로 놓기 
	private static boolean upcheck1(int r) {
		
		for(int i=N-1;i>0;i--) {
			if(map[r][i]-1 == map[r][i-1]) {
				for(int j=i-1;j>i-1-L;j--) {
					if(map[r][j]== map[r][j-1]  && ramp[r][j]!=1) {
						ramp[r][j]=1;
						System.out.println(r+" "+j);
					}
					else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private static boolean downcheck2(int i) {
		return false;
	}
	
	private static boolean upcheck2(int i) {
		return false;
	}

}
