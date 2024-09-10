package s09.s0910;

import java.io.*;
import java.util.*;

public class BOJ_17219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String value = st.nextToken();
			map.put(key, value);
		}
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			System.out.println(map.get(find));
		}
	}

}
