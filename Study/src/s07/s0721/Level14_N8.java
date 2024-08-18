package s07.s0721;

import java.io.*;
import java.util.*;

public class Level14_N8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<=len;i++) {
			for(int j=i+1;j<=len;j++) {
				set.add(str.substring(i,j));
			}
		}
		System.out.println(set.size());

	}

}
