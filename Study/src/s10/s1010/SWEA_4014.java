package s10.s1010;

import java.io.*;
import java.util.*;

public class SWEA_4014 {
	
	static int N,L;
	static int[][] map,ramp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 맵 크기 
			L = Integer.parseInt(st.nextToken());  // 경사로 길이
			
			map = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0;
			ramp = new int[N+1][N+1];
			// 가로
			for(int i=1;i<=N;i++) {
				if(downcheck1(i)&&upcheck1(i)) {
					res++;
				}
			}
			ramp = new int[N+1][N+1];
			// 세로
			for(int i=1;i<=N;i++) {
				if(upcheck2(i) && downcheck2(i)) {
					res++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);

	}
	
	
	// 가로, 내리막 경사로 
	// 다음 칸이 1 감소할때 경사로 놓기 
	private static boolean downcheck1(int r) {
		for(int i=1;i<N;i++) {
			// 높이가 같은 경우 
			if(map[r][i] == map[r][i+1]) {
				continue;
			}
			// 높이 차이가 1 이상인 경우
			else if(Math.abs(map[r][i] - map[r][i+1])>1) {
				return false;
			}
			// 1 감소할 때
			else if(map[r][i]-1 == map[r][i+1]) {
				int num = map[r][i+1];
				// 경사로 길이만큼 
				if(i+1+L-1>N) {
					return false;
				}
				for(int j=i+1;j<=i+1+L-1;j++) {
					// 경사로 두는 곳은 높이가 같아야 함
					if (map[r][j] == num && ramp[r][j] == 0) {
						ramp[r][j] = 1;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	// 가로, 오르막길 경사로 
	// 다음 칸이 1 증가할 대 경사로 놓기 -> 역순으로 확인하여 1감소할 때 경사로 놓기 
	private static boolean upcheck1(int r) {
		
		for(int i=N;i>1;i--) {
			// 높이가 같은 경우 
			if(map[r][i] == map[r][i-1]) {
				continue;
			}
			// 높이 차이가 1 이상인 경우
			else if(Math.abs(map[r][i] - map[r][i-1])>1) {
				return false;
			}
			else if(map[r][i]-1 == map[r][i-1]) {
				int num = map[r][i-1];
				// 경사로 길이만큼 
				if(i-1-L+1<1) {
					return false;
				}
				
				for(int j=i-1;j>=i-1-L+1;j--) {
					// 경사로 두는 곳은 높이가 같아야 함
					if (map[r][j] == num && ramp[r][j] == 0) {
						ramp[r][j] = 1;
					} else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	// 세로, 오르막길 경사로
	private static boolean downcheck2(int c) {
		for(int i=1;i<N;i++) {
			// 높이가 같은 경우 
			if(map[i][c] == map[i+1][c]) {
				continue;
			}
			// 높이 차이가 1 이상인 경우
			else if(Math.abs(map[i][c] - map[i+1][c])>1) {
				return false;
			}
			// 1 감소할 때
			else if(map[i][c]-1 == map[i+1][c]) {
				int num = map[i+1][c];
				// 경사로 길이만큼 
				if(i+1+L-1>N) {
					return false;
				}
				for(int j=i+1;j<=i+1+L-1;j++) {
					// 경사로 두는 곳은 높이가 같아야 함
					if (map[j][c] == num && ramp[j][c] == 0) {
						ramp[j][c] = 1;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	// 세로, 내리막길 경사로
	private static boolean upcheck2(int c) {
		for(int i=N;i>1;i--) {
			// 높이가 같은 경우 
			if(map[i][c] == map[i-1][c]) {
				continue;
			}
			// 높이 차이가 1 이상인 경우
			else if(Math.abs(map[i][c] - map[i-1][c])>1) {
				return false;
			}
			else if(map[i][c]-1 == map[i-1][c]) {
				int num = map[i-1][c];
				// 경사로 길이만큼 
				if(i-1-L+1<1) {
					return false;
				}
				
				for(int j=i-1;j>=i-1-L+1;j--) {
					// 경사로 두는 곳은 높이가 같아야 함
					if (map[j][c] == num && ramp[j][c] == 0) {
						ramp[j][c] = 1;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

}
