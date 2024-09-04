package s09.s0904;

import java.io.*;
import java.util.*;

public class SWEA_1494 {
	
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static long sumX, sumY, res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			res = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			visited = new boolean[N];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				arr[r][0] = Integer.parseInt(st.nextToken());
				arr[r][1] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}
	// 조합으로 출발 지렁이 선택하기 
	public static void comb(int cnt,int start) {
		if(cnt == N/2) {
			sumX = 0;
			sumY = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sumX += arr[i][0];
					sumY += arr[i][1];
				}else {
					sumX -=arr[i][0];
					sumY -=arr[i][1];
				}
			}
			res = Math.min(res, (long)(sumX*sumX + sumY*sumY));
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(cnt+1,i+1);
				visited[i] = false;
			}
		}
	}

}
