package s10.s1018;

import java.io.*;
import java.util.*;

public class BOJ_13422 {
	
	
	// 방법 1 : 완탐 -> 시간초과 
	/*
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			//System.out.println("테케 : "+(tc+1));
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 마을에 있는 집의 개수
			int M = Integer.parseInt(st.nextToken());  // 도둑이 돈을 훔칠 연속된 집의 개수 
			int K = Integer.parseInt(st.nextToken());  // 자동 방범 장치가 작동하는 최소 돈의 양 
			
			int[] money = new int[N];  // 돈의 양
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			int cnt=0;
			for(int i=0;i<N;i++) { // 시작 지점
				int sum=0;
				
				if((i+M-1)<=N-1) {
					//System.out.println("벗어나지 않음 ");
					for(int j=i;j<i+M;j++) {
						sum+=money[j];
						//System.out.println(sum);
					}
				}else {
					//System.out.println("벗어나는 경우 ");
					for(int j=i;j<N;j++) {
						sum+=money[j];
						//System.out.println(sum);
					}
					for(int j=0;j<M-(N-i);j++) {
						sum+=money[j];
						//System.out.println(sum);
					}
				}
				//System.out.println("합 : "+sum);
				if(sum<K) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	*/
	
	// 방법 2 : 슬라이딩 윈도우
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 마을에 있는 집의 개수
			int M = Integer.parseInt(st.nextToken());  // 도둑이 돈을 훔칠 연속된 집의 개수 
			int K = Integer.parseInt(st.nextToken());  // 자동 방범 장치가 작동하는 최소 돈의 양 
			
			int[] money = new int[N];  // 돈의 양
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt=0;
			int preSum=0;
			int sum=0;
			
			// 집의 개수와 훔칠 집의 개수가 같은 경우
			if(N==M) {
				for(int i=0;i<M;i++) {
					preSum+=money[i];
				}
				if(preSum<K) {
					cnt++;
				}
			}
			else {
				for(int i=0;i<M;i++) {
					preSum+=money[i];
				}
				if(preSum<K) {
					cnt++;
				}
				for(int i=1;i<N;i++) { // 시작 지점
					sum=preSum;
					sum-=money[i-1];  // 이전의 첫번째 값 빼기 
					sum+=money[(i+M-1)%N];  // 다음값 더하기 
					if(sum<K) {
						cnt++;
					}
					preSum=sum;
				}
			}
			System.out.println(cnt);
		}
	}

}
