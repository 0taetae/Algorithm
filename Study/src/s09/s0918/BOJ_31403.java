package s09.s0918;

import java.io.*;
import java.util.*;

public class BOJ_31403 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int C = Integer.parseInt(br.readLine());
		int AB = Integer.parseInt(A+B);
		System.out.println(Integer.parseInt(A)+Integer.parseInt(B)-C);
		System.out.println(AB-C);

	}

}
