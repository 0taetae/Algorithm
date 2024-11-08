package s11.s1108;

import java.io.*;
import java.util.*;

public class BOJ_16398 {
	
	static int N;
	static int[] parent;
	static class Info implements Comparable<Info>{
		int start,end,weight;
		Info(int start, int end, int weight){
			this.start=start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info o) {
			return this.weight - o.weight;
		}
	}
	static void make() {
		parent = new int[N+1];
		Arrays.fill(parent, -1);
	}
	static int findSet(int a) {
		if(parent[a]<0) return a;
		
		return parent[a] = findSet(parent[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parent[aRoot] += parent[bRoot];
		parent[bRoot] = aRoot;
		return true;
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		Info[] edges = new Info[(N*N-N)/2];
		int idx = 0;
		for(int r=1;r<=N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(r<c) {
					edges[idx] = new Info(r,c,map[r][c]);
					idx++;
				}
			}
		}
		Arrays.sort(edges);
		make();
		long res = 0;
		int cnt=0;
		for(int i=0;i<(N*N-N)/2;i++) {
			if(union(edges[i].start,edges[i].end)) {
				res+=edges[i].weight;
				cnt++;
			}
			if(cnt==N-1) {
				break;
			}
		}
		System.out.println(res);
	}
}
