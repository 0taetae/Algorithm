package s10.s1027;

import java.io.*;
import java.util.*;

public class BOJ_14888 {
	
	static int N;
	static int[] A;
	static int[] op;  // 연산자 개수 
	static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		perm(A[0], 1);
		System.out.println(max);
        System.out.println(min);

	}
	public static void perm(int res, int idx) {
		if (idx == N) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0: perm(res + A[idx], idx + 1); break;
                    case 1: perm(res - A[idx], idx + 1); break;
                    case 2: perm(res * A[idx], idx + 1); break;
                    case 3: perm(res / A[idx], idx + 1); break;
                }

                op[i]++;
            }
        }
	}

}
