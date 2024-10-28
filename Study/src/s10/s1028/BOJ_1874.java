package s10.s1028;

import java.io.*;
import java.util.*;

public class BOJ_1874 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int cur = 1;

        for (int num : seq) {
            while (cur <= num) {
                stack.push(cur);
                res.append("+\n");
                cur++;
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                res.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(res.toString());
    }

}
