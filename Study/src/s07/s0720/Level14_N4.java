package s07.s0720;

import java.io.*;
import java.util.*;

public class Level14_N4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, String> hash1 = new HashMap<Integer, String>();
		HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
		
		for(int i = 1; i <= N; i++) {
			String S = br.readLine();
			hash1.put(i, S);
			hash2.put(S, i);
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
				sb.append(hash1.get(Integer.parseInt(str))).append("\n");
			}else {
				sb.append(hash2.get(str)).append("\n");
			}
		}
		System.out.println(sb);

	}

}
