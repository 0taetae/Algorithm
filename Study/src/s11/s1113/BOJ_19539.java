package s11.s1113;

import java.io.*;
import java.util.*;

public class BOJ_19539 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int even = 0;
		int odd = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int height = Integer.parseInt(st.nextToken());
			even+=height/2;
			odd+=height%2;
		}
		
		if(even==odd) {
			System.out.println("YES");
		}else if(odd>even) {
			System.out.println("NO");
		}else {  // even > odd 
			int temp = even - odd;
			if(temp*2%3==0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
		

	}

}
