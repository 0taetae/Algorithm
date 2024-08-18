package s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int mul = A*B*C;
		String str = Integer.toString(mul);
		
		for(int i=0;i<10;i++) {
			int count=0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)-'0'==i) {
					count++;
				}
			}
			System.out.println(count);
			
		}

	}

}
