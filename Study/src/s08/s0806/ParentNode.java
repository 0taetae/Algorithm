package s08.s0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ParentNode {
	static boolean visit[];
	static ArrayList[] list;
	static int result[];
	static int target;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit =new boolean[N+1];
		
		// 해당 노드(인덱스)의 부모노드 배열
		result = new int[N+1];
		
		// 2차원 ArrayList 생성
		list = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		// 트리의 루트인 1부터 시작
		DFS(1);
		for(int i=2;i<=N;i++) {
			System.out.println(result[i]);
		}

	}
	public static void DFS(int start) {
		for(int i=0;i<list[start].size();i++) {
			// 부모노드의 자식 찾기
			target = (int) list[start].get(i);
			// 방문하지 않은 자식 노드
			if(!visit[target]) {
				visit[start] = true;
				visit[target]=true;
				// start는 부모노드, target은 자식노드
				result[target] = start;
				// 해당 자식 노드가 부모노드가 되어 자식 노드 찾기
				DFS(target);  
			}
			
		}
	}

}
