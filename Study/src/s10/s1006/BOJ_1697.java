package s10.s1006;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
	
	static class Info{
		int num;
		int cnt;
		Info(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	static int N,K;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
		}else {
			System.out.println(bfs(N));
		}
		
		

	}
	public static int bfs(int num) {
		Queue<Info> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.add(new Info(num,0));
		visited[num] = true;
		while(!q.isEmpty()) {
			Info cur = q.poll();
			//System.out.println("cur "+cur.num+" "+cur.cnt);
			if(N>K) {
				int nNum = cur.num-1;
				if(nNum==K) {
					return cur.cnt+1;
				}
				//System.out.println("nNum "+nNum);
				if(!visited[nNum]) {
					visited[nNum] = true;
					q.add(new Info(nNum, cur.cnt+1));
				}
			}
			
			else {
				int nNum2 = cur.num+1;
				if(nNum2==K) {
					return cur.cnt+1;
				}
				//System.out.println("nNum2 "+nNum2);
				if(nNum2 <=100000  && !visited[nNum2]) {
					visited[nNum2] = true;
					q.add(new Info(nNum2, cur.cnt+1));
				}
				
				int nNum3 = cur.num*2;
				if(nNum3==K) {
					return cur.cnt+1;
				}
				//System.out.println("nNum3 "+nNum3);
				if(nNum3 <=100000  && !visited[nNum3]) {
					visited[nNum3] = true;
					q.add(new Info(nNum3, cur.cnt+1));
				}
				
				
				if(cur.num >0) {
					int nNum = cur.num-1;
					if(nNum==K) {
						return cur.cnt+1;
					}
					//System.out.println("nNum "+nNum);
					if(nNum <=100000  && !visited[nNum]) {
						visited[nNum] = true;
						q.add(new Info(nNum, cur.cnt+1));
					}
					
				}
			}
			
		}
		return 0;
	}

}
