package s09.s0913;

import java.io.*;
import java.util.*;

public class BOJ_1043 {
	
	static int[] knowarr;
	static ArrayList<ArrayList<Integer>> partylst = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			partylst.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		int knowNum = Integer.parseInt(st.nextToken());  // ������ �ƴ� ����� ��
		knowarr = new int[knowNum];  // ������ �ƴ� ����� ��ȣ
		
		// ��Ƽ���� ���� ���
		for(int i=0;i<M;i++) {
			int partyNum = Integer.parseInt(st.nextToken());  // �ش� ��Ƽ�� ���� ��� ��
			for(int j=0;j<partyNum;j++) {
				partylst.get(i).add(Integer.parseInt(st.nextToken()));   // �ش� ��Ƽ�� ���� ��� ��ȣ 
			}
		}
		

	}

}
