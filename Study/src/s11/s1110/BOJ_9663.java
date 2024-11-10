package s11.s1110;

import java.io.*;
import java.util.*;

public class BOJ_9663 {
    
    static int N;
    static int[] col;  // 각 행에 있는 퀸의 열 위치
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        
        check(0);
        
        System.out.println(cnt);
    }
    static void check(int row) {
        if (row == N) {
            cnt++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            col[row] = i; // row 행의 i 열에 있음 
            
            // row 행 이전의 모든 행에 대해 확인 
            if (isValid(row)) {
            	check(row + 1);
            }
        }
    }
    
    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
        	// 1.  i 행에서 퀸이 있는 열 위치와 row 행에 있는 퀸이 있는 열의 위치가 같은지
        	// 2.  두 퀸 사이의 행 차이와 열 차이가 같은지 확인 -> 대각선상에 퀸이 있는지 확인
        	//       절댓값의 이유 : 두 대각선 모두 확인 
        	//       행의 차는 절대값을 안하는 이유 : 이전의 행과의 차이기 때문에 항상 양수 
            if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}