package s0719;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
public class Level13_N2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int n;
		for(int i=0;i<5;i++) {
			n = sc.nextInt();
			arr[i]=n;
		}
		Arrays.sort(arr);
		int sum = Arrays.stream(arr).sum();
		
		System.out.println((int)sum/5);
		System.out.println(arr[2]);

	}

}
