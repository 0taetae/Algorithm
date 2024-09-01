package s08.s0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PopulationMove {
	
	static int N ;
	static int[][] A = new int[N][N];
	static int L;
	static int R;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visit ;
	static int count=0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}

	}
	public static void check(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		LinkedList<Integer> xidx = new LinkedList<>();  // 인구이동 발생한 나라 행좌표 
		LinkedList<Integer> yidx = new LinkedList<>();  // 인구이동 발생한 나라 열좌표 
		q.add(A[r][c]);
		int sum = 0; 
		
		for(int i=0;i<4;i++) {
			int x = r + dr[i];
			int y = c + dc[i];
			int dif = Math.abs(A[r][c]-A[x][y]);
			if(!visit[x][y]) {
				if(dif>=L && dif <=R) {
					q.add(A[x][y]);
					sum+=A[x][y];
					visit[x][y] = true;
					
				}
			}
		}
		change(xidx,yidx,sum);
		
	}
	public static void change(LinkedList<Integer> xidx, LinkedList<Integer> yidx, int sum) {
		int changeValue = sum/xidx.size();
		for(int i=0;i<xidx.size();i++) {
			A[xidx.get(i)][yidx.get(i)] = changeValue;
		}
		count++;
		
	}

}