package s0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level15_N4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int gcd =0;
		
		for(int i=0;i<N-1;i++) {
			int def = arr[i+1]-arr[i];
			gcd = GCD(def,gcd);
		}
		System.out.println((arr[N-1]-arr[0])/gcd-arr.length+1);

	}
	public static int GCD(int A, int B) {  // 최대공약수
		while(B != 0){
            int R = A%B;
            A = B;
            B = R;
        }
        return A;
	}

}
