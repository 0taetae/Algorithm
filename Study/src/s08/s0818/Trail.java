package s08.s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trail {
	
	static int N;
	static int K;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visit = new boolean[N][N];
    
    static int maxLength;
    static int maxHeight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visit = new boolean[N][N];
            maxLength = 0;
            maxHeight = 0;
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    // 가장 높은 봉우리 찾기 
                    maxHeight = Math.max(map[r][c], maxHeight);
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                	// 가장 높은 봉우리에서 시작 
                    if (map[r][c] == maxHeight) {
                        visit[r][c] = true;
                        dfs(r, c, maxHeight, 1, 1);
                        visit[r][c] = false;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(maxLength).append("\n");
            
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, int height, int length, int count) {

    	// 가장 긴 등산로 찾기 
    	maxLength = Math.max(maxLength, length);

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (x < 0 || y < 0 || x >= N || y >= N || visit[x][y]) continue;
            
            // 현재 높이보다 더 높은 높이일 경우 
            if (height <= map[x][y]) {
            	// 깎은적 없고, 깎을 수 있는 최대 높이만큼 깎았을 때 현재 높이보다 낮아지는 경우 
                if (count == 1 && map[x][y] - K < height) {
                    int change=0;
                    // 가장 긴 등산로를 구하기 위해, 조금씩 깎기 
                    for(int j = 1; j<=K; j++){
                        if(map[x][y] - j < height) {
                            change = map[x][y] - j;
                            break;
                        }
                    }
                    visit[x][y] = true;
                    dfs(x, y,  change, length + 1, count - 1);
                    visit[x][y] = false;
                }
            }
            // 깎을 필요 없는 경우 
            else {
            	visit[x][y] = true;
                dfs(x, y, map[x][y], length + 1, count);
                visit[x][y] = false;
            }
        }
    }

}
