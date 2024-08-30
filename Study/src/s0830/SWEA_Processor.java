package s0830;

import java.io.*;
import java.util.*;

public class SWEA_Processor {
	
	static int N;
	static int[][] arr;
	//static int[] dx = {-1, 1, 0, 0};
	//static int[] dy = {0, 0, 1,-1};
	static ArrayList<Info> lst;
	static int total;
	static boolean[] visited;
	
	//static boolean[][] state;
	
	static class Info{
		int r;
		int c;
		Info(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			// 가장 자리에는 전원이 흐르고 있음
			// 가장자리에 위치한 Core는 이미 전원이 연결된 것으로 간주
			// Core와 전원을 연결하는 전선은 직선으로만 설치 가능
			// 전선은 교차 안된다
			// 전원이 연결되지 않는 Core가 존재할 수 있음
			
			// 최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하기
			// 전선 길이의 합이 최소가 되는 값
			
			// 1은 core, 0은 빈 cell
			// 1개의 cell에는 1개의 Core 혹은 1개의 전선이 올 수 있음
			// Core의 개수는 1개 이상 12개 이하
			
			lst = new ArrayList<Info>();
			
			for(int r=1;r<=N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=1;c<=N;c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					// Core의 인덱스 정보 저장 
				}
			}
			total=0;
			
			boolean[][] state = new boolean[N][N];
			// visited, length, Core 개수
			// 가장자리에 있는 Core를 제외하고 Core 개수 구하기
			for(int r=1;r<N-1;r++) {
				for(int c=1;c<N-1;c++) {
					if(arr[r][c]==1) {
						total++;
						lst.add(new Info(r,c));
					}
				}
			}
			visited = new boolean[total];
			
			// 큰 개수부터 작아지면서 Core 뽑을 개수 구하기 
			for(int j=total;j>total;j--) {
				comb(0, j);
			}
			
			// 조합으로 큰 개수부터 작은 개수로 뽑아가기 연결할 수 있으면 그 개수로
			// 2차원 boolean 배열을 사용해서 전선을 연결된 경우, core가 있는위치로는 전원을 연결할 수없음을  나타내기
			// 백트래킹으로 뽑아낸 Core마다 안되면 돌아가서 다른 방향 보고 4방향 다 확인해보고 다음 Core로 넘어감
			
		}
	}
	public static void comb(int idx, int M) {
		if(idx == M) {
			for(int i=0;i<total;i++) {
				if(visited[i]) {
					check(lst.get(i).r, lst.get(i).c);
				}
			}
		}
		for(int i=0;i<total;i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(idx+1, M);
				visited[i] = false;
			}
		}
	}
	
	public static void check(int r, int c) {
		
		// 오른쪽 확인
		for(int i=c+1;i<N;i++) {
			if(arr[r][i] ==0) {
				continue;
			}
		}
		// 왼쪽 확인
		
		
		// 위쪽 확인
		
		// 아래쪽 확인 
		
		
		
		
		
	}
	

}
