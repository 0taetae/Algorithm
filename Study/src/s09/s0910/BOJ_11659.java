package s09.s0910;

import java.io.*;
import java.util.*;

public class BOJ_11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1]+num;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int sum = arr[b] - arr[a-1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}

}
