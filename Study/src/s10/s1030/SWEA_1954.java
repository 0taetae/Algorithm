package s10.s1030;

import java.io.*;
import java.util.*;

public class SWEA_1954 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int end=0;
			int num=1;
			// N이 짝수 
			if(N%2==0) {
				end = N/2-1;
				
				for(int i=0;i<=end;i++) {
					// 오른쪽으로 
					for(int c=i;c<N-1-i;c++) {
						arr[i][c] = num;
						num++;
					}
					// 아래쪽으로
					for(int r=i;r<N-1-i;r++) {
						arr[r][N-1-i] = num;
						num++;
					}
					// 왼쪽으로
					for(int c=N-1-i;c>=i+1;c--) {
						arr[N-1-i][c] = num;
						num++;
					}
					// 위쪽으로
					for(int r=N-1-i;r>=i+1;r--) {
						arr[r][i] = num;
						num++;
					}
					
				}
				
			}
			// N이 홀수 
			else if(N%2!=0) {
				end = N/2;
				
				for(int i=0;i<=end;i++) {
					// 오른쪽으로 
					for(int c=i;c<=N-1-i;c++) {
						if(arr[i][c]!=0) continue;
						arr[i][c] = num;
						num++;
					}
					// 아래쪽으로
					for(int r=i;r<=N-1-i;r++) {
						if(arr[r][N-1-i]!=0) continue;
						arr[r][N-1-i] = num;
						num++;
					}
					// 왼쪽으로
					for(int c=N-1-i;c>=i+1;c--) {
						if(arr[N-1-i][c]!=0) continue;
						arr[N-1-i][c] = num;
						num++;
					}
					// 위쪽으로
					for(int r=N-1-i;r>=i+1;r--) {
						if(arr[r][i]!=0) continue;
						arr[r][i] = num;
						num++;
					}
					
				}
			}
			
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
