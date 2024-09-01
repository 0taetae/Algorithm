package s08.s0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeNum {
	static int N;
	static int[] op = new int[4];  // 연산자 개수 배열 : + 개수, - 개수, * 개수, / 개수 
	static int[] selected;  // 선택한 연산자 배열 
	static int[] num; // 숫자 배열 
	static int min, max;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			N = Integer.parseInt(br.readLine());  // 숫자의 개수
			num = new int[N]; 
			selected = new int[N-1];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				op[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < N; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			perm(0);
			sb.append("#").append(i).append(' ').append(max - min).append('\n');
		}
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == N-1) {
			int tmp = num[0];
			for (int i = 1; i < N; i++) {
				// + 연산자
				if(selected[i-1]==0) {
					tmp += num[i];
				}
				// - 연산자
				else if(selected[i-1]==1) {
					tmp -= num[i];
				}
				// * 연산자
				else if(selected[i-1]==2) {
					tmp *= num[i];
				}
				// / 연산자 
				else {
					tmp /= num[i];
				}
			}
			
			// 계산결과 최댓값, 최솟값 
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] != 0) {
				selected[cnt] = i;
				
				// 해당 연산자 사용하면 개수 감소 
				op[i]--;
				perm(cnt + 1);
				op[i]++;
			}
			
		}
		
	}

}




