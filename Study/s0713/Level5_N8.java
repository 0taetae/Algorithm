package s0713;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Level5_N8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		
		StringTokenizer ST = new StringTokenizer(S," ");
		
		System.out.println(ST.countTokens());

	}

}
