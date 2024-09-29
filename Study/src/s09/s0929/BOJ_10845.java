package s09.s0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		int lastnum = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				lastnum = num;
				q.add(num);
				break;
			case "pop":
				if(!q.isEmpty()) {
					int popNum = q.poll();
					System.out.println(popNum);
				}else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				if(!q.isEmpty()) {
					System.out.println(q.peek());
				}else {
					System.out.println(-1);
				}
				break;
			case "back":
				if(!q.isEmpty()) {
					System.out.println(lastnum);
				}else {
					System.out.println(-1);
				}
				break;
			}
		}
		
	}

}
