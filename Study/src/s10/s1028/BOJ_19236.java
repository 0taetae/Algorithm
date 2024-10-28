package s10.s1028;

import java.io.*;
import java.util.*;

public class BOJ_19236 {
	// 물고기가  이동할 수 없으면 반시계방향으로 45도 회전
	// 이동할 수 있는 칸이 없으면 이동 x 
	
	// 상어는 물고기를 먹으면, 그 물고기의 방향을 가짐, 
	// 이동할 수 있는 칸이 없으면 공간을 벗어나 집으로 간다.
	
	static Info[][] map = new Info[4][4];  // 물고기 번호와 방향 배열 
	// 0, 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
	static int[] dx = {0,-1, -1,0,1,1,1,0,-1};
	static int[] dy = {0, 0, -1,-1,-1,0,1,1,1};
	static boolean[][] visited=new boolean[4][4];
	static int res=0;
	
	static boolean isEnd = false;
	static int startX = 0;
	static int startY = 0;
	static int sharkDir=0;
	
	static class Info{
		int num;
		int dir;
		Info(int num,int dir){
			this.num = num;
			this.dir = dir;
		}
	}
	// 물고기 리스트
	// 물고기 번호와 방향 
	//static ArrayList<Node> fishList = new ArrayList<>();
	//static ArrayList<Node> newfishList ;
//	static class Node{
//		//int num;
//		int x,y;
//		int dir;
//		Node(int x, int y, int dir){
//			this.x = x;
//			this.y = y;
//			this.dir = dir;
//			//this.num = num;
//		}
//	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Info[][] map = new Info[4][4];
		//ArrayList<Node> fishList = new ArrayList<>();
		for(int r=0;r<4;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0;c<4;c++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[r][c] = new Info(num,dir);
			}
		}
		//Collections.sort(fishList,(o1,o2)->(o1.num - o2.num));  // 물고기 번호 순서대로 오름차순 정렬
		
		//int res=0;
		visited[0][0] = true;
		res+=map[0][0].num;
		map[0][0].num=0;
		sharkDir = map[0][0].dir;
		

	}
	
	// 상어 이동 -> 백트래킹
	public static void sharkMove(int startX, int startY, int res) {
		//int curDir = map[startX][startY].dir; // 현재 상어의 방향 = 해당 좌표에 있는 물고기의 방향
		//res+=map[startX][startY].num;
		fishMove();
		
		for(int a=1;a<4;a++) {
			int curDir = map[startX][startY].dir;
			int curSharkDir = sharkDir;
			int nx = startX + dx[curDir]*a;
			int ny = startY + dy[curDir]*a;
			int nextNum = map[nx][ny].num;
			int nextDir = map[nx][ny].dir;
			
			if(nx<0 || ny<0 || nx>=4 || ny>=4 || map[nx][ny].num==0) continue;
			
			map[nx][ny].num=0;
			sharkDir = map[nx][ny].dir;
			visited[nx][ny] = true;
			
			sharkMove(nx,ny,res+map[nx][ny].num);
			
			visited[nx][ny] = false;
			sharkDir = curSharkDir;
			map[nx][ny].num = nextNum;
			
			
			
		}
	}
	
	
	// 물고기 이동
	public static void fishMove() {
		
	}
	
	

}
