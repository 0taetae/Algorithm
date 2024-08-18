package s07.s0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level12_N4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];  // 입력받는 체스판
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
		}
		
		String[] W = new String[8];  // 0,0번째가 w인 체스판
		for(int i=0;i<8;i++) {
			if(i%2==0) {  // 짝수번째 줄 = w부터 시작
				W[i]="WBWBWBWB";
			}
			else {
				W[i]="BWBWBWBW";
			}
		}
		
		String[] B = new String[8];  // 0,0번째가 b인 체스판
		for(int i=0;i<8;i++) {
			if(i%2==0) {  // 짝수번째 줄 = w부터 시작
				B[i]="BWBWBWBW";
			}
			else {
				B[i]="WBWBWBWB";
			}
		}
		
		// 입력받은 체스판과 올바른 체스판 비교
		int min=64;  // 8*8체스판에서 최대 수정 횟수
		for(int i = 0; i < (N - 7); i++) {  // 8*8 체스판이므로 입력받은 체스판의 행이나 열의 수의 -7 만큼만 확인하면됨
			for(int j = 0; j < (M - 7); j++) {
				int Wcount = 0;  // w체스판으로 맞출 경우
				int Bcount = 0;  // b체스판으로 맞출 경우
				for(int k = 0; k < 8; k++) {
					for(int s = 0; s < 8; s++) {
						if(W[k].charAt(s) != arr[k + i].charAt(s + j)) Wcount++;
						if(B[k].charAt(s) != arr[k + i].charAt(s + j)) Bcount++;
					}
				}
				min = Math.min(min, Math.min(Wcount, Bcount));
			}
		}
		System.out.println(min);

	}

}
