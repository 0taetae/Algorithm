package s09.s0905;

import java.io.*;
import java.util.*;

public class BOJ_2234 {

	/*
	이 성에 있는 방의 개수, 가장 넓은 방의 넓이, 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
	서(1)북(2)동(4)남(8)
	 */
	// 서북동남 
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int N,M, roomCnt;
	static int[][] castle;
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
		// 칸의 개수(방의 넓이)를 기준으로 내림차순 정렬 
		Collections.sort(roomList,new Comparator<List<Info>>() {
			@Override
			public int compare(List<Info> o1, List<Info> o2) {
				return o2.size() - o1.size();
			}
			
		});
		//System.out.println(roomCnt);  // 이 성에 있는 방의 개수
		//System.out.println(roomList.get(0).size());  // 가장 넓은 방의 넓이
		int res = 0;
		for(int i=0;i<roomCnt-1;i++) {
			for(int j=i+1;j<roomCnt;j++) {
				System.out.println("있을까?");
				if(wallRemove(i,j)) {
					res = roomList.get(i).size() + roomList.get(j).size();
				}
			}
		}
		System.out.println(res);

	}
	public static void roomCheck(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(r,c));
		roomList.get(roomCnt).add(new Info(r,c));
		visited[r][c] = true;
		
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
			}
		}
	}
	// 칸의 개수가 많은 두개의 방의 각 칸이 서로 인접한가 확인 
	public static boolean wallRemove(int a, int b) {
		for(int i=0;i<roomList.get(a).size();i++) {
			Info target = roomList.get(a).get(i);
			
			for(int dir=0;dir<4;dir++) {
				int nx = target.x + dx[dir];
				int ny = target.y + dy[dir];
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue; 
				if(roomList.get(b).contains(new Info(nx,ny))) {
					System.out.println("있음");
					return true;
				}
			}
		}
		return false;
	}

}
