package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_1267 {
	
	static int V,E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int[] res = new int[V+1];  // 부모 표시 
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer>[] child = new ArrayList[V+1];
			ArrayList<Integer>[] parent = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {  // 자식들 담기
				child[i] = new ArrayList<>();
				parent[i] = new ArrayList<>();
			}
			for(int i=0;i<E;i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				//parent[c] = p;
				child[p].add(c);
				parent[c].add(p);
			}
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=V;i++) {
				if(parent[i].size()==0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int i=0;i<child[cur].size();i++) {
					int temp = child[cur].get(i);
					q.add(temp);
					res[temp] = res[cur]+1;
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(res[j]==i) {
						sb.append(j).append(" ");
					}
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}

}
