package s08.s0817;

import java.io.*;
import java.util.*;

class Cell{
	int x;
	int y;
	int time;
	int aliveTime;
	int dieTime;
	
	public Cell(int time, int aliveTime, int dieTime, int x, int y) {
		this.time = time;
		this.aliveTime = aliveTime;
		this.dieTime = dieTime;
		this.x = x;
		this.y = y;
	}
	
}
public class StemCell_sol2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	Cell[][] cells = new Cell[n+k][m+k];
        	for(int i = k/2; i < n+k/2; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = k/2; j < m+k/2; j++) {
        			int temp = Integer.parseInt(st.nextToken());
        			if(temp == 0) continue;
        			cells[i][j] = new Cell(temp,temp+1,temp*2,i,j);
        		}
        	}
        	for(int i = 1; i <=k; i++) {
        		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
        			@Override
        			public int compare(Cell a, Cell b) {
        				if(a.aliveTime == b.aliveTime) {
        					return b.time-a.time;
        				}
        				return 0;
        			}
        		});
        		boolean[][] visited = new boolean[n+2*k][m+2*k];
        		for(int j = 0; j < n+k; j++) {
        			for(int l = 0; l < m+k; l++) {
        				if(cells[j][l] != null && cells[j][l].aliveTime == i) {
        					pq.add(cells[j][l]);
        				}
        			}
        		}
        		int dx[] = {0,0,1,-1};
        		int dy[] = {1,-1,0,0};
        		while(!pq.isEmpty()) {
        			Cell cur = pq.poll();
        			for(int j = 0; j < 4; j++) {
        				int nx = cur.x+dx[j];
        				int ny = cur.y+dy[j];
        				if(!visited[nx][ny] && cells[nx][ny] == null) {
        					cells[nx][ny] = new Cell(cur.time,i+cur.time+1,i+2*cur.time,nx,ny);
        					visited[nx][ny] = true;
        				}
        			}
        		}
        	}
        	int result = 0;
        	for(int j = 0; j < n+k; j++) {
    			for(int l = 0; l < m+k; l++) {
    					if(cells[j][l] != null && cells[j][l].dieTime > k) {
    						result++;
    				}
    			}
    		}
        	System.out.println("#" + test_case + " " +result);
        	
        }

	}

}




