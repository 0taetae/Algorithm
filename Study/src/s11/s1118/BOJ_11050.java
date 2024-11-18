package s11.s1118;
import java.io.*;
import java.util.*;

public class BOJ_11050 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(binom(N, K));
    }

    public static int binom(int n, int k) {
        if (k == 0 || k == n) return 1; 
        return fac(n) / (fac(k) * fac(n - k));
    }

    public static int fac(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
