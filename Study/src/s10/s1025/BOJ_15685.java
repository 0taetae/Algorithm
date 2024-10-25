package s10.s1025;

import java.io.*;
import java.util.*;

public class BOJ_15685 {
	
	// 다음 드래곤 커브는 이전 드래곤 커브를 역순으로 가면서 방향을 찾는다
	// ex dir==0이었으면 dir==1
	// dir==1이었으면 dir==2
	
	static int N;
	static int[][] arr;
	static boolean[][] visited = new boolean[100][100];
	static ArrayList<Info> dragonList = new ArrayList<>(); 
	
	static class Info{
		int startX,startY;
		int endX, endY;
		int dir;
		Info(int startX, int startY, int endX, int endY, int dir){
			this.startX = startX;  // 시작점
			this.startY = startY;
			this.endX = endX;  // 끝점
			this.endY = endY;
			this.dir = dir;  // 방향
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][4];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());  // 시작점
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());  // 시작 방향
			int g = Integer.parseInt(st.nextToken());  // 세대
			arr[i][0] = x;
			arr[i][1] = y;
			arr[i][2] = d;
			arr[i][3] = g;
		}
		
		
		
	}
	
	// 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수 구하기
	// visited boolean으로 표시해두고 확인하기 
	public static void check() {
		
	}

}
