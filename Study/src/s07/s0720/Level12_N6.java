package s07.s0720;
import java.util.Scanner;

public class Level12_N6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans =0;
		for(int i=0;i<=N/3;i++) {
			if(ans>0) break;
			for(int j=0;j<=N/5;j++) {
				if(3*i+5*j==N) {
					ans = i+j;
					System.out.println(ans);
					break;
				}
			}
		}
		if(ans==0) {
			System.out.println(-1);
		}
	}
}
