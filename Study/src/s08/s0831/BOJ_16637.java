package s08.s0831;

import java.util.Scanner;

public class BOJ_16637 {
    static int N;
    static boolean[] isSelected; 
    static char[] arr;
    static int maxRes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); 
        String str = sc.nextLine();
        arr = str.toCharArray();
        isSelected = new boolean[N];
        
        maxRes = Integer.MIN_VALUE;
        subset(0);
        System.out.println(maxRes);
    }

    // 부분집합으로 괄호로 먼저 계산할 숫자를 선택 
    static void subset(int idx) {
        if (idx >= N) {
            int res = operate();
            maxRes = Math.max(res, maxRes);
            return;
        }

        // 선택
        if (idx + 2 < N) { 
            isSelected[idx + 2] = true;
            subset(idx + 4);
            isSelected[idx + 2] = false;
        }
        // 비선택
        subset(idx + 2); 
    }

    static int operate() {
        int cur = arr[0] - '0';  // 첫 번째 숫자
        int i = 0; 
        
        while (i <= N - 3) {
            char op = arr[i + 1]; // 현재 연산자
            int next;
            // 괄호로 먼저 계산할 경우
            if (i + 4 < N && isSelected[i + 2]) { 
            	next = calculate(arr[i + 2] - '0', arr[i + 4] - '0', arr[i + 3]);
                cur = calculate(cur, next, op);
                i += 4;
            } else {
                next = arr[i + 2] - '0';
                cur = calculate(cur, next, op);
                i += 2; 
            }
        }
        
        return cur; 
    }

    // 계산
    static int calculate(int cur, int next, char op) {
        switch (op) {
            case '+':
                return cur + next;
            case '-':
                return cur - next;
            case '*':
                return cur * next;
        }
        return 0;
    }
}
