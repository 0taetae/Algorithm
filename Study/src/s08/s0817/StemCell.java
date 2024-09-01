package s08.s0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class StemCell {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static class Info {
		int r;
		int c;
		int time;
		int activeTime;
		int dieTime;
		public Info(int r, int c, int time, int activeTime, int dieTime) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.activeTime = activeTime;
			this.dieTime = dieTime;
			
		}
	}
	
	Queue<Info> q = new LinkedList<>();
	ArrayList<Info> list = new ArrayList<Info>(); 
	
	// 해당 나라 위치(인덱스) 저장 
	//q.offer(new Idx(r,c));
	//list.add(new Idx(r,c));

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	Info[][] map = new Info[N+K*2][M+K*2];
        	
        	for(int r=K; r<N+K ;r++ ) {
        		st = new StringTokenizer(br.readLine());
        		for(int c=K; c<M+K; c++) {
        			int X = Integer.parseInt(st.nextToken());
        			if(X!=0) {
        				map[r][c] = new Info(r, c, X, 0, 0);
        			}
        		}
        	}
        	PriorityQueue<Info> cell = new PriorityQueue<>((a, b) -> b.time - a.time);
        	for(int t = 1;t<=K;t++) {
        		for(int r=0;r<N+K*2;r++) {
        			for(int c=0;c<M+K*2;c++) {
        				if(map[r][c].activeTime==1) {
        					cell.offer(map[r][c]);
        				}
        			}
        		}
        		
        		
        	}
        	
        	
        	
        	
        }
        	
        
    }

}

