package s07.s0722;

import java.util.Scanner;

public class coin_0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int count=0;
		
		for(int i=0;i<N;i++) {
			coin[i]=sc.nextInt();
		}
		for(int i=N-1;i>=0;i--) {
			if(K==0) break;
			if(coin[i]<=K) {
				count += K/coin[i];
				K = K%coin[i];
			}
		}
		System.out.println(count);

	}

}