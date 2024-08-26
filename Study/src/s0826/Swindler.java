package s0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swindler {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 종이컵의 개수
		int X = Integer.parseInt(st.nextToken());  // 간식이 들어있는 컵이 몇번째인지
		int K = Integer.parseInt(st.nextToken());  // 컵의 위치 바꾸는 횟수
		int[] arr = new int[N+1];
		arr[X] = 1;
		for(int j=1;j<=K;j++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 컵의 위치 바꾸기
			int temp = arr[A];
			arr[A] = arr[B];
			arr[B] = temp;
		}
		for(int j=1;j<=N;j++) {
			if(arr[j]==1) {
				System.out.println(j);
				//sb.append("#").append(i).append(" ").append(j).append("\n");
				break;
			}
		}
		//System.out.println(sb);

	}

}
