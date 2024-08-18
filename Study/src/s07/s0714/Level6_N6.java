package s07.s0714;

import java.util.Scanner;

public class Level6_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for (String i:arr){
			S = S.replace(i,"0");
		}
		System.out.println(S.length());
		
		sc.close();

	}

}
