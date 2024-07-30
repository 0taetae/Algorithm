package s0730;

import java.io.IOException;
import java.util.Scanner;

public class minecraft {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int B = sc.nextInt();
		
		long[][] g = new long[N][M];
		double sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				g[i][j]=sc.nextInt();
				sum+=g[i][j];
			}
		}
		long avg = Math.round(sum/(N*M));
		int time = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(g[i][j]==avg) {
					continue;
				}
				else if(g[i][j]>avg) {
					time += (g[i][j]-avg)*2;
				}
				else {
					time += (avg-g[i][j]);
				}
			}
		}
		System.out.println(time+" "+avg);

	}

}
