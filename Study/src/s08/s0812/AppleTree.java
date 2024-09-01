package s08.s0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AppleTree {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tree = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		int sum = Arrays.stream(tree).sum();
		if(sum % 3 != 0) {
			System.out.println("NO");
		}
		else {
			int count1 = 0;
			int count2 = 0;
			for(int i=0;i<N;i++) {
				count2 += tree[i]/2;
				count1 += tree[i]%2;
			}
			if(count1 == count2) {
				System.out.println("YES");
			}
			if(count1 > count2) {
				System.out.println("NO");
			}
			if(count2 > count1) {
				if((count2-count1)%3==0) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
		}

	}

}
