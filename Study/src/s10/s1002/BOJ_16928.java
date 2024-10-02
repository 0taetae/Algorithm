package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_16928 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int res;
	static class Info{
		int num,cnt;
		Info(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	static Map<Integer, Integer> ladder = new HashMap<>();
	static Map<Integer, Integer> snake = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[11][11];
		visited = new boolean[101][7];
		
		// map에 숫자 채우기
		for(int i=1;i<=10;i++) {
			// 홀수번째는 증가
			if(i%2==1) {
				for(int j=1;j<=10;j++) {
					map[i][j] = (i-1)*10+j;
				}
			}
			// 짝수번째는 감소
			if(i%2==0) {
				for(int j=1;j<=10;j++) {
					map[i][j] = (i-1)*10+(11-j);
				}
			}
			
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 사다리의 수
		M = Integer.parseInt(st.nextToken());  // 뱀의 수
		
		
		// 사다리 정보
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int startlad = Integer.parseInt(st.nextToken());
			int endlad = Integer.parseInt(st.nextToken());
			ladder.put(startlad, endlad);
		}
		// 뱀 정보
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int startsn = Integer.parseInt(st.nextToken());
			int endsn = Integer.parseInt(st.nextToken());
			snake.put(startsn, endsn);
		}
		res = Integer.MAX_VALUE;
		bfs(1);
		System.out.println(res);

	}
	public static void bfs(int num) {
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(1,0));
		visited[1][0] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int i=1;i<=6;i++) {
				int next = cur.num +i;
				
				if(cur.num+i>=100) {
					res = Math.min(res, cur.cnt+1);
					return;
				}
				if(visited[next][i]) continue;
				
				for(Integer key: ladder.keySet()) {
					if(next==key) {
						q.add(new Info(ladder.get(next), cur.cnt+1));
						visited[next][i] = true;
						continue;
					}
				}
				for(Integer key: snake.keySet()) {
					if(next==key) {
						q.add(new Info(snake.get(next), cur.cnt+1));
						visited[next][i] = true;
						continue;
					}
				}
				q.add(new Info(next, cur.cnt+1));
				visited[next][i] = true;
			}
		}
	}

}
