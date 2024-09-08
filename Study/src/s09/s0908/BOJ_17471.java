package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_17471 {
	/*
	각 구역을 두 개의 선거구로 나눔
	각 구역은 두 선거구 중 하나에 포함되어야 함
	 */
	static int N;
	static int[] cnt;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> select ;
	static ArrayList<Integer> nselect ;
	static int cntTotal,res;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  // 구역의 개수
		cnt = new int[N+1];  // 각 구역의 인구 수
		st = new StringTokenizer(br.readLine());
		cntTotal=0;  // 총 인구수 
		res = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			cntTotal+=cnt[i];
		}
		// 2차원 인접행렬 생성
		adj = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int K = Integer.parseInt(st.nextToken());
				adj[i].add(K);
				adj[K].add(i);
			}
		}
		
		isSelected = new boolean[N+1];
		subSet(1);
		if(res==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
	
	// 선거구 나누는 부분집합 (선택된 구역은 A선거구, 나머지는 B 선서구)
	static void subSet(int count) {
		if(count==N+1) {
			select = new ArrayList<Integer>();
			nselect = new ArrayList<Integer>();
			for(int i=1;i<=N;i++) {
				if(isSelected[i]) {
					select.add(i);
				}else {
					nselect.add(i);
				}
			}
			//System.out.println();
			if(select.size()!=0 && nselect.size()!=0 && check(select)&&check(nselect)) {
				cal();
			}
			return;
		}
		isSelected[count] = true;
		subSet(count+1);
		isSelected[count] = false;
		subSet(count+1);
	}
	
	// 선거구의 구역 중에 적어도 하나 인접한지 확인
	static boolean check(ArrayList<Integer> select) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[select.get(0)] = true;
		q.offer(select.get(0));
		int cnt = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<adj[cur].size();i++) {
				int temp = adj[cur].get(i);
				if(select.contains(temp) && !visited[temp]) {
					q.offer(temp);
					visited[temp] = true;
					cnt++;
				}
				
			}
		}
		if(cnt==select.size()) {
			return true;
		}else {
			return false;
		}
	}
	static void cal() {
		int sum=0;
		for(int i=0;i<select.size();i++) {
			sum+=cnt[select.get(i)];
		}
		res = Math.min(res, Math.abs(cntTotal-sum*2));
	}
	

}
