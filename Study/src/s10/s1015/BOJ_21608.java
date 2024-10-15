package s10.s1015;

import java.io.*;
import java.util.*;

public class BOJ_21608 {
	
	// 상 좌 우 하
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	/*
	학생 수 - N^2 -> 학생 번호 1 ~ N^2
	교실 - N*N
	
	학생의 순서
	학생이 좋아하는 학생 4명
	
	한 칸에는 학생 한명만
	행 차 + 열 차 = 1 -> 두 칸이 인접 => 4방향
	
	1. 빈 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 지정
	2. 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리 지정
	3. 행의 번호가 가장 작은 칸 -> 열의 번호가 가장 작은 칸
	
	학생의 만족도 - 자리 배치가 끝난 후 구할 수 있음
	학생과 인접한 칸에 앉은 좋아하는 학생 수 -> 0명=0, 1명=1, 2명=10, 3명=100, 4명=1000
	 */
	
	static int N;
	static int[][] room,likeNum;
	static ArrayList<Info> likeList ;  // 인접한 칸에 있는 좋아하는 학생 수
	static ArrayList<Info> noList;  // 인접한 칸에 있는 빈칸 수 
	static class Info{
		int x,y,likeCnt,noCnt;
		Info(int x, int y, int likeCnt, int noCnt){
			this.x = x;
			this.y = y;
			this.likeCnt = likeCnt;
			this.noCnt = noCnt;
		}
	}
	static int likeCnt = Integer.MIN_VALUE;
	static int noCnt = Integer.MIN_VALUE;
	static int likeTotalCnt,noTotalCnt = 0;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<Integer> seqList = new ArrayList<>();
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		
		likeNum = new int[N*N][5];
		for(int i=0;i<=N*N+1;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			likeNum[i][0] = num;
			for(int j=1;j<5;j++) {
				
				// likeNum[i][0] = 학생 번호
				// likeNum[i][1~4] = 각 학생이 좋아하는 학생들 
				likeNum[i][j] = Integer.parseInt(st.nextToken());
				list.get(num).add(likeNum[i][j]);
				//System.out.println(likeNum[i][j]);
			}
		}
		
		// list가 많으면 비어있는 칸 찾기
		for(int i=0;i<N*N;i++) {
			//System.out.println(likeNum[i][0]+"번 차례*********");
			likePeople(i);
			if(likeTotalCnt >1) {
				Collections.sort(likeList,(o1,o2) ->(o2.likeCnt- o1.likeCnt)); 
				//System.out.println("주변에 좋아하는 사람 리스트 많아");
				noPeople(i);
				// list가 많으면 행 비교, 열 비교 
				if(noTotalCnt>1) {
					//System.out.println("주변에 빈칸  많아");
					Collections.sort(noList,new Comparator<Info>() {

						@Override
						public int compare(Info o1, Info o2) {
							
							if(o1.x== o2.x) {
								return  o2.y-o1.y;
							}
							
							return  o2.x-o1.x;
						}
					});
					room[noList.get(0).x][noList.get(0).y] = likeNum[i][0];
					
					//System.out.println(res);
					//System.out.println(noList.size());
				}
				else if(noTotalCnt==1) {
					//System.out.println("빈칸 많은 칸 찾았다");
					Collections.sort(noList,(o1,o2) ->(o2.noCnt- o1.noCnt));  
					room[noList.get(0).x][noList.get(0).y] = likeNum[i][0];
					
					//System.out.println(res);
					//System.out.println(noList.get(0).x+" "+noList.get(0).y);
				}
			}
			else if(likeTotalCnt==1) {
				//System.out.println("주변에 좋아하는 사람 한명");
				Collections.sort(likeList,(o1,o2) ->(o2.likeCnt- o1.likeCnt));  // cnt를 기준으로 내림차순
				
				//System.out.println(res);
				room[likeList.get(0).x][likeList.get(0).y] = likeNum[i][0];
				//System.out.println(room[likeList.get(0).x][likeList.get(0).y]);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(room[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(check());
		
		
	}
	
	// 학생 만족도 총합
	public static int check() {
		int res=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				int cnt =0;
				
				for(int dir=0;dir<4;dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
					
					if(list.get(room[i][j]).contains(room[nx][ny])) {
						cnt++;
					}
					
				}
				switch(cnt) {
				case 0:
					res+=0;
					break;
				case 1:
					res+=1;
					break;
				case 2:
					res+=10;
					break;
				case 3:
					res+=100;
					break;
				case 4:
					res+=1000;
					break;
				}
			}
		}
		
		return res;
	}

	// 좋아하는 학생이 인접한 칸에 가장 많은 칸 찾기
	public static void likePeople(int num) {
		//System.out.println("들어왔니");
		likeList = new ArrayList<>();
		likeCnt = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(room[i][j]!=0) continue;
				int cnt = 0;
				for(int dir=0;dir<4;dir++) {
					int nx = i+dx[dir];
					int ny = j+dy[dir];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
					
					for(int idx=1;idx<=4;idx++) {
						if(room[nx][ny]==likeNum[num][idx]) {
							//System.out.println(nx+" "+ny);
							cnt++;
							//System.out.println("cnt "+cnt);
						}
					}
				}
				
				if(likeCnt< cnt) {
					likeCnt = cnt;
					likeTotalCnt = 1;
				}else if(likeCnt == cnt) {
					likeTotalCnt++;
				}
				//likeCnt = Math.max(likeCnt, cnt);
				//System.out.println("주변에 좋아하는 사람 "+i+" "+j+" "+cnt);
				likeList.add(new Info(i,j,cnt,0));
			}
		}
	}
	
	// 인접한 칸 중에서 비어있는 칸이 가장 많은 칸 찾기
	
	public static void noPeople(int num) {
		noList = new ArrayList<>();
		noCnt = Integer.MIN_VALUE;
		
		//likeList에서 찾기
		for(int i=0;i<likeTotalCnt;i++) {
			
			int x = likeList.get(i).x;
			int y = likeList.get(i).y;
			//System.out.println("뭐지 "+x+" "+y);
			int cnt = 0;
			for(int dir=0;dir<4;dir++) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				for(int idx=1;idx<=4;idx++) {
					if(room[nx][ny]==0) {
						cnt++;
					}
				}
			}
			
			if(noCnt< cnt) {
				noCnt = cnt;
				noTotalCnt = 1;
			}else if(likeCnt == cnt) {
				noTotalCnt++;
			}
			//likeCnt = Math.max(likeCnt, cnt);
			noList.add(new Info(x,y,likeList.get(i).likeCnt,cnt));
		}
		
	}
	

}


/*
반례
[Input]
3
1 2 3 4 5
2 3 4 5 6
3 1 4 5 6
4 5 6 7 8
5 1 3 4 6
6 4 5 7 8
7 1 2 8 9
8 3 4 7 9
9 5 6 7 8

[Result]
45

3
5 6 1 8 4
6 7 4 8 2
7 3 1 6 9
4 1 6 9 7
8 5 4 6 3
2 6 4 3 7
1 2 5 8 4
9 4 7 5 6
3 4 1 6 5
=> 44

3
1 1 1 1 1
2 1 1 1 1
3 1 1 1 1
4 1 1 1 1
5 1 1 1 1
6 1 1 1 1
7 1 1 1 1
8 1 1 1 1
9 1 1 1 1
=> 4000

*/