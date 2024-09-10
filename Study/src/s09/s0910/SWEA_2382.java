package s09.s0910;

import java.io.*;
import java.util.*;

public class SWEA_2382 {
	
	/*
	K : 미생물 군집 수
	N * N : 구역
	가장자리에는 특수 약품
	1 상, 2 하, 3 좌, 4 우
	1시간마다 이동방향에 있는 셀로 이동
	약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽음 -> 이동방향이 반대로 바뀜
	살아남은 미생물 수 = 원래 미생물 수 /2
	
	두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 됨
	합쳐진 군집의 미생 물의 수 = 군집들의 미생물 수의 합, 이동방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 됨
	
	
	M시간 후 남아있는 미생물 수의 총합???
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
			this.cnt = cnt;  // 미생물 수
			this.dir = dir;  // 이동방향
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
			// M시간동안 미생물 변화보기
			for(int i=0;i<M;i++) {
				arr = new int[N][N];
				for(int j=0;j<K;j++) {
					if(micro.get(j).cnt <0) continue;
					Info cur = micro.get(j);
					arr[cur.x][cur.y] = 0;
					int nx = cur.x + dx[cur.dir];
					int ny = cur.y + dy[cur.dir];
					
					// 약품처리한 곳으로 가게 되면 
					if(nx==0 || ny==0 || nx==N-1 || ny==N-1) {
						// 미생물 수 반으로 줄이기
						int ncnt = cur.cnt/2;
						// 반대방향으로 바구기
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
					// 다른 군집과 만나면
					else if(arr[nx][ny]==1){
						for(int s=0;s<K;s++) {
							if(micro.get(s).x==nx && micro.get(s).y==ny) {
								// 미생물 수가 많은 것의 방향으로 바꾸기, 미생물 수 합하기 
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
					//System.out.println("없어");
					continue;
				}
				res+=micro.get(i).cnt;
			}
			System.out.println(res);
			
			// 미생물을 이동시키고 해당 인덱스의 배열값이 1이면 미생물 수 합하기, 미생물 수가 많은 것의 방향으로 바꾸기
			// idx=0,N-1일때 미생물 수/2바꾸기
			
			
			
		}

	}

}
