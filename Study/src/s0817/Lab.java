package s0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Lab {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] lab;
	static int result;
	static int N;
	static int M;
	 
	public static class Idx {
		int r;
		int c;
		public Idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		wall(0);
		System.out.println(result);
		

	}
	
	// 벽 세우기 
	public static void wall(int count) {
		if(count == 3) {
			virus();
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M ; c++) {
				if(lab[r][c] == 0) {
					lab[r][c] = 1;
					wall(count+1);
					lab[r][c] = 0;
				}
			}
		}
	}
	
	// 바이러스 있는 곳 확인, 바이러스 퍼짐 
	public static void virus() {
		Queue<Idx> q = new LinkedList<>();
		
		int[][] copylab = new int[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				copylab[r][c] = lab[r][c];
				
				// 바이러스가 있는 곳은 큐에 넣기 
				if(copylab[r][c]==2) {
					q.offer(new Idx(r,c));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Idx temp = q.poll();
			
			int r = temp.r;
			int c = temp.c;
			
			for(int i=0;i<4;i++) {
				
				int x = r + dx[i];
				int y = c + dy[i];
				
				if (x < 0 || y < 0 || x >= N || y >= M ) continue;
				
				// 바이러스 퍼짐  
				if(copylab[x][y]==0) {
					copylab[x][y] = 2;
					q.offer(new Idx(x,y));
				}
				
			}
		}
		Safe(copylab);
		
	}
	
	// 안전영역 크기 구하기 
	public static void Safe(int[][] copylab) {
		int size=0;
		for(int r=0;r<N;r++) {
			for(int c=0; c<M;c++) {
				if(copylab[r][c]==0) {
					size++;
				}
			}
		}
		// 안전영역 최댓값 구하기 
		result = Math.max(result, size);
		
	}
	

}

/*
import java.io.*;
import java.util.*;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static boolean[][] visited;
	public static int n;
	public static int m;
	public static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] nums = new int[n][m];
		temp = new int[n][m];
		for(int i =0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(nums[i][j] != 0) continue;
				for(int k = 0; k < n; k++) {
					for(int l = 0; l < m; l++) {
						if(k == i && l == j) continue;
						if(nums[k][l] != 0) continue;
						for(int o = 0; o < n; o++) {
							for(int p = 0; p < m; p++) {
								if((o == i && p == j) || (o == k && p == l)) continue; 
								if(nums[o][p] != 0) continue;
								for(int q = 0; q < n; q++) {
									temp[q] = Arrays.copyOf(nums[q], m);
								}
								temp[i][j] = 1;
								temp[k][l] = 1;
								temp[o][p] = 1;
								visited = new boolean[n][m];
								func();
								int count = 0;
								for(int q = 0; q < n; q++) {
									for(int r = 0; r < m; r++) {
										if(temp[q][r] == 0) {
											count++;
										}
									}
								}
								if(max < count) max = count;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}
	public static void func() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && temp[i][j] == 2) {
					Deque<Pos> deque = new ArrayDeque<>();
					deque.add(new Pos(j,i));
					visited[i][j] = true;
					while(!deque.isEmpty()) {
						Pos tem = deque.poll();
						int[] dx = {-1,1,0,0};
						int[] dy = {0,0,-1,1};
						for(int k = 0; k < 4; k++) {
							int nx = tem.x + dx[k];
							int ny = tem.y + dy[k];
							if(nx >= 0 && ny >= 0 && nx < m && ny < n &&!visited[ny][nx] && temp[ny][nx] != 1) {
								temp[ny][nx] = 2;
								visited[ny][nx] = true;
								deque.add(new Pos(nx,ny));
							}
						}
					}
				}
			}
		}
	}
}
 */





