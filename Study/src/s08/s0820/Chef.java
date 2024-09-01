package s08.s0820;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Chef {
	
	static int[][] arr;
	static boolean[] visit;
	static int N;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}   

	
	static void comb(int start, int cnt) {
		if(cnt==N/2) {
			int x=0;
			int y=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(visit[i] && visit[j]) {
						x+=arr[i][j];
					}
					else if(!visit[i] && !visit[j]){
						y+=arr[i][j];
					}
				}
			}
			min = Math.min(min,Math.abs(x-y));
			return;
		}
		
		for(int i=start; i< N; i++) {
			visit[i]=true;
			comb(i+1,cnt+1);
			visit[i]=false;
		}
	}
}
