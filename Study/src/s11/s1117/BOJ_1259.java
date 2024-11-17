package s11.s1117;

import java.io.*;
import java.util.*;

public class BOJ_1259 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			boolean isOk = true;
			if(str.equals("0")) {
				break;
			}
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);

	}

}
