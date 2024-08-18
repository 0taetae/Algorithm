package s07.s0714;

import java.util.Scanner;

public class Level8_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int S=1;
		int count=1;
		do { 
			count = count+1;
			S = S + count;
		}while(X>S);
		if(X==1) {
			System.out.println("1/1");
		}
		else if(count%2!=0) { 
			System.out.println((S-X+1)+"/"+(count-S+X));		
		} 
		else {
			System.out.println((count-S+X)+"/"+(S-X+1));
		}
		sc.close();

	}

}
