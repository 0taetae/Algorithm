package s10.s1021;

import java.io.*;
import java.util.*;

public class BOJ_14499 {
	
	static int N,M,x,y,K;
	static int[][] map;
	// 동 서 북 남 (우 좌 상 하)
	static int[] dx= {0,0,0,-1,1};
	static int[] dy= {0,1,-1,0,0};
	static ArrayList<Integer> lst = new ArrayList<>();  // 주사위 도면상 번호 = 인덱스
	static int[] comArr;
	
	// [해당 번호의 윗면, 동쪽이동했을때 윗면, 서쪽 이동했을 때 윗면...]
//	static int[][] upNum = {{0,0,0,0,0},
//						{6,4,3,5,2},
//						{5,4,3,1,6},
//						{4,1,6,5,2},
//						{3,6,1,5,2},
//						{2,4,3,6,1},
//						{1,4,3,2,5}};
	static int[][] numInfo = {{0,0,0,0,0},
			{6,3,4,2,5},
			{5,3,4,6,1},
			{4,5,2,6,1},
			{3,2,5,6,1},
			{2,3,4,1,6},
			{1,5,2,3,4}};
	
	
	static int[] num;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());  // 주사위를 놓은 곳의 좌표
		y = Integer.parseInt(st.nextToken());  // 주사위를 놓은 곳의 좌표
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
			}
		}
		comArr= new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			comArr[i] = Integer.parseInt(st.nextToken());
		}
		num = new int[7];
		int startNm = 1;
		for(int i=0;i<K;i++) {
			//System.out.println(i+"번째 명령");
			int nx = x + dx[comArr[i]];
			int ny = y + dy[comArr[i]];
			
			if(nx<0|| ny<0 || nx>=N ||ny>=M) {
				//System.out.println("범위 벗어남 ");
				continue;
			}
			
			// startNm을 명령에 의해 이동했을 때 주사위 밑면 칸번호 
			int nextNm = numInfo[startNm][comArr[i]];
			
			// 해당 칸 번호의 윗면에 있는 수 
			System.out.println("답!!! "+num[numInfo[nextNm][0]]);
			
			//System.out.println(nextNm+" 다음 수");
			
			// 이동한 칸에 쓰여 있는 수가 0인경우, 주사위의 바닥면에 쓰여진 수가 칸에 복사
			if(map[nx][ny]==0) {
				//System.out.println("이동한 칸에 쓰여 있는 수가 0인 경우 ");
				map[nx][ny] = num[nextNm];
			}
			
			// 이동한 칸에 쓰여 있는 수가 0이 아닌 경우, 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
			else {
				//System.out.println("이동한 칸에 쓰여 있는 수 0 XXXX");
				num[nextNm] = map[nx][ny];
				//System.out.println(num[nextNm]+" 바닥면 수");
				// 칸에 쓰여 있는 수는 0이 된다
				map[nx][ny] = 0;
			}
			// 주사위가 이동했을 때, 상단에 쓰여 있는 값 
			
			startNm = nextNm;
			x = nx;
			y = ny;
//			
//			for(int r=0;r<N;r++) {
//				for(int c=0;c<M;c++) {
//					System.out.print(map[r][c]+" ");
//					
//				}
//				System.out.println();
//			}
//			for(int j=0;j<7;j++) {
//				System.out.print(num[j]+" ");
//			}
//			System.out.println();
		}
		

	}

}
