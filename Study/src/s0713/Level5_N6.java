package s0713;

import java.util.Arrays;
import java.util.Scanner;

public class Level5_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i=0; i<S.length();i++) {
			char c = S.charAt(i);
			if(arr[c-'a']==-1) {
				arr[c-'a']=i;
			}
		}
		for(int j=0;j<26;j++) {
			System.out.print(arr[j]+" ");
		}
		
		

	}

}
