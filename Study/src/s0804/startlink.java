package s0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class startlink {
	static int N;
	static int[][] score;  // 능력치
	static boolean[] visited;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		score = new int[N][N];
		visited = new boolean[N];
		
		// 능력치 배열
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		comb(0, 0);
		System.out.println(Min);
 
	}
 
	// 백트래킹
	static void comb(int idx, int count) {

		if(count == N / 2) {
			
			// 팀에 속한 모든 쌍의 능력치 합
			int start_team = 0;
			int link_team = 0;
	 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] == true && visited[j] == true) {
						start_team += score[i][j] + score[j][i];
					}
					else if (visited[i] == false && visited[j] == false) {
						link_team += score[i][j] + score[j][i];
					}
				}
			}
			// 팀의 능력치의 차이의 최솟값
			Min = Math.min(Min, Math.abs(start_team - link_team));
			return;
		}
 
		for(int i = idx; i < N; i++) {

			if(!visited[i]) {
				visited[i] = true;	
				comb(i + 1, count + 1);	
				visited[i] = false;	
			}
		}
	}
 
}
