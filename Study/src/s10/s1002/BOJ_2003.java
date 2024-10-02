package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_2003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // N개의 수로 된 수열
		int M = Integer.parseInt(st.nextToken());  // 합이 M이 되는 경우의 수
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0;
		int cnt = 0;
		for(int i=0;i<N;i++) {  // 시작점
			sum=0;
			for(int j=i;j<N;j++) {  // 끝점 
				sum+=arr[j];
				if(sum==M) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);

	}

}
