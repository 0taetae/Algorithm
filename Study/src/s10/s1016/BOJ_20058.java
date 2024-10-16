package s10.s1016;

import java.io.*;
import java.util.*;

public class BOJ_20058 {
	
	static int N,Q;
	static int[][] map;
	static int mapSize;
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
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 2^N 
		Q = Integer.parseInt(st.nextToken());  // 파이어스톰 횟수
		mapSize = (int) Math.pow(2, N);
		map = new int[mapSize][mapSize];  // 얼음의 양 
		
		for(int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> lst = new ArrayList<>();  // 파이어스톰 정보
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			lst.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < Q; i++) {
			int curSize = (int) Math.pow(2, lst.get(i));  // 2^L
			
			for(int r = 0; r < mapSize; r += curSize) {
				for(int c = 0; c < mapSize; c += curSize) {
					turn(r, c, curSize);
				}
			}
			cntDown();  // 얼음 개수 감소
		}

		iceCnt();  // 남아있는 얼음 개수 세기
		bigIceCnt();  // 가장 큰 덩어리가 차지하는 칸의 개수
	}
	
	// startR,startC를 기준으로 size만큼 크기의 배열 회전 
	public static void turn(int startR, int startC, int size) {
		for (int i = 0; i < size / 2; i++) {
	        int start = i;
	        int end = size - 1 - i;
	        
	        for (int j = start; j < end; j++) {
	            int m = j - i;

	            int temp = map[startR + i][startC + j];
	            
	            // 왼쪽으로 이동
	            map[startR + i][startC + j] = map[startR + end-m][startC + i];
	            
	            // 아래쪽으로 이동
	            map[startR + end-m][startC + i] = map[startR + end][startC + end-m];
	            
	            // 오른쪽으로 이동
	            map[startR + end][startC + end-m] = map[startR + j][startC + end];
	            
	            // 위쪽으로 이동 
	            map[startR + j][startC + end] = temp;
	        }
	    }
	}
	
	// 얼음이 있는 칸 3개 이상과 인접해있지 않은 칸은 얼음의 양 줄어듬 
	public static void cntDown() {
	    boolean[][] check = new boolean[mapSize][mapSize];
	    
	    // 각 칸에 대해 얼음이 있는 칸과 3개 이상 인접한지
	    for (int r = 0; r < mapSize; r++) {
	        for (int c = 0; c < mapSize; c++) {
	            if (map[r][c] == 0) continue;
	            
	            int adjIce = 0;
	            
	            for (int d = 0; d < 4; d++) {
	                int nr = r + dx[d];
	                int nc = c + dy[d];
	                
	                if (nr >= 0 && nr < mapSize && nc >= 0 && nc < mapSize && map[nr][nc] > 0) {
	                    adjIce++;
	                }
	            }
	            
	            // 인접한 얼음 칸이 3개 미만인 경우 
	            if (adjIce < 3) {
	            	check[r][c] = true;
	            }
	        }
	    }
	    
	    // 얼음 감소 
	    for (int r = 0; r < mapSize; r++) {
	        for (int c = 0; c < mapSize; c++) {
	            if (check[r][c]) {
	                map[r][c]--;
	            }
	        }
	    }
	}
	
	// 남아있는 얼음의 합
	public static void iceCnt() {
		int totalIce = 0;
	    
	    for (int r = 0; r < mapSize; r++) {
	        for (int c = 0; c < mapSize; c++) {
	            totalIce += map[r][c];
	        }
	    }
	    
	    System.out.println(totalIce);
	}
	
	
	// 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
	public static void bigIceCnt() {
		boolean[][] visited = new boolean[mapSize][mapSize];
	    int maxSize = 0;
	    
	    for (int r = 0; r < mapSize; r++) {
	        for (int c = 0; c < mapSize; c++) {
	            if (map[r][c] > 0 && !visited[r][c]) {
	                int size = bfs(r, c, visited);
	                maxSize = Math.max(maxSize, size);
	            }
	        }
	    }
	    
	    System.out.println(maxSize); 
	}
	
	// 덩어리 크기 계산
	public static int bfs(int r, int c, boolean[][] visited) {
	    Queue<Info> q = new LinkedList<>();
	    q.add(new Info(r, c));
	    visited[r][c] = true;
	    
	    int size = 1;  // 현재 칸도 포함하므로 1부터 시작
	    
	    while (!q.isEmpty()) {
	        Info cur = q.poll();
	        
	        for (int dir = 0; dir < 4; dir++) {
	            int nx = cur.x + dx[dir];
	            int ny = cur.y + dy[dir];
	            
	            if (nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize && !visited[nx][ny] && map[nx][ny] > 0) {
	                q.add(new Info(nx, ny));
	                visited[nx][ny] = true;
	                size++;
	            }
	        }
	    }
	    
	    return size;
	}
}
