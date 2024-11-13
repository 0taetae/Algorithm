package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_1248 {
	
	static int V,E,a,b;
	static ArrayList<Integer>[] list,down;
	static int res1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());  // 정점 개수
			E = Integer.parseInt(st.nextToken());  // 간선 개수 
			a = Integer.parseInt(st.nextToken());  // 공통 조상 찾는 정점 번호
			b = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<>();  // i번의 부모들 
			}
			
			down= new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				down[i] = new ArrayList<>();  // i번의 자식들 
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				list[child].add(parent);
				down[parent].add(child);
			}
			res1=0;
			find();
			
			
			Queue<Integer> qq = new LinkedList<>();
			qq.add(res1);
			int cnt=1;
			while(!qq.isEmpty()) {
				int cur = qq.poll();
				for(int i=0;i<down[cur].size();i++) {
					int temp = down[cur].get(i);
					qq.add(temp);
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		
		
		
	}
	public static void find() {
		Queue<Integer> q1 = new LinkedList<>();
		ArrayList<Integer> parents = new ArrayList<>();
		q1.add(a);
		
		while(!q1.isEmpty()) {
			int cur = q1.poll();
			
			for(int i=0;i<list[cur].size();i++) {
				int temp = list[cur].get(i);
				
				q1.add(temp);
				parents.add(temp);
			}
		}
		
//		for(int i=0;i<parents.size();i++) {
//			System.out.println(parents.get(i));
//		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(b);
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i=0;i<list[current].size();i++) {
				int temp = list[current].get(i);
				
				if(parents.contains(temp)) {
					res1 = temp;
					return;
				}
				q.add(temp);
				
				
			}
		}
		
	}

}
