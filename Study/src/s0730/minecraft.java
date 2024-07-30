package s0730;

import java.util.Scanner;

public class minecraft {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int B = sc.nextInt();
		int min = 256;
		int max = 0;
		int[][] g = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				g[i][j]=sc.nextInt();
				max = Math.max(max,g[i][j]);
				min = Math.min(min, g[i][j]);
			}
		}
		int T=0;
		int height=0;
		int[][] check = new int[max-min+1][2];
		for(int k=min;k<=max;k++) {
			int time=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(g[i][j]>k) {
						time += (g[i][j]-k)*2;
						B+=(g[i][j]-k);
					}
					else if(g[i][j]<k){
						time += (k-g[i][j]);
						B-=(k-g[i][j]);
					}
				}
			}
			
			if(B>=0){
				if(height<k) {
					T = time;
					height=k;
				}
			}
		}
		System.out.println(T+" "+height);
		
		

	}

}
