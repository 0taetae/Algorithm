package s09.s0903;

import java.io.*;
import java.util.*;

public class BOJ_4485 {
	
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int[][] minSum;
	
	static class Info implements Comparable<Info>{
		int x,y, sum;
		public Info(int x, int y,int sum){
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.sum, o.sum);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc=1;
		while(true) {
			N = Integer.parseInt(br.readLine());  // 동굴의 크기 
			if(N==0) break;  // 입력이 0이면 종료 
			arr = new int[N][N];  // 도둑루피의 크기 
			minSum = new int[N][N];  // 잃는 루피 최소값
			
			// 0,0 부터 시작 -> N-1, N-1 도착
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// minSum 배열을 최대값으로 초기화 
			for(int i=0;i<N;i++) {
				Arrays.fill(minSum[i], Integer.MAX_VALUE);
			}
			minSum[0][0] = arr[0][0];
			move(0,0,0);
			sb.append("Problem ").append(tc).append(": ").append(minSum[N-1][N-1]).append("\n");
			tc++;
		}
		System.out.println(sb);
	}
	public static void move(int r, int c,int sum) {
		PriorityQueue<Info> q = new PriorityQueue<Info>();
		q.offer(new Info(r,c,arr[r][c]));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x<0 || y<0 || x>=N || y>=N ) continue;
				
				// 더한 값이 이전 값보다 작을 때만 큐에 넣기 
				if(minSum[x][y]> (cur.sum+arr[x][y])) {
					minSum[x][y] = Math.min(minSum[x][y], (cur.sum+arr[x][y]));
					q.offer(new Info(x,y,minSum[x][y]));
				}
			}
		}	
	}
}
