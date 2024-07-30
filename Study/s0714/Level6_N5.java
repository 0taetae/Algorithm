package s0714;

import java.util.Scanner;
import java.util.Arrays;

public class Level6_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		S = S.toUpperCase();
		
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		
		for(int i=0;i<S.length();i++) {
			int n = S.charAt(i);
			arr[n-'A']++;
		}
		int max = 0;
		char ans='?';
		for(int j=0;j<26;j++) {
			if(max<arr[j]) {
				max = arr[j];
				ans = (char) (j+'A');
			}
			else if(max == arr[j]) {
				ans = '?';
			}
		}
		System.out.println(ans);
		sc.close();

	}

}
