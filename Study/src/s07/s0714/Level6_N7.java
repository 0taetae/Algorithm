package s07.s0714;

import java.util.Scanner;

public class Level6_N7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=N;
		
		for (int i=0;i<N;i++) {
			String S = sc.next();
			
			int com=0;
			int[] arr = new int[26];
			
			for(int j=0;j<S.length();j++) {
				int a = S.charAt(j);
				
				if(com != a) {
					if (arr[a-'a']==0) {
						arr[a-'a']++;
						com = a;
					}
					else {
						count--;
						break;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();

	}

}
