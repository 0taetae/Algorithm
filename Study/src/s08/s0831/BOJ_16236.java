package s08.s0831;

import java.io.*;
import java.util.*;

public class BOJ_16236 {
	
	static int N;
	static int[][] arr;
	static int startX, startY;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int totalFish;
	static int babysize;
	static int time;
	static int eatFishCnt;
	static boolean isFinished;
	static int thisEatCnt;
	
	static class Info{
		int x, y, cnt;
		
		Info(int r, int c, int cnt){
			this.x = r;
			this.y = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		totalFish = 0;  // 총 물고기 개수 
		babysize = 2;
		eatFishCnt = 0;
		thisEatCnt=0;
		time=0;
		for(int r=0;r<N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==9) {
					startX = r;
					startY = c;
				}
				if(arr[r][c]!=0 && arr[r][c]!=9) {
					totalFish++;
				}
			}
		}
		arr[startX][startY]=0;
		isFinished = false;
		// 더 이상 먹을 수 있는 물고기가 공간에 없다면 끝
		while(!isFinished) {
			if(eatFishCnt == totalFish) {
				break;
			}
			isFinished = true;
			if(thisEatCnt == babysize) {
				babysize++;
				thisEatCnt=0;
			}
			canEat(startX, startY);
			eatFishCnt++;
		}	
		System.out.println(time);
	}
	// 먹을 수 있는 물고기 탐색 
	public static void canEat(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		ArrayList<Info> lst = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		
		visited[r][c] = true;
		q.offer(new Info(r,c,0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				if(x>=0 && y>=0 && x<N && y<N && arr[x][y]<=babysize && !visited[x][y]) {
					visited[x][y] = true;
					q.offer(new Info(x,y,cur.cnt+1));
					// 먹을 수 있는 물고기는 리스트에 담기 
					if(arr[x][y] !=0 && arr[x][y]<babysize) {
						lst.add(new Info(x,y,cur.cnt+1));
						isFinished = false;  // 먹을 수 있는 물고기가 있으므로 끝낼 수 없음 
					}
				}
			}
		}
		if(lst.size()==0) {
			return;
		}else {
			move(lst);
		}
	}
	// 물고기 이동과 동시에 먹기 
	public static void move(ArrayList<Info> lst) {
		
		if(lst.size()==1) {  // 먹을 수 있는 물고기가 1마리인 경우
			thisEatCnt++;
			Info target = lst.get(0);
			startX = target.x;
			startY = target.y;
			arr[startX][startY] = 0;
			time += target.cnt;
			
			
		}else { // 먹을 수 있는 물고기가 1마리 보다 많은 경우
			// 가장 가까운 물고기 선택, 거리가 같으면 가장 위쪽 물고기 선택, 그래도 같으면 왼쪽 물고기 선택
			Collections.sort(lst, new Comparator<Info>() {

				@Override
				public int compare(Info o1, Info o2) {
					if(o1.cnt == o2.cnt) {
						if(o1.x == o2.x) {
							return o1.y - o2.y;
						}
						return o1.x - o2.x;
					}
					return o1.cnt - o2.cnt;
				} 
			});
			// 먹을 수 있는 물고기 리스트 중 0번째 물고기 먹기 
			thisEatCnt++;
			Info target = lst.get(0);
			startX = target.x;
			startY = target.y;
			arr[startX][startY] = 0;
			time += target.cnt;
		}
	}
}
