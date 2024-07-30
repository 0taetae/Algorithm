package s0719;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class Level13_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			int n = sc.nextInt();
			arr[i]=n;
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}

	}

}
