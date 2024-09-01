package s08.s0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandCount {
	
	static int[] x_d = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] y_d = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=0;
		while(k<=50) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w==0 & h==0) {
				break;
			}
			int[][] arr = new int[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			k++;
		}

	}

}
