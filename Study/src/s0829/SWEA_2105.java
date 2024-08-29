package s0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105 {
	
	// 시계방향 탐색 
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int[] select;
	//static ArrayList<Integer> selectList;
	static int startX;
	static int startY;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=1;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[101];
			
			
			//selectList = new ArrayList<>();
			
			for(int r=0;r<N;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res =0;
			for(int r=1;r<N-1;r++) {
				for(int c=1;c<N-1;c++) {
					select = new int[100];
					startX = r;
					startY = c;
					eat(r, c, 0, visited, 0,select);
				}
			}
			if(res==0) {
				System.out.println("#"+i+ " "+(-1));
			}else {
				System.out.println("#"+i+ " "+res);
			}
			
		}
	}
	
	public static boolean eat(int r, int c, int dir, boolean[] visited, int cnt, int[] select) {
		// 대각선 탐색
		//visited[r][c] = true;
		System.out.println(r+" "+c);
		if(r<0 || c<0 || r>=N || c>=N) {
			System.out.println("범위벗어남");
			return false;  // 배열 범위 벗어나면 리턴
		}
		
		if(dir > 3) {
			System.out.println("시작위치로 안돌아옴");
			return false;
		}
		select[cnt] = arr[r][c];
		if(r == startX && c == startY && dir == 3) {
			System.out.println("시작위치로 돌아옴 - 성공");
			dessertSum();
			return true;  // 시작위치로 돌아오면 리턴
		}
		
		
		int x = r + dx[dir];
		int y = c + dy[dir];
		
		visited[arr[x][y]] = true;
		eat(x,y,dir, visited, cnt+1, select);
		visited[arr[x][y]] = false;
		eat(x,y,dir+1,visited, cnt+1, select);
		
		return false;
	}
	public static void dessertSum() {
		int sum =0;
		for(int i=1;i<=100;i++) {
			if(visited[i]) {
				sum += i;
			}
		}
	}

}
