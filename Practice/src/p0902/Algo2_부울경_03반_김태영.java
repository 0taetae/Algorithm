package p0902;

import java.io.*;
import java.util.*;

public class Algo2_부울경_03반_김태영 {
	
	static int N,M,K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0,1,-1};
	static int islandNum;
	static int sum;  // 얼어붙은 영역을 제외한 부분 넓이 표시 
	
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];  // 섬의 지도 
		visited = new boolean[M][N];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			// 얼어 붙은 영역  
			for(int r=startX;r<endX;r++) {
				for(int c=startY; c<endY;c++) {
					map[r][c] = 1;
				}
			}
		}
		// 얼어붙은 영역 제외한 부분
		ArrayList<Integer> lst = new ArrayList<>();
		islandNum = 1;
		for(int r=0;r<M;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c] == 0  && !visited[r][c]) {
					mark(r,c);
					islandNum++;
					lst.add(sum);
				}
			}
		}
		// 분리되어 나누어지는 영역의 개수 
		System.out.println(islandNum-1);
		// 각 영역의 넓이 오름차순 정렬 
		Collections.sort(lst);
		for(int i=0;i<lst.size();i++) {
			System.out.print(lst.get(i)+" ");
		}
	}
	public static void mark(int r, int c) {
		sum = 1;
		Queue<Info> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new Info(r,c));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				if(x<0 || y<0 || x>=M || y >=N || visited[x][y]) continue;
				if(map[x][y]==0) {
					q.offer(new Info(x,y));
					visited[x][y] = true;
					sum++;
				}
			}
		}
	}

}
