package s08.s0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Miro {
	
	static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visit;
    static int[][] map;
    static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 10개의 테스트 케이스
		for(int i=1;i<=10;i++) {
			int N = Integer.parseInt(br.readLine());
			int sxidx=0;
			int syidx=0;
			result=0;
			map = new int[100][100];
			visit = new boolean[100][100];
			for(int r=0;r<100;r++) {
                String str = br.readLine();
                for(int c=0;c<100;c++) {
                    map[r][c]=str.charAt(c)-'0';
                    if(map[r][c]==2) {
                    	sxidx = r; 
                    	syidx = c;
                    }
                }
            }
			dfs(sxidx,syidx);
			
			sb.append("#").append(i).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);

	}
	public static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (x < 0 || y < 0 || x >= 100 || y >= 100 || visit[x][y] || map[x][y]==1) continue;
			
            if(map[x][y]==3) {
            	result=1;
            	break;
            }
            visit[x][y]=true;
        	dfs(x,y);
        	visit[x][y]=false;
            
            	
            
		}
	}

}
