package s09.s0920;

import java.io.*;
import java.util.*;

public class BOJ_8958 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			int cnt = 0;
			int sum = 0;
			
			for (int j = 0; j < str.length(); j++) {
				
				if (str.charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}
