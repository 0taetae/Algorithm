package s0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class  WordMath {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpa = new int[26]; // A ~ Z까지 배열 -> C-'C' = 인덱스
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int len = str.length()-1;
			for(int j=0;j<str.length();j++) {
				alpa[str.charAt(j)-'A'] +=  (int) Math.pow(10,len);
				len--;
			}
		}
		Arrays.sort(alpa);
		int num=9;
		int sum=0;
		for(int i=25;i>=17;i--) {
			sum += alpa[i]*num;
			num--;
		}
		System.out.println(sum);
	}

}
