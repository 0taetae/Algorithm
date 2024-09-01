package s08.s0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandCount {
	
	static int[][] arr;
	static boolean[][] visit;
	static int w;
	static int h;
	
	static int[] dx = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 & h==0) {
				break;
			}
			arr = new int[h][w];
			visit = new boolean[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;  // 섬의 개수 
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]==1 & !visit[i][j]) {
						count++;
						dfs(i,j);
					}
					
				}
			}
			System.out.println(count);
		}

	}
	public static void dfs(int i, int j) {
		visit[i][j]=true;
		
		// 8방향 확인 
		for(int k=0;k<8;k++) {
			
			int x = i + dx[k];
			int y = j + dy[k];
			
			// 범위를 벗어나지 않도록 처리 
			if(x<0 || y<0 || x>=h || y>=w) {
				continue;
			}
			// 땅이고, 방문한적 없는 경우
			if(arr[x][y]==1 && !visit[x][y]) {
				dfs(x,y);
			}
		}
	}

}

