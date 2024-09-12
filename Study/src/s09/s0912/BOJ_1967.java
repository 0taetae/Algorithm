package s09.s0912;

import java.io.*;
import java.util.*;

public class BOJ_1967 {
	
	static int N;
	static ArrayList<ArrayList<Info>> adj = new ArrayList<>();
	static boolean[] visited;
	static int nextStart;
	static int maxWeight;
	
	static class Info{
		int node;
		int weight;
		Info(int node, int weight){
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // N���� ��� 
		StringTokenizer st;
		
		// 2���� ���� ����Ʈ ����
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<Info>());
		}
		
		for(int i=1;i<=N-1;i++) {  // N-1���� ����
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // �θ� ��� ��ȣ
			int b = Integer.parseInt(st.nextToken());  // �ڽ� ��� ��ȣ
			int w = Integer.parseInt(st.nextToken());  // ������ ����ġ
			adj.get(a).add(new Info(b,w));
			adj.get(b).add(new Info(a,w));
		}
		
		// �ƹ� ��忡�� ���� ����ġ�� ���� ū ��쿡 ���� �ִ� ��� ���ϱ� -> ���Ƿ� 1�� ���� 
		visited = new boolean[N+1];
		visited[1] = true;
		nextStart=0;
		maxWeight=0;
		dfs(1,0);
		
		// ������ ���� ��忡�� �����Ͽ� ���� ����ġ�� ���� ū ��쿡 ���� �ִ� ��� ���ϱ� 
		visited = new boolean[N+1];
		visited[nextStart] = true;
		maxWeight=0;
		dfs(nextStart,0);
		
		// ������ ���� �� ��� ������ ����ġ�� ���� Ʈ���� ���� 
		System.out.println(maxWeight);
		
	}
	public static void dfs(int start,int weight) {
		for(int i=0;i<adj.get(start).size();i++) {
			Info target = adj.get(start).get(i);
			if(!visited[target.node]) {
				visited[target.node] = true;
				dfs(target.node, weight+target.weight);
				if(maxWeight < weight+target.weight) {
					nextStart = target.node;
					maxWeight = weight+target.weight;
				}
			}
		}
	}
}
