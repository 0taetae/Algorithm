package s09.s0914;

import java.io.*;
import java.util.*;

public class BOJ_1991 {
	
	static Info[] tree;
	
	static class Info{
		char num;
		Info left;
		Info right;
		
		Info(char num){
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new Info[N+1];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char leftchild = st.nextToken().charAt(0);
			char rightchild = st.nextToken().charAt(0);
			
			if (tree[parent - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우
                tree[parent - 'A'] = new Info(parent); // 부모 노드를 생성
            }
            if (leftchild != '.') { // 왼쪽 자식이 존재할 경우
                tree[leftchild - 'A'] = new Info(leftchild); // 왼쪽 자식 노드를 생성
                tree[parent - 'A'].left = tree[leftchild - 'A']; // 부모 노드와 연결
            }
            if (rightchild != '.') { // 오른쪽 자식이 존재할 경우
                tree[rightchild - 'A'] = new Info(rightchild); // 오른쪽 자식 노드를 생성
                tree[parent - 'A'].right = tree[rightchild - 'A']; // 부모 노드와 연결
            }
		}
		preorder(tree[0]);
		System.out.println();
		
		inorder(tree[0]);
		System.out.println();
		
		postorder(tree[0]);
		System.out.println();

	}
	
	// 전위순회
	public static void preorder(Info node) {
		if (node == null) return;
        System.out.print(node.num);
        preorder(node.left);
        preorder(node.right);
	}
	// 중위순회
	public static void inorder(Info node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.num);
        inorder(node.right);
    }
	// 후위순회 
	public static void postorder(Info node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.num);
    }

}
