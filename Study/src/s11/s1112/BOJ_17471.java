package s11.s1112;

import java.io.*;
import java.util.*;

public class BOJ_17471 {
	
	// 두 선거구에 포함된 인구의 차이 최소
	// 구역의 인구 수>=1 => 각 선거구에 한개 이상의 구역이 있어야 함
	
	static int N;
	static int[] pop;
	static ArrayList<Integer>[] adjList ;
	static boolean[] selected;
	static ArrayList<Integer> aList;
	static ArrayList<Integer> bList;
	static int total=0 ; // 총 인구 수
	static int res=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		// 각 구역의 인구 수 
		pop = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			total+=pop[i];
		}
		
		// 2차원 리스트 (인접리스트)
		adjList = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				int adj = Integer.parseInt(st.nextToken());
				adjList[i].add(adj);
				adjList[adj].add(i);
			}
		}
		
		selected = new boolean[N+1];
		subset(1);
		
		if(res==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		

	}
	public static void subset(int cnt) {
		if(cnt==N+1) {
			aList = new ArrayList<>();
			bList = new ArrayList<>();
			int sumA=0;
			for(int i=1;i<=N;i++) {
				if(selected[i]) {
					aList.add(i);
					sumA+=pop[i];
				}else {
					bList.add(i);
				}
			}
			if(aList.size()>0 && bList.size()>0 && check(aList) && check(bList)) {
				res = Math.min(res, Math.abs((total-sumA)-sumA));
			}
			return;
		}
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);
		
	}
	public static boolean check(ArrayList<Integer> target) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited =new boolean[N+1];
		q.add(target.get(0));
		visited[target.get(0)] = true;
		int cnt=1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0;i<adjList[cur].size();i++) {
				int temp = adjList[cur].get(i);
				if(!visited[temp] && target.contains(temp)) {
					visited[temp] = true;
					cnt++;
					q.add(temp);
				}
			}
			
			
		}
		if(cnt==target.size()) {
			return true;
		}
		return false;
	}

}
