package s0719;
import java.util.Scanner;
public class Level12_N1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N];
		long max =0;
		long check=0;
		for(int s=0;s<N;s++) {
			long a = sc.nextInt();
			arr[s]=a;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					check = arr[i]+arr[j]+arr[k];
					
					if(check>M) {
						continue;
					}
					if(max<check) {
						max = check;
						
					}
				}
			}
		}
		System.out.println(max);

	}

}
