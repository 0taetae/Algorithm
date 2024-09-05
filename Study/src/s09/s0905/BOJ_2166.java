package s09.s0905;

import java.io.*;
import java.util.*;

public class BOJ_2166 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [][] arr= new long[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Long.parseLong(st.nextToken());
			arr[i][1] = Long.parseLong(st.nextToken());
		}
		long sum=0;
		long x1 = arr[0][0];
		long y1 = arr[0][1];
		for(int i=1;i<N-1;i++) {
			long x2 = arr[i][0];
			long y2 = arr[i][1];
			long x3 = arr[i+1][0];
			long y3 = arr[i+1][1];
			sum += (x1*y2 + x2 * y3 + x3*y1) - (x2*y1+x3*y2+x1*y3);
		}
		System.out.printf("%.1f",(double)Math.abs(sum)/2);
		
		
	}

}
