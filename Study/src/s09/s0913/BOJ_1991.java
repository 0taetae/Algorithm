package s09.s0913;

import java.io.*;
import java.util.*;

public class BOJ_1991 {
	
	static ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();  // 자식노드 저장 
	static ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();  // 부모노드 저장 
	//static int[][] adj;
	static ArrayList<Integer> child ;
	static ArrayList<Integer> lastLeaf = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//adj = new int[N][2];
		
		for(int i=0;i<N;i++) {
			adj1.add(new ArrayList<>());
		}
		for(int i=0;i<N;i++) {
			adj2.add(new ArrayList<>());
		}
		// 0: A, 1:B, 2:C, 3:D, 4:E, 5:F 6:G
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			//adj[i][0] = a.charAt(0)-'A';
			if(b.charAt(0) - 'A'>=0) {
				adj1.get(a.charAt(0)-'A').add(b.charAt(0) - 'A');
				adj2.get(b.charAt(0) - 'A').add(a.charAt(0)-'A');
			}
			if(c.charAt(0) - 'A'>=0) {
				adj1.get(a.charAt(0)-'A').add(c.charAt(0) - 'A');
				adj2.get(c.charAt(0) - 'A').add(a.charAt(0)-'A');
			}
			
			
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<adj2.get(i).size();j++) {
//				System.out.print(adj2.get(i).get(j));
//			}
//			System.out.println();
//		}
		
		//System.out.println("보자");
//		for(int i=0;i<N;i++) {
//			System.out.println(adj1.get(i).size());
//			
//		}
		
		// 전위 순회
		child = new ArrayList<>();
		visited = new boolean[N];
		dfs(0);
		for(int i=0;i<child.size();i++) {
			System.out.print((char) (child.get(i)+65));
		}
		System.out.println();
		//System.out.println("child : "+child.size());
//		for(int i=0;i<lastLeaf.size();i++) {
//			System.out.println(lastLeaf.get(i));
//		}
		
		// 중위 순회
		child = new ArrayList<>();
		visited = new boolean[N];
//		for(int i=0;i<lastLeaf.size();i++) {
//			dfs2(lastLeaf.get(i));
//		}
//		dfs2(lastLeaf.get(0));
//		dfs(0);
//		
//		for(int i=0;i<child.size();i++) {
//			System.out.print((char) (child.get(i)+65));
//		}
//		System.out.println();
		
	}
	static void dfs(int start) {
		visited[start] = true;
		child.add(start);  // 전위 순회 
//		if(adj1.get(start).size()==0) {
//			lastLeaf.add(start);
//		}
		for(int i=0;i<adj1.get(start).size();i++) {
			int temp = adj1.get(start).get(i);
			if(temp>0 && !visited[temp]) {
				dfs(temp);
			}
		}
	}
//	static void dfs2(int start) {
//		//System.out.println(start+"이 노드의 부모노드 찾기");
//		visited[start] = true;
//		child.add(start);  // 전위 순회 
//		for(int i=0;i<adj2.get(start).size();i++) {
//			int temp = adj2.get(start).get(i);
//			if(temp>=0 && !visited[temp]) {
//				//System.out.println("부모 노드 "+temp);
//				dfs2(temp);
//			}
//		}
//	}

}
