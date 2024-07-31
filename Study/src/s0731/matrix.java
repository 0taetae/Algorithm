package s0731;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class matrix {
	static int srow;  // 비교할 행 인덱스
	static int scol;  // 비교할 열 인덱스 
	
	public static void main(String[] args) throws IOException {
		int count =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] change = new int[N][M]; // 바꿀 행렬 A 
		int[][] result = new int[N][M];  // 결과 행렬 B
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				change[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				result[i][j] = str.charAt(j)-'0';
			}
		}
		
		// A를 B로 바꿀 수 없는지 
		boolean res = false;
		
		// 3*3행렬보다 작을 때
		if(N<3||M<3) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(change[i][j]!=result[i][j]) {
						res = true;
					}
				}
			}
			if(!res) {  // 같은 경우
				System.out.println(0);
			}else {   // 다른 경우, 3*3행렬 보다 작아서 A를 B로 바꿀 수 없음 
				System.out.println(-1);
			}
			
		}
		else {
			for(int i=0;i<N;i++) {
				if(res) break;
				for(int j=0;j<M;j++) {
					// 같으면 바꿀 필요없음
					if(change[i][j]==result[i][j]) {
						continue;
					}
					else if(change[i][j]!=result[i][j]) {
						// 다른 경우 중, 마지막 행과 열 2개 
						if(i==(N-1)||i==(N-2)||j==(M-1)||j==(M-2)) {
							res = true;
							break;
						}
						else {
							// 다른 경우 스왑 
							srow=i;
							scol=j;
							Swap(change);
							count++;
						}
						
					}
					
				}
			}
			
			if(!res) {
				System.out.println(count);
			}else {  // A를 B로 바꿀 수 없는 경우
				System.out.println(-1);
			}
			
		}

	}
	static void Swap(int[][] change) {
		// 해당 인덱스부터 3*3 만큼 0과 1 교체 
		for(int i=srow;i<srow+3;i++) {
			for(int j=scol;j<scol+3;j++) {
				if(change[i][j]==0) {
					change[i][j]=1;
				}else {
					change[i][j]=0;
				}
			}
		}
	}


}
