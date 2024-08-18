package s07.s0718;
import java.util.Scanner;
public class Level11_N7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		if((a1*n + a0 > c*n) || c<a1) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}

	}

}
