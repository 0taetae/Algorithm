package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_3273 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int X = Integer.parseInt(br.readLine());
		int cnt=0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i]+arr[j]==X) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
