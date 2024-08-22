package s0822;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SquareRoom {
	
	static int N;
	static int[][] room;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] count;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			count = new int[N*N+1];
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int max=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					result=1;
					check(r,c);
					count[room[r][c]] = result;
					max = Math.max(max, result);
				}
			}
			for(int j=1;j<=N*N;j++) {
				if(max == count[j]) {
					bw.write(String.format("#%d %d %d\n", i, j, count[j]));
					break;
				}
			}
		}
		bw.flush();

	}
	public static void check(int r, int c) {
		
		for(int i=0;i<4;i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			
			if(x>=N || y>=N || x<0 || y<0) continue;
			
			if(room[x][y] - room[r][c] ==1) {
				result++;
				check(x, y);
			}
			else {
				continue;
			}
		}
	}
}
