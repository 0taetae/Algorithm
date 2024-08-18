package s07.s0721;

import java.io.*;
import java.util.*;

public class Level15_N2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		long gcd = GCD(A,B);
		if(gcd==1) {
			System.out.println(A*B);
		}
		else {
			System.out.println(A*B/gcd);
		}
		
		
	}
	public static int GCD(long A, long B) {
		if(A>B) {
			if(A%B == 0) return (int) B;
			return GCD(B,A%B);
		}
		else {
			if(B%A == 0) return (int) A;
			return GCD(A,B%A);
		}

	}

}
