package s07.s0713;

import java.util.Scanner;
import java.util.HashSet;

public class Level4_N8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int i = 0; i<10; i++) {
			int a = sc.nextInt();
			hs.add(a % 42);
		}
		System.out.println(hs.size());

	}

}
