package s09.s0910;

import java.io.*;
import java.util.*;

public class BOJ_11723 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
//		Set<Integer> copyset = new HashSet<>();
//		for(int j=1;j<=20;j++) {
//			copyset.add(j);
//		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			if(com.equals("all")) {
				set.clear();
				for(int j=1;j<=20;j++) {
					set.add(j);
				}
			}
			else if(com.equals("empty")) {
				set.clear();
			}
			else {
				int N = Integer.parseInt(st.nextToken());
				
				switch(com) {
					case "add" :
						set.add(N);
						break;
					case "check" :
						if(set.contains(N)) {
							sb.append(1).append("\n");
						}else {
							sb.append(0).append("\n");
						}
						break;
					case "remove":
						set.remove(N);
						break;
					case "toggle":
						if(set.contains(N)) {
							set.remove(N);
						}else {
							set.add(N);
						}
						break;
					default:
						break;
				}
			}
			
		}
		System.out.println(sb);

	}

}
