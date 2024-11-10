package s11.s1109;

import java.io.*;
import java.util.*;

public class BOJ_1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = K;
		
		while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);

	}

}
