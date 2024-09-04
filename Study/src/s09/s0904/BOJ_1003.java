package s09.s0904;

import java.io.*;
import java.util.*;

public class BOJ_1003 {
	
	static int[][] f;
	
	static void fibo(int n) {
		f[0][0] = 1;
		f[0][1] = 0;
		if(n==0) return;
		f[1][0] = 0;
		f[1][1] = 1;
		if(n==1) return;
		for(int i=2;i<=n;i++) {
			f[i][0] = f[i-1][0] + f[i-2][0];
			f[i][1] = f[i-1][1] + f[i-2][1];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			f = new int[N+1][2];
			fibo(N);
			System.out.println(f[N][0]+" "+f[N][1]);
		}
	}

}
