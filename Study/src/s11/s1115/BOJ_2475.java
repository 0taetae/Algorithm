package s11.s1115;

import java.io.*;
import java.util.*;

public class BOJ_2475 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		for(int i=0;i<5;i++) {
			int num = Integer.parseInt(st.nextToken());
			total += (num*num);
		}
		System.out.println(total%10);

	}

}
