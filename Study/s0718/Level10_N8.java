package s0718;

import java.util.Scanner;
import java.util.Arrays;

public class Level10_N8 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		Arrays.sort(arr);
		
		while(true) {
			int sum = arr[0]+arr[1]+arr[2];
			if(arr[0]+arr[1]>arr[2]) {
				System.out.println(sum);
				break;
			}
			else {
				arr[2]--;
			}
		}
		sc.close();

	}

}
