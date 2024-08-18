package s07.s0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level15_N5 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int k=0;k<N;k++) {
			long num = Long.parseLong(br.readLine());
			if(num == 0 || num == 1 || num == 2)
            {
                System.out.println(2);
                continue;
            }
			while(true) {
				int result=0;
				for(long i=2;i<=Math.sqrt(num);i++) {
					if(num%i==0) {  // 1과 자기자신이 아닌 수로 나누어 떨어지는 경우, 즉 소수가 아님
						result++;
						break;
					}
				}
				if(result==0) {  // 소수인 경우
					System.out.println(num);
					break;
				}
				num++;
			}
		}
		

	}
}
