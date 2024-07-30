package s0721;

import java.io.*;
import java.util.*;

public class Level15_N3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st2.nextToken());
		int D = Integer.parseInt(st2.nextToken());
		
		int N = A*D+B*C;
		int M = B*D;
		
		int gcd = GCD(N,M);
		
		System.out.println(N/gcd+" "+M/gcd);
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
