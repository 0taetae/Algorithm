package s08.s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Magnet {
	
	static int K;
	static int[][] wheel;
	static int[] turn;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			K = Integer.parseInt(br.readLine());
			wheel = new int[4][8];
			
			for(int r=0;r<4;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<8;c++) {
					// N극 0, S극 1 
					wheel[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			turn = new int[4];
			for(int j=0;j<K;j++) {
				Arrays.fill(turn, 0);
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;  // 회전하는 자석의 번호
				turn[num] = Integer.parseInt(st.nextToken());  // 회전 방향 
				right(num);
				left(num);
				
				for(int m=0; m<4; m++) {
					if(turn[m]==1) {
						clock(m);
					}
					else if(turn[m]==-1) {
						nonclock(m);
					}else {
						continue;
					}
				}
			}
			int result = score();
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		
		

	}
	public static void right(int num) {
		if(num==3) return;
		if(wheel[num][2] != wheel[num+1][6]) {
			if(turn[num]==1) {
				turn[num+1] = -1;
			}else if(turn[num]==-1) {
				turn[num+1] = 1;
			}
			right(num+1);
		}
	}
	public static void left(int num) {
		if(num==0) return;
		if(wheel[num][6] != wheel[num-1][2]) {
			if(turn[num]==1) {
				turn[num-1]=-1;
			}else if(turn[num]==-1) {
				turn[num-1] = 1;
			}
			left(num-1);
		}
	}
	public static void clock(int num){
		int temp = wheel[num][7];
		for(int i=6;i>=0;i--) {
			wheel[num][i+1] = wheel[num][i];
		}
		wheel[num][0] = temp;
	}
	public static void nonclock(int num) {
		int temp = wheel[num][0];
		for(int i=0;i<=6;i++) {
			wheel[num][i] = wheel[num][i+1];
		}
		wheel[num][7] = temp;
	}
	public static int score() {
		int sum=0;
		for(int i=0;i<4;i++) {
			if(wheel[i][0]==1)
				sum += Math.pow(2, i);
		}
		return sum;
	}


}
