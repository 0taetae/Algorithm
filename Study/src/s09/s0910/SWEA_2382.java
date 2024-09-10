package s09.s0910;

import java.io.*;
import java.util.*;

public class SWEA_2382 {
	
	/*
	K : �̻��� ���� ��
	N * N : ����
	�����ڸ����� Ư�� ��ǰ
	1 ��, 2 ��, 3 ��, 4 ��
	1�ð����� �̵����⿡ �ִ� ���� �̵�
	��ǰ�� ĥ���� ���� �����ϸ� ���� �� �̻����� ������ ���� -> �̵������� �ݴ�� �ٲ�
	��Ƴ��� �̻��� �� = ���� �̻��� �� /2
	
	�� �� �̻��� ������ �� ���� ���̴� ��� �������� �������� ��
	������ ������ �̻� ���� �� = �������� �̻��� ���� ��, �̵������� ������ �� �̻��� ���� ���� ���� ������ �̵������� ��
	
	
	M�ð� �� �����ִ� �̻��� ���� ����???
	 */
	
	static int N, M, K;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0,0,-1, 1};
	static int[][] arr;
	static ArrayList<Info> micro;
	
	static class Info{
		int x,y,cnt,dir;
		Info(int x, int y,int cnt, int dir){
			this.x = x;
			this.y = y;
			this.cnt = cnt;  // �̻��� ��
			this.dir = dir;  // �̵�����
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			micro = new ArrayList<>();
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				arr[r][c] = 1;
				micro.add(new Info(r,c,cnt,dir));
			}
			// M�ð����� �̻��� ��ȭ����
			for(int i=0;i<M;i++) {
				arr = new int[N][N];
				for(int j=0;j<K;j++) {
					if(micro.get(j).cnt <0) continue;
					Info cur = micro.get(j);
					arr[cur.x][cur.y] = 0;
					int nx = cur.x + dx[cur.dir];
					int ny = cur.y + dy[cur.dir];
					
					// ��ǰó���� ������ ���� �Ǹ� 
					if(nx==0 || ny==0 || nx==N-1 || ny==N-1) {
						// �̻��� �� ������ ���̱�
						int ncnt = cur.cnt/2;
						// �ݴ�������� �ٱ���
						if(cur.dir == 1) {
							int ndir=2;
						}else if(cur.dir==2) {
							int ndir=1;
						}else if(cur.dir==3) {
							int ndir=4;
						}else {
							int ndir=1;
						}
						arr[nx][ny] = 1;
						arr[cur.x][cur.y]=0;
						
					}
					// �ٸ� ������ ������
					else if(arr[nx][ny]==1){
						for(int s=0;s<K;s++) {
							if(micro.get(s).x==nx && micro.get(s).y==ny) {
								// �̻��� ���� ���� ���� �������� �ٲٱ�, �̻��� �� ���ϱ� 
								if(cur.cnt < micro.get(s).cnt) {
									micro.get(s).cnt = micro.get(s).cnt + cur.cnt;
									//micro.remove(j);
									
									micro.set(j, new Info(0,0,-1,0));
									
									arr[cur.x][cur.y]=0;
								}else {
									cur.cnt = micro.get(s).cnt+cur.cnt;
									//micro.remove(s);
									micro.set(s, new Info(0,0,-1,0));
									cur.x = nx;
									cur.y = ny;
									arr[nx][ny] = 0;
									arr[cur.x][cur.y]=1;
								}
							}
						}
					}
					
					
				}
			}
			int res = 0;
			for(int i=0;i<K;i++) {
				if(micro.get(i).cnt <0) {
					//System.out.println("����");
					continue;
				}
				res+=micro.get(i).cnt;
			}
			System.out.println(res);
			
			// �̻����� �̵���Ű�� �ش� �ε����� �迭���� 1�̸� �̻��� �� ���ϱ�, �̻��� ���� ���� ���� �������� �ٲٱ�
			// idx=0,N-1�϶� �̻��� ��/2�ٲٱ�
			
			
			
		}

	}

}
