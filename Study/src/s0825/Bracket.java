package s0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			Stack<Character> stack = new Stack<Character>();
			boolean isOk = true;
			String str = br.readLine();
			for(int j=0;j<str.length();j++){
				if(str.charAt(j)=='(') {
					stack.push(str.charAt(j));
				}else {
					if(stack.isEmpty()) {
						isOk = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) {
				isOk = false;
			}
			if(!isOk) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}

	}

}
