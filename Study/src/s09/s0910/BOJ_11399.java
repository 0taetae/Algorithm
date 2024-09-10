package s09.s0910;

import java.io.*;
import java.util.*;

public class BOJ_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum+= arr[i];
			res +=sum;
		}
		System.out.println(res);

	}

}
