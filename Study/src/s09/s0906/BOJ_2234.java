package s09.s0906;

import java.io.*;
import java.util.*;

public class BOJ_2234 {

	// 서(1)북(2)동(4)남(8)
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int N,M, roomCnt;
	static int[][] castle,roomNum;
	static boolean[][] visited;
	static List<List<Info>> roomList = new ArrayList<>();  // 방의 개수 
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 열 개수
		M = Integer.parseInt(st.nextToken());  // 행 개수 
		castle = new int[M][N];  // 벽 정보 
		roomNum = new int[M][N];
		visited = new boolean[M][N];  // 방의 개수 계산할때 방문 표시 
		for(int r=0;r<M;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				castle[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 이 성에 있는 방의 개수 구하기 
		roomCnt=0;
		for(int r=0;r<M;r++) {
			for(int c=0;c<N;c++) {
				if(!visited[r][c]) {
					roomList.add(new ArrayList<>());
					roomCheck(r,c);
					roomCnt++;
				}
			}
		}
		// 가장 넓은 방의 넓이(칸 수)
		int maxRoom = 0;
		for(int i=0;i<roomList.size();i++) {
			maxRoom = Math.max(maxRoom, roomList.get(i).size());
		}
		
		// 인접한 칸이 다른 방에 있으면 해당 두 방의 칸 수 더하기 -> 최댓값 구하기 
		int res = 0;
		for(int r=0;r<M;r++) {
			for(int c=0;c<N-1;c++) {
				if(roomNum[r][c]!=roomNum[r][c+1]) {
					res = Math.max(res, roomList.get(roomNum[r][c]).size()+roomList.get(roomNum[r][c+1]).size());
				}
			}
		}
		for(int c=0;c<N;c++) {
			for(int r=0;r<M-1;r++) {
				if(roomNum[r][c]!=roomNum[r+1][c]) {
					res = Math.max(res, roomList.get(roomNum[r][c]).size()+roomList.get(roomNum[r+1][c]).size());
				}
			}
		}
		
		System.out.println(roomCnt);  // 이 성에 있는 방의 개수
		System.out.println(maxRoom);  // 가장 넓은 방의 넓이
		System.out.println(res);  // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기 

	}
	public static void roomCheck(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(r,c));
		roomList.get(roomCnt).add(new Info(r,c));
		visited[r][c] = true;
		roomNum[r][c] = roomCnt;  // 방의 번호 매기기 
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			// 해당 방향에 벽이 있는지 
			for(int i=0;i<4;i++) {
				// 해당 방향에 벽이 있으면 패스 
				if((castle[cur.x][cur.y] &(1<<i)) != 0) continue;
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || ny<0 || nx>=M || ny>=N || visited[nx][ny]) continue; 
				q.offer(new Info(nx, ny));
				roomList.get(roomCnt).add(new Info(nx,ny));
				visited[nx][ny] = true;
				roomNum[nx][ny] = roomCnt;
			}
		}
	}

}
