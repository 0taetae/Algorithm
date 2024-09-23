package s09.s0923;

import java.io.*;
import java.util.*;

public class BOJ_1327 {
	
	static int N,M;
	static List<Integer> nums, copynums;
	static int res=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 자리수
		M = Integer.parseInt(st.nextToken());  // 뒤집을 숫자 개수 
		nums = new ArrayList<Integer>();
		copynums = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			nums.add(num) ;
			copynums.add(num);
			//System.out.println(nums.get(i));
		}
		for(int i=0;i<=N-M;i++) {
			if(nums.get(i)>nums.get(i+1)) {
				System.out.println(i+" 여기서 정렬");
				sort(i,1);
			}
			nums = copynums;
		}
		if(res == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(res);
		}
		

	}
	static void sort(int start,int cnt) {
		
		if(cnt >=res) {
			return;
		}
		Collections.reverse(nums.subList(start, start+M));  // 뒤집기
		for(int i=0;i<N;i++) {
			System.out.print(nums.get(i)+" ");
		}
		System.out.println();
		if(check()) {
			System.out.println("정렬 완료");
			res = Math.min(res, cnt);
			return;
		}
		for(int i=0;i<=N-M;i++) {
			if(nums.get(i)>nums.get(i+1)) {
				sort(i,cnt+1);
			}
		}
		
	}
	static boolean check() {
		for(int i=0;i<N-1;i++) {
			if(nums.get(i)>nums.get(i+1)) {
				return false;
			}
		}
		return true;
	}

}
