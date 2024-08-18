package s07.s0725;

import java.util.*;
import java.io.*;

public class AbsHeap {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int absA = Math.abs(a);
				int absB = Math.abs(b);
				
				if(absA > absB) {
					return absA - absB;
				}else if(absA == absB) {
					return a - b;
				}else {
					return absA - absB;
				}
			}
		});
		for(int i=0;i<N;i++) {
			int X = Integer.parseInt(br.readLine());
			if(X!=0) {
				pq.offer(X);
			}
			else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
		}
		
		
	}

}
	
