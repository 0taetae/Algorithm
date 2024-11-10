package s11.s1110;

import java.io.*;
import java.util.*;

public class SWEA_1248 {
	
	static int V,E,a,b;
	static int[] parent;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());  // 정점 개수
			E = Integer.parseInt(st.nextToken());  // 간선 개수 
			
			// 공통 조상을 찾는 두 개의 정점 번호 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			// 자식 번호를 저장하는 2차원 리스트  
			list = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			// 부모 번호를 저장하는 배열 
			parent = new int[V+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int p = Integer.parseInt(st.nextToken());  // 부모
				int c = Integer.parseInt(st.nextToken());  // 자식 
				parent[c] = p;
				list[p].add(c);
			}
			
			int root = find(a,b);
			
			int res = cal(root);
			
			System.out.println("#"+tc+" "+root +" "+res);
		}
		

	}
	// 가장 가까운 공통 조상의 번호 찾기 
	public static int find(int one, int two) {
		visited = new boolean[V+1];
		
		while(one !=0 ) {
			visited[one] = true;
			one = parent[one];
		}
		while(two != 0) {
			if(visited[two]) {
				return two;
			}
			two = parent[two];
		}
		return 1;
		
	}
	
	// 가장 가까운 공통 조상을 루트로 하는 서브 트리 크기 
	public static int cal(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int sum=1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<list[cur].size();i++) {
				q.add(list[cur].get(i));
				sum++;
			}
		}
		
		return sum;
	}
	
}
