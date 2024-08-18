package s07.s0730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minecraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int min = 256;  // 땅의 최대 높이
		int max = 0;
		int[][] g = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				g[i][j]=Integer.parseInt(st.nextToken());
				max = Math.max(max,g[i][j]);
				min = Math.min(min, g[i][j]);
			}
		}
		int T=Integer.MAX_VALUE;
		int height=0;
		int[][] check = new int[max-min+1][2];
		for(int k=min;k<=max;k++) {
			int time=0;
			int block = B;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(g[i][j]>k) {  // 좌표의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는 경우 
						time += (g[i][j]-k)*2;
						block+=(g[i][j]-k);
					}
					else if(g[i][j]<k){  // 인벤토리에서 블록 하나를 꺼내는 경우
						time += (k-g[i][j]);
						block-=(k-g[i][j]);
					}
				}
			}
			if(block<0) {  // 인벤토리에 있는 블록이 부족한 경우 
				break;
			}
			else {
				if(T>=time) {  // 땅 고르기 작업에 걸리는 최소 시간 
					T = time;
					height=k;
				}
			}
			
		}
		System.out.println(T+" "+height);
		
		

	}

}
