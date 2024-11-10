package s11.s1110;

import java.io.*;
import java.util.*;

public class BOJ_1074 {
	
	static int N,r,c;
	/*
	1 2
	3 4 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 2^N * 2^N 배열 
		r = Integer.parseInt(st.nextToken())+1;  // 열번호
		c = Integer.parseInt(st.nextToken())+1;  // 행번호 
		int size = (int) Math.pow(2,N);
		
		System.out.println(check(1,1,size));
		
	}
	public static int check(int x, int y, int size) {
        if (size == 1) {
            return 0;
        }
        
        int newSize = size / 2;
        // 1
        if (r < x + newSize && c < y + newSize) {
            return check(x, y, newSize);
        } 
        // 2
        else if (r < x + newSize && c >= y + newSize) {
            return newSize * newSize + check(x, y + newSize, newSize);
        }
        // 3
        else if (r >= x + newSize && c < y + newSize) {
            return 2 * newSize * newSize + check(x + newSize, y, newSize);
        }
        // 4
        else {
            return 3 * newSize * newSize + check(x + newSize, y + newSize, newSize);
        }
    }

}
