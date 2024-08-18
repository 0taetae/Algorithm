package s07.s0721;

import java.io.*;
import java.util.*;

public class Level14_N6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();  
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				result.add(str);
			} 
		}
		Collections.sort(result); 
		
		System.out.println(result.size());
		for(String str: result) {
			System.out.println(str);
		}

	}

}
