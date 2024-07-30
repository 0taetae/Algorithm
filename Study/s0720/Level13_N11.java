package s0720;

import java.util.*;
import java.io.*;


public class Level13_N11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] check = arr.clone();  // 입력받은 배열 복사 
		
		Arrays.sort(check);
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int idx = 0;
		
		for(int i=0;i<N;i++) {
			if(!hm.containsKey(check[i])) {
				hm.put(check[i], idx++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i: arr) {
			sb.append(hm.get(i)).append(' ');
		}
		System.out.println(sb);
	}

}
