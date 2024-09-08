package s09.s0908;

import java.io.*;
import java.util.*;

public class BOJ_16637 {
	
	static int N, maxRes;
	static char[] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		arr = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			arr[i] = str.charAt(i);
		}
		isSelected = new boolean[N];
		maxRes = Integer.MIN_VALUE;
		subSet(0);
		
		System.out.println(maxRes);
		

	}
	static void subSet(int idx) {
		if(idx>=N) {
			int res = cal();
			maxRes = Math.max(res, maxRes);
			return;
		}
		if(idx+2<N) {
			isSelected[idx+2] = true;
			subSet(idx+4);
			isSelected[idx+2] = false;
		}
		subSet(idx+2);
	}
	static int cal() {
		int cur = arr[0]-'0';
		int i=0;
		while(i<=N-3) {
			char op = arr[i+1];
			int next;
			if(isSelected[i+2] && i+4<N) {
				next = operate(arr[i+2]-'0', arr[i+4]-'0', arr[i+3]);
				cur = operate(cur, next, op);
				i+=4;
			}
			else {
				next = arr[i+2]-'0';
				cur = operate(cur, next, op);
				i+=2;
			}
		}
		return cur;
	}
	static int operate(int cur, int next, char op) {
        switch(op) {
        	case '+' : 
        		return cur+next;
        	case '*':
        		return cur*next;
        	case '-':
        		return cur-next;
        }
        return 0;
    }

}
