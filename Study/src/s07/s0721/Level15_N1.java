package s07.s0721;

import java.io.*;
import java.util.*;

public class Level15_N1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int gcd = GCD(A,B);
			System.out.println(A*B/gcd);
		}

	}
	public static int GCD(int A, int B) {
		if(A>B) {
			if(A%B == 0) return B;
			return GCD(B,A%B);
		}
		else {
			if(B%A == 0) return A;
			return GCD(A,B%A);
		}
	}

}
