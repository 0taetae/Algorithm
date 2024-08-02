package s0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] candy = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				candy[i][j] = str.charAt(j);
			}
		}
		int count;
		for(int i=0;i<N-1;i++) {
			count=0;
			for(int j=0;j<N-1;j++) {
				if(candy[i][j]==candy[i][j+1]) {
					count++;
				}
			}
		}
		

	}

}
