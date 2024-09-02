package p0902;

import java.io.*;
import java.util.*;

public class Algo3_부울경_03반_김태영 {
	
	static int K,h;
	static String[] process ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		K = Integer.parseInt(br.readLine());  // 가로로 K번, 세로로 K번 접는다.
		process = new String[2*K];  // 종이 접는 방법 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*K;i++) {
			process[i] = st.nextToken();
		}
		
		h = Integer.parseInt(br.readLine());  // 구멍을 뚫는 위치 
	}

}
