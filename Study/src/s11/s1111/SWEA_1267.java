package s11.s1111;

import java.io.*;
import java.util.*;

public class SWEA_1267 {
	
	static int V,E;
	static int[] dep, cnt;
	static ArrayList<Integer>[] list;
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			dep = new int[V+1];
			cnt = new int[V+1];  // 몇번째로 작업을 할 수 있는지
			list = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[p].add(c);  // 부모의 리스트에 자식노드를 넣기 
				dep[c]++;  // dep배열 증가 -> 해당 자식 노드의 부모 노드 개수 증가 
			}
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=V;i++) {
				// 선행 작업을 큐에 담기 
				if(dep[i]==0) {
					q.add(i);
					cnt[i] = 1;  // 선행 작업은 첫번째로 
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				// 해당 노드의 자식 노드들 탐색 
				for(int j=0;j<list[cur].size();j++) {
					int temp = list[cur].get(j);
					dep[temp] --;
					// 모든 부모 노드를 탐색한 자식 노드를 큐에 담기 
					if(dep[temp]==0) {
						q.add(temp);
						cnt[temp] = cnt[cur]+1;
					}
				}
			}
			
			// 순서가 이른 것부터 
			System.out.print("#"+tc+" ");
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(cnt[j]==i) {
						System.out.print(j+" ");
					}
				}
			}
			System.out.println();
		}
		

	}

}
