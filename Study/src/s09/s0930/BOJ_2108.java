package s09.s0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_2108 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		int sum=0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			list.add(num);
			set.add(num);
			sum+=num;
		}
		int[] cnt = new int[set.size()];
		Collections.sort(list);
		Integer[] arr = set.toArray(new Integer[0]);
		for(int i=0;i<N;i++) {
			for(int j=0;j<arr.length;j++) {
				if(list.get(i)==arr[j]) {
					cnt[j]++;
				}
			}
		}
		
		System.out.println(sum/N);
		System.out.println(list.get(N/2));
		System.out.println();
		System.out.println(list.get(N-1) - list.get(0));

	}

}
