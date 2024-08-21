package s0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sqrt {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			long N = Long.parseLong(br.readLine());
			int count=0;
			if(N==2) {
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}
			while(true) {
				if(N ==2) break;
				double temp = Math.sqrt(N);
				// 제곱근이 정수이면, 해당 제곱근을 N에 넣음 
				if((long) temp == temp) {
					N = (long)temp;
				}else {
					temp = (long) temp;
					// 제곱과 원래 수의 차 -> 더하기 연산 횟수 
					count += (temp+1)*(temp+1)-N;
					N = (long) Math.sqrt((temp+1)*(temp+1));
				}
				count++;
			}
			sb.append("#").append(i).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		
	}

}
