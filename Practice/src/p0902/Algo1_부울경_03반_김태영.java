package p0902;

import java.io.*;
import java.util.*;

public class Algo1_부울경_03반_김태영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 안내 멘트 N번 재생
		int L = Integer.parseInt(st.nextToken());  // 안내멘트 L초 동안 재생
		int D = Integer.parseInt(st.nextToken());  // D초마다 1번씩, 1초간 상담원 연결 요청 가능 
		
		// 첫 안내 멘트를 듣는 순간 0초 
		boolean isFinish = false;
		int time=0;
		int result = 0;
		for(int i=0;i<N;i++) {
			time++;
			while((time) %(L+5)!=0) {
				if(time%D==0) {
					if((i*(L+5)+L)<=time && time<(i+1)*(L+5)) {
						isFinish = true;
						result = time;
						break;
					}
				}
				time++;
			}
			if(isFinish) {
				break;
			}
			time++;
		}
		if(!isFinish) {
			System.out.println((time-1));
		}else {
			System.out.println(result);
		}
	}
}
