package s09.s0919;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
	
	static int N,M;
	static int[][] box;
	
	// ���� �丶�� ť�� �ֱ�, ���� ���� �丶�䰡 4���⿡ ������ ���� �丶��� �ٲٰ� ť�� �ֱ�
	// �丶�䰡 ������� ���� ĭ�� �ѱ��
	// ���� �丶�並 ť�� ���� �� ���� ���� ����, �ش� ť�� �� ���� -> ��¥ ����

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		int firstCnt=0;
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				int state =  Integer.parseInt(st.nextToken());
				box[r][c] = state;
				if(state==1) {
					
				}
			}
		}

	}

}
