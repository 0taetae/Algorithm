package s0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Level16_N1 {
	
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(str.startsWith("1")) {
				String[] arr = str.split(" ");
				stack.push(Integer.parseInt(arr[1]));
			}
			else {
				Check(Integer.parseInt(str));
			}
			
			
		}
		System.out.println(sb.toString());

	}
	
	static void Check(int num) {
		if(num==2) {
			if(stack.empty()) {
				sb.append(-1+"\n");
			}
			else {
				sb.append(stack.pop()+"\n");
			}
			
		}
		if(num==3) {
			sb.append(stack.size()+"\n");
		}
		if(num==4) {
			if(stack.empty()) {
				sb.append(1+"\n");
			}
			else {
				sb.append(0+"\n");
			}
			
		}
		if(num==5) {
			if(stack.empty()) {
				sb.append(-1+"\n");
			}
			else {
				sb.append(stack.peek()+"\n");
			}
			
		}
	}
	

}
