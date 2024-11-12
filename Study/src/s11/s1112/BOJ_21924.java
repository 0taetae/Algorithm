package s11.s1112;

import java.io.*;
import java.util.*;

public class BOJ_21924 {
	static int N,M;
	static class Info{
		int a,b,cost;
		Info(int a, int b, int cost){
			this.a = a;
			this.b =b;
			this.cost = cost;
		}
	}
	static ArrayList<Info> list = new ArrayList<>();
	static int[] parent;
	static void make() {
		parent = new int[N+1];
		Arrays.fill(parent, -1);
	}
	static int findset(int a) {
		if(parent[a]<0) return a;
		return parent[a] = findset(parent[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot == bRoot) return false;
		
		parent[aRoot]+=parent[bRoot];
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 건물 개수
		M = Integer.parseInt(st.nextToken());  // 도로 개수
		long total = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Info(a,b,cost));
			total+=cost;
		}
		Collections.sort(list,(o1,o2)-> (o1.cost - o2.cost));
		
		
		make();
		long res = 0;
		int cnt = 0;
		for(Info cur:list) {
			if(union(cur.a,cur.b)) {
				res+=cur.cost;
				cnt++;
			}
		}
		if(cnt==N-1) {
			System.out.println(total-res);
		}else {
			System.out.println(-1);
		}
		

	}

}
