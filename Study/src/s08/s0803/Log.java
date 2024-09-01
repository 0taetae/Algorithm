package s08.s0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Log {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> log = new ArrayList<Integer>();  // 입력받은 통나무 높이
			ArrayList<Integer> result = new ArrayList<Integer>();  // 난이도가 가장 낮은 통나무 배열
			
			for(int j=0;j<N;j++) {
				log.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(log);
			
			// 낮이도가 가장 낮은 통나무 배열을 만들기 위해 1 3 5 4 2와 같은 순으로 배치 
			for(int j=0;j<N;j+=2) {
				result.add(log.get(j));
			}
			if(N%2==0) {
				for(int j=N-1;j>0;j-=2) {
					result.add(log.get(j));
				}
			}else {
				for(int j=N-2;j>0;j-=2) {
					result.add(log.get(j));
				}
			}
			
			int max = 0;
			// 배열의 난이도 
			for(int j=0;j<N-1;j++) {
				max = Math.max(max, Math.abs(result.get(j+1)-result.get(j)));
			}
			System.out.println(max);
			
		}
	}

}
