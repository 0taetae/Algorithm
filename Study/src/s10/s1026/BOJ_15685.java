package s10.s1026;

import java.io.*;
import java.util.*;

public class BOJ_15685 {
	
	// 다음 드래곤 커브는 이전 드래곤 커브를 역순으로 가면서 방향을 찾는다
	// ex dir==0이었으면 dir==1
	// dir==1이었으면 dir==2
	
	static int N;
	static boolean[][] visited = new boolean[101][101];
	
	// 우, 상, 좌, 하
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());  // 시작점
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());  // 시작 방향
			int g = Integer.parseInt(st.nextToken());  // 세대
			dragon(x, y, d, g);
		}
		System.out.println(check());
		
	}
	
	public static void dragon(int x, int y, int d, int g) {
		ArrayList<Integer> dragonList = new ArrayList<>();
		dragonList.add(d);
        visited[y][x] = true;

        x += dx[d];
        y += dy[d];
        visited[y][x] = true;

        for (int i = 0; i < g; i++) {
            for (int j = dragonList.size() - 1; j >= 0; j--) {
                int newDir = (dragonList.get(j) + 1) % 4;
                x += dx[newDir];
                y += dy[newDir];
                visited[y][x] = true;
                dragonList.add(newDir);
            }
        }
	}
	
	// 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수 구하기
	public static int check() {
		int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
	}

}
