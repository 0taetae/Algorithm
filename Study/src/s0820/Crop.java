package s0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Crop {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int sum;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int r=0; r<N;r++) {
				String str = br.readLine();
				for(int c=0;c<N;c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}
			sum=0;
			
			for(int r=0; r<=N/2;r++) {
				
				for(int c=N/2-r;c<=N/2+r;c++) {
					sum+=map[r][c];
				}
			}
			for(int r=N/2+1;r<N;r++) {
				for(int c=N/2-(N-1-r);c<=N/2+(N-1-r);c++) {
					sum+=map[r][c];
				}
			}
			
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		

	}

}
/*
for (int r=0; r<N;r++)
	{
		for (int c=0; c<N;c++ )
		{
			if(r<=N/2)
			{
				if (r+c<=N/2-1)
					continue;
				else if(c-r>=N/2+1)
					continue;
				else
					sum+=map[r][c];
			}
			else if(r>N/2)
			{
				if(r-c>=N/2+1)
					continue;
				else if(r+c>=N/2*3+1)
					continue;
				else
					sum+=map[r][c];
			}
		}
		System.out.println();
	}
 */




