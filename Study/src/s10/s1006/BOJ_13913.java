package s10.s1006;

import java.io.*;
import java.util.*;

public class BOJ_13913 {
	
	static int N,K;
	static Queue<Integer> q;
	static int[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
			System.out.println(N);
		}else {
			visited = new int[100001];
			Arrays.fill(visited, -1);
			bfs();
			int num = K;
			ArrayList<Integer> res = new ArrayList<>();
			res.add(num);
			int cur = 0;
			int pre  = 0;
			while(true) {
				cur = num;
				//System.out.println("cur "+cur);
				pre = visited[cur];
				//System.out.println("pre "+pre);
				res.add(pre);
				if(pre==N) {
					break;
				}
				num = pre;
			}
			System.out.println(res.size()-1);
			for(int i=res.size()-1;i>=0;i--) {
				System.out.print(res.get(i)+" ");
			}
		}
		
		

	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(N>K) {
				int next = cur - 1;
				if(visited[next]==-1) {
					q.add(next);
					visited[next] = cur;
					if(next == K) {
						return;
					}
				}
			} else {
				int next = cur - 1;
				if(next <=100000 && next>=0 && visited[next]==-1) {
					q.add(next);
					visited[next] = cur;
					if(next == K) {
						return;
					}
				}
				
				int next2 = cur+1;
				if(next2 <= 100000 && visited[next2] == -1) {
					q.add(next2);
					visited[next2] = cur;
					if(next2 == K) {
						return;
					}
				}
				
				int next3 = cur *2;
				if(next3 <= 100000 && visited[next3]==-1) {
					q.add(next3);
					visited[next3] = cur;
					if(next3 == K) {
						return;
					}
				}
				
			}
			
		}
		return;
		
	}

}
