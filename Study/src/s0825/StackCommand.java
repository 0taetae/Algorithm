package s0825;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackCommand {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			if(str.equals("push")) {
				int num = sc.nextInt();
				stack.push(num);
			}else if(str.equals("top")){
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
			}else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.pop());
				}
			}else if(str.equals("size")) {
				System.out.println(stack.size());
			}else if(str.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}

	}

}
