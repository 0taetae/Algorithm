package s11.s1116;

import java.io.*;
import java.util.*;

public class BOJ_30802 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N =Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<6;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int res = 0;
		for(int i=0;i<6;i++) {
			if(arr[i]%T==0) {
				res+=arr[i]/T;
			}else {
				res+=arr[i]/T+1;
			}
		}
		System.out.println(res);
		System.out.println(N/P+" "+N%P);
		
	}
}
