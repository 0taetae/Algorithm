package s09.s0912;

import java.io.*;
import java.util.*;

public class BOJ_12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ��ǰ�� ��
		int K = Integer.parseInt(st.nextToken());  // ��ƿ �� �ִ� ����
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); // �� ������ ����
			int V = Integer.parseInt(st.nextToken());  // �ش� ������ ��ġ
			
			if(W<=K) {
				// �ش� ������ ���� ���� ���� ���԰� ���� ��� �ش� ������ ���� �� ����
				for(int j=0;j<W;j++) {
					dp[i][j] = dp[i-1][j];
				}
				// �ش� ���ǵ� ���� �� �ִ� ��� ���� ��ġ�� ��
				for(int j=W;j<=K;j++) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W]+V);
				}
			}else {  // ������ ���԰� ��ƿ �� �ִ� ���Ժ��� ū ���
				for(int j=0;j<=K;j++) {
					dp[i][j] = dp[i-1][j];
				}
			}
			
		}
		System.out.println(dp[N][K]);

	}

}