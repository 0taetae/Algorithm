package s0801;

import java.util.Scanner;

public class AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int count=1;
		
		while(A!=B) {
			
			if(B<A) {
				count=-1;
				break;
			}else if(B%2==0) {
				B /= 2;
			}else if(B%10==1) {
				B = (B-1)/10;
			}else {
				count=-1;
				break;
			}
			count++;
			
		}
		System.out.println(count);

	}

}
