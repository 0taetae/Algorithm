package s10.s1022;

import java.io.*;
import java.util.*;

public class BOJ_18430 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int res=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		back(0, 0,0);
		System.out.println(res);

	}

	public static void back(int r, int c,int sum) {
		if (r == N) {
            res = Math.max(res, sum);
            return;
        }
        if (c == M) {
            back(r + 1, 0, sum);
            return;
        }
        // (r,c)를 방문하지 않은 경우 
        if (!visited[r][c]) {
            for (int i = 1; i <= 4; i++) {
                // 부메랑을 만들 수 있는 경우 
                if (check(r, c, i)) {
                	int cur = select(r, c, i);  // 방문 처리
                    back(r, c + 1, sum + cur);
                    reset(r, c, i);  // 원상복구 
                }
            }
        }
        // (r,c)를 방문한 경우 다음칸으로 
        back(r, c + 1, sum);
	}

	private static boolean check(int r, int c, int shape) {
		if(shape==1) {  // ㄱ
			if(r<0||c<0||r+1>=N||c+1>=M) return false;
			if(!visited[r][c] && !visited[r][c+1] && !visited[r+1][c+1]) return true;
		}else if(shape==2) {  // _|
			if(r<0||c-1<0||r+1>=N||c>=M) return false;
			if(!visited[r][c] && !visited[r+1][c-1] && !visited[r+1][c]) return true;
		}else if(shape==3) {   // ㄴ
			if(r<0 ||c<0|| r+1>=N || c+1>=M) return false;
			if(!visited[r][c] && !visited[r+1][c] && !visited[r+1][c+1]) return true;
		}else if(shape==4) {
			if(r<0||c<0 ||r+1>=N || c+1>=M) return false;
			if(!visited[r][c] && !visited[r][c+1] && !visited[r+1][c]) return true;
		}

		return false;
	}

	private static int select(int r, int c, int shape) {
		if(shape==1) {  // ㄱ
			visited[r][c]=true;
			visited[r][c+1] = true;
			visited[r+1][c+1] = true;
			return map[r][c] + map[r][c+1]*2 + map[r+1][c+1];
			
		}else if(shape==2) {  // _|
			visited[r][c]=true;
			visited[r+1][c-1]=true;
			visited[r+1][c] = true;
			return map[r][c] + map[r+1][c-1] + map[r+1][c]*2;
		}else if(shape==3) {   // ㄴ
			visited[r][c] = true;
			visited[r+1][c] =true;
			visited[r+1][c+1] = true;
			
			return map[r][c] + map[r+1][c]*2 + map[r+1][c+1] ;
		}else if(shape==4) {
			visited[r][c] = true;
			visited[r][c+1] = true;
			visited[r+1][c] = true;
			
			return map[r][c]*2 + map[r][c+1] + map[r+1][c];
		}
		return 0;
	}

	private static void reset(int r, int c, int shape) {
		if(shape==1) {  // ㄱ
			visited[r][c]=false;
			visited[r][c+1] = false;
			visited[r+1][c+1] = false;
			
		}else if(shape==2) {  // _|
			visited[r][c]=false;
			visited[r+1][c-1]=false;
			visited[r+1][c] = false;
		}else if(shape==3) {   // ㄴ
			visited[r][c] = false;
			visited[r+1][c] =false;
			visited[r+1][c+1] = false;
			
		}else if(shape==4) {
			visited[r][c] = false;
			visited[r][c+1] = false;
			visited[r+1][c] = false;
			
		}
	}

}
