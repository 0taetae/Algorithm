package s09.s0903;

import java.io.*;
import java.util.*;

public class SWEA_1244 {
	
	static int[] num;
	static int res, K, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			num = new int[str.length()];  // 숫자판 정보 
			for(int j=0;j<str.length();j++) {
				num[j] = str.charAt(j)-'0';
			}
			K = Integer.parseInt(st.nextToken());  // 교환 횟수
			K= Math.min(K, str.length());  // 최대 문자열 길이 6, 교환 횟수가 5이상이면 의미가 없음 / 같은 자리를 여러 번 바꿔서 경우의 수가 중복되는 것이 있기 때문 
			res = 0;
			change(0);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	public static void change(int cnt) {
		
		if(cnt==K) {
			int sum=0;
			for(int i=0;i<num.length;i++) {
				sum += num[i]*Math.pow(10, num.length-i-1);
			}
			res = Math.max(res, sum);
			return;
		}
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				
				change(cnt+1);
				
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
}
