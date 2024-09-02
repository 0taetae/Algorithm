package s09.s0902;

import java.io.*;
import java.util.*;

public class SWEA_5653 {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Info{
		int x,y,lifeForce, time, state;
		Info(int x,int y, int lifeForce, int time, int state){
			this.x = x;
			this.y = y;
			this.lifeForce = lifeForce;
			this.time = time;
			this.state = state;
		}
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	
	    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
	
	    for (int i = 1; i <= T; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int N = Integer.parseInt(st.nextToken());
	    	int M = Integer.parseInt(st.nextToken());
	    	int K = Integer.parseInt(st.nextToken()); // 배양 시간
	
	    	int[][] arr = new int[N + 2 * K][M + 2 * K];  // 배양시간에 따라 세포 배양 후의 크기를 고려하여 배열 생성 
	
	    	List<Info> cells = new ArrayList<>(); // 세포 리스트
	
	    	for (int r = 0; r < N; r++) {
	    		st = new StringTokenizer(br.readLine());
	    		for (int c = 0; c < M; c++) {
	    			int lifeForce = Integer.parseInt(st.nextToken());
	    			if (lifeForce != 0) {
	    				arr[r + K][c + K] = lifeForce;
	    				cells.add(new Info(r + K, c + K, lifeForce, 0, 0));
	    			}
	    		}
	    	}
	    	
	    	// 배양 시간 흐름 
	    	for (int time = 1; time <= K; time++) {
	    		// 살아있는 세포 큐, 생명력을 기준으로 내림차순 
	    		PriorityQueue<Info> activeCells = new PriorityQueue<>(new Comparator<Info>() {

					@Override
					public int compare(Info o1, Info o2) {
						return o2.lifeForce - o1.lifeForce;
					}
	    		});
	
	    		// 활성 상태인 세포를 
	    		for(int j=0;j<cells.size();j++) {
	    			Info cell = cells.get(j);
	    			if(cell.state == 1) {
	    				activeCells.offer(cell);
	    			}
	    		}
	
	    		// 세포 상태 업데이트
	    		for (int j = 0; j < cells.size(); j++) {
	    			cells.get(j).time++; // 경과 시간 증가
	    			if (cells.get(j).time == cells.get(j).lifeForce) { // 생명력 수치인 X 시간 도달 
	    				cells.get(j).state = 1; // 활성화 상태로 변경
	    			} else if (cells.get(j).time == cells.get(j).lifeForce * 2) { // 2*X 시간 도달 -> 죽음 
	    				cells.remove(j);
	    				j--;
	    			}
	    		}
	
	    		// 활성 상태인 세포 번식 
	    		while (!activeCells.isEmpty()) {
	    			Info cell = activeCells.poll();
	    			for (int dir = 0; dir < 4; dir++) {
	    				int nx = cell.x + dx[dir];
	    				int ny = cell.y + dy[dir];
	    				if (arr[nx][ny] != 0) continue;
	    				arr[nx][ny] = cell.lifeForce;
	    				cells.add(new Info(nx, ny, cell.lifeForce, 0, 0)); // 새로운 세포 추가
	    			}
	    		}
	    	}	
	    	// 살아있는 줄기 세포 개수 
	    	int activeCellCount = 0;
	    	for (Info cell : cells) {
	    		// 생명력 수치인 X 시간동안 비활성 상태, 이후 X 시간동안 활성 상태, 끝나면 죽음 -> 2*X 시간동안 살아있는 상태 
	    		if (cell.time < cell.lifeForce * 2) { 
	    			activeCellCount++;
	    		}
	    	}
	    	sb.append("#").append(i).append(" ").append(activeCellCount).append("\n");
	    }
	    System.out.println(sb.toString());
	}
}

