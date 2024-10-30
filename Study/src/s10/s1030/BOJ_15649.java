package s10.s1030;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
	
	static int N,M;
	static boolean[] visited;
	static int[] select;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		select = new int[M];
		
		
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for(int j=0;j<M;j++) {
				System.out.print(select[j]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				select[cnt]=i;
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}

}
