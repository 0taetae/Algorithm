package s09.s0909;

import java.io.*;
import java.util.*;

public class SWEA_1767 {
	
	static int N;
	static int[][] map;
	static ArrayList<Info> core;
	static boolean[] isSelected;
	static int maxCore, minLen;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<Info>();
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==1 && r>0 && c>0 && r<N-1 && c<N-1) {
						core.add(new Info(r,c));
					}
				}
			}
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			
			// 최대한 많은 코어에 전원을 연결해야하므로 최대 개수부터 감소하면서 찾기
			for(int i=core.size();i>=1;i--) {
				isSelected = new boolean[core.size()];
				comb(0,0,i);
				if(maxCore>0) break;
			}
			System.out.println(minLen);
			
		}

	}
	static void comb(int cnt, int start ,int K) {
		if(cnt==K) {
			
			check(0,0,0);
			return;
		}
		for(int i=start;i<core.size();i++) {
			isSelected[i] = true;
			comb(cnt+1, i+1, K);
			isSelected[i] = false;
		}
	}
	static void check(int index, int connectedCnt, int wireLen) {
		if(index== core.size()) {
			if(connectedCnt > maxCore) {
				maxCore = connectedCnt;
				minLen = wireLen;
			}else if(connectedCnt == maxCore) {
				minLen = Math.min(minLen, wireLen);
			}
			return;
		}
		
		if(!isSelected[index]) {
			check(index+1, connectedCnt, wireLen);
			return;
		}
		
		int r = core.get(index).x;
		int c = core.get(index).y;
		
		for(int i=0;i<4;i++) {
			int x = r;
			int y = c;
			int len = 0;
			boolean isConnected = true;
			while(true) {
				x += dx[i];
				y += dy[i];
				
				if(x<0 || y<0 || x>=N || y>=N) break;
				if(map[x][y] !=0) {
					isConnected = false;
					break;
				}
				len++;
			}
			if(isConnected) {
				x = r;
				y = c;
				for(int j=0;j<len;j++) {
					x += dx[i];
					y += dy[i];
					map[x][y] = -1;
				}
				check(index+1, connectedCnt+1, wireLen+len);
				for(int j=0;j<len;j++) {
					x += dx[i];
					y += dy[i];
					map[x][y] = 0;
				}
			}
		}
		check(index+1, connectedCnt, wireLen);
		
	}

}
