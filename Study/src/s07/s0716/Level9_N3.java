package s0716;

import java.util.Scanner;

public class Level9_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				if(n%i==0) {
					sum+=i;
				}
			}
			if(sum==n) {
				
			}
			
			
			if(n==-1) {
				break;
			}
		}

	}

}
=======
package s07.s0716;
import java.util.Scanner;

public class Level9_N3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			String str = n + " = 1";
			if(n==-1) {
				break;
			}
			int sum = 1;
			for(int i=2; i<n; i++) {
				if(n%i == 0) {
					str = str + " + " + i;
					sum+=i;
				}
			}
			if(n== sum) {
				System.out.println(str);
			}
			else {
				System.out.println(n+" is NOT perfect.");
			}
			
		}
		sc.close();

	}

}
>>>>>>> 98c325dc73ff6d9538bc19e1d484d69ce50a88a4
