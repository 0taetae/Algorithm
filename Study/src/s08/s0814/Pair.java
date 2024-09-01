package s08.s0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pair {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean isCorrect=true;
			
			for(int j=0;j<str.length();j++) {
				char target = str.charAt(j);
				
				if(target=='(') {
					stack.push(target);
				}
				else {
					if(!stack.isEmpty() && stack.peek()=='(' && target==')'  ) {
						stack.pop();
					}
					else {
						isCorrect=false;
						break;
					}
					
				}
				
			}
			if(stack.isEmpty() && isCorrect) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}

}
