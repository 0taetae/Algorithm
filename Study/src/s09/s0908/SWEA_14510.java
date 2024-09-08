package s09.s0908;

import java.io.*;
import java.util.*;

public class SWEA_14510 {
	
	/*
	하루에 한 나무에 물을 줄 수 있음
	홀수날은 1만큼, 짝수날은 2만큼 키가 자람
	물을 주지 않는 날이 있을 수 있음
	모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 할 수 있는 최소 날짜 수 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());  // 테케 수
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());  // 나무의 개수
			
			int[] tree = new int[N];
			int maxTree = 1;  // 나무의 초기 높이는 1 이상 120 이하
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(tree[i], maxTree);  // 처음에 가장 키가 큰 나무 찾기 
			}
			// 자라야할 나무 높이 
			int even = 0;
			int odd=0;
			
			for(int i=0;i<N;i++) {
				even += (maxTree-tree[i])/2;
				odd += (maxTree-tree[i])%2;
			}
			int res = 0;
			// 짝수 날이 많은 경우
			if(even > odd) {
				int check = (even - odd)*2; // 나머지 자라야할 높이 
				res += check/3*2; // 1 2, 1 2 
				
				if(check%3==1) {  // 1 2 1 2 1
					res++;
				}
				else if(check%3==2) {  // 1 2 1 2 0 2
					res+=2;
				}
				res += odd*2;  // 1 2 1 2 1 2 
				
			}else if(even<odd) {  // 홀수 날이 많은 경우
				int check = odd-even;
				res += check*2-1;  // 1 0 1 0 1
				res += even *2;  // 1 2 1 2 
			}else {  // 같은 경우 
				res = odd + even;
			}
			System.out.println(res);
			
		}
		

	}

}
