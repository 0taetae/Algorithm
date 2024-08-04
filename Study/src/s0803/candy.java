package s0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candy {
	public static char[][] candy;
	public static int max=0;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		
		// 주어진 사탕 배열
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				candy[i][j] = str.charAt(j);
			}
		}
		
		// 좌우 교환
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				row_swap(i,j);
				check(candy);  // 교환했을 때, 가장 긴 연속 부분 확인 
				row_swap(i,j);
			}
		}
		
		// 상하 교환
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				col_swap(j,i);
				check(candy);  // 교환했을 때, 가장 긴 연속 부분 확인 
				col_swap(j,i);
			}
		}
		System.out.println(max);
		

	}
	
	public static void row_swap(int i, int j) {
		
		char temp = candy[i][j];
		candy[i][j] = candy[i][j+1];
		candy[i][j+1] = temp;
	}
	public static void col_swap(int j, int i) {
		
		char temp = candy[j][i];
		candy[j][i] = candy[j+1][i];
		candy[j+1][i] = temp;
	}
	public static int check(char[][] candy) {
		
		for(int i=0;i<N;i++) {
			int count=1;
			for(int j=0;j<N-1;j++) {
				if(candy[j][i]==candy[j+1][i]) {
					count++;
				}else {
					count=1;
				}
				
				max = Math.max(max, count);
			}
		}
		for(int i=0;i<N;i++) {
			int count=1;
			for(int j=0;j<N-1;j++) {
				if(candy[i][j]==candy[i][j+1]) {
					count++;
				}else {
					count=1;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
}
