package s0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class treeheight {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int j=0;j<N;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[j]);
			}
			
			int odd = 0;  // 홀수날 수
			int even = 0;  // 짝수날 수 
			for(int j=0;j<N;j++) {
				int water = (max-arr[j]);
				odd += water %2;
				even += water/2;
			}
			int count=0;
			// 짝수날이 많을 때 (ex. 0  2  0  2 -> 1 + 2 + 1)
			if(odd<even) {
				int check = (even-odd)*2;  // 짝수날, 홀수날 고르게 물을 줘야할 나무의 높이
				int change = check/3*2;  // 1 + 2 -> 2일 
				
				if(check%3==2) {  // 0 + 2 (쉬는날 포함)
					change +=2;
				}
				else if(check%3==1) {  // 1 (쉬는날 없음)
					change +=1;
				}
				count = change+odd*2;
			}
			// 홀수날이 많을 때 (ex. 1 2 1 2 1 0 1 0 1)
			else if(odd>even){
				count = even*2 + (odd-even)*2-1;
			}
			// 짝수날 홀수날 같을 때 
			else {
				count = odd + even;
			}
			System.out.println("#"+i+" "+count);
				
				
		}
		
	}

}
