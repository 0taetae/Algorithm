package s10.s1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] Lan = new int[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            Lan[i] = Integer.parseInt(br.readLine());
            if (Lan[i] > maxLen) {
                maxLen = Lan[i];
            }
        }

        long startLen = 1;
        long endLen = maxLen;
        long res = 0;

        while (startLen <= endLen) {
            long midLen = (startLen + endLen) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += Lan[i] / midLen;
            }

            if (cnt < N) {
                endLen = midLen - 1;
            } else {
                res = midLen;
                startLen = midLen + 1;
            }
        }

        System.out.println(res);
    }
}
