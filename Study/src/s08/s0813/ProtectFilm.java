package s08.s0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProtectFilm {
	static int D;
	static int W;
	static int K;
	static int[][] film;
	static int[] isOk;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			
			film = new int[D][W];
			for(int r=0;r<D;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<W;c++) {
					film[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			isOk = new int[W];
			
			if(K==1) {
				System.out.println("#"+i+" "+0);
				continue;
			}
			for(int c=0;c<W;c++) {
				dfs(c);
			}
			//System.out.println(Arrays.stream(isOk).sum());
			/*
			if(W==Arrays.stream(isOk).sum()) {
				System.out.println("#"+i+" "+0);
				continue;
			}*/
			//System.out.println("#"+i+" "+"change");
			
		}

	}
	public static void dfs(int c) {
		for(int r=0;r<D-1;r++) {
			if(film[r][c]==film[r+1][c]) {
				isOk[c]++;
			}else {
				isOk[c]=0;
			}
			
			// 성능검사 필요없음
			if(isOk[c]==K) {
				break;
			}
			
		}
	}

}
