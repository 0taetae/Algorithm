package s09.s0917;

import java.io.*;
import java.util.*;

public class BOJ_1253 {
	
	static int N;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 수의 개수
		
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(num);
		
		int res=0;
		for(int i=0;i<N;i++) {
			if(isGood(i)) {  // 좋은 수 인지 확인 
				res++;
			}
		}
		System.out.println(res);
	}
	static boolean isGood(int target) {
		int left = 0;
		int right = N-1;
		while(left < right) {
			
			// target과 같은 수인 경우 
			if(left == target) {
				left++;
				continue;
			}
			if(right==target) {
				right--;
				continue;
			}
			
			int sum = num[left] + num[right];
			
			if(sum == num[target]) {
				return true;
			}else if(sum < num[target]) {
				left++;
			}else {
				right--;
			}
		}
		return false;
	}

}
