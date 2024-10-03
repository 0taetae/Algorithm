package s10.s1003;

import java.io.*;
import java.util.*;

public class BOJ_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 나무의 수
		int M = Integer.parseInt(st.nextToken());  // 집으로 가져가려고 하는 나무의 길이 
		int maxHeight = 0;
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, trees[i]);
		}
		int res = 0;
		int start = 1;
		int end = maxHeight;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			long sum = 0;
			for(int i=0;i<N;i++) {
				int temp = trees[i]-mid;
				if(temp>0) {
					sum+=temp;
				}
			}
			
			if(sum>=M) {
				res = Math.max(mid, res);
				start = mid +1;
			}
			if(sum<M) {
				end = mid - 1;
			}
		}
		System.out.println(res);

	}

}
