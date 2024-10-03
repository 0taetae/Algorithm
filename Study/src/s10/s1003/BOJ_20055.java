package s10.s1003;

import java.io.*;
import java.util.*;

public class BOJ_20055 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  // 올리는 위치는 0, 내리는 위치는 N-1
		int K = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[2*N];
		int[] robot = new int[2*N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			belt[i] = Integer.parseInt(st.nextToken());  // 각 칸의 내구도 
		}
		int cnt = 0;
		int level=0;
		while(cnt < K) {
			level++;
			// 로봇과 벨트 함께 한칸 회전
			int temp = belt[2*N-1];
			for(int i=2*N-1;i>=1;i--) {
				belt[i] = belt[i-1];
				robot[i] = robot[i-1];
			}
			belt[0] = temp;
			robot[0] = 0;
			
			// 내리는 위치에서 로봇 내리기 
			robot[N-1]=0;
			
			// 로봇 이동하기 
			for(int i=N-1;i>=1;i--) {
				// 이동할 로봇이 있고, 이동할 칸에 로봇이 없고, 그 칸의 내구성이 1이상인 경우 
				if(robot[i]==0 && robot[i-1]==1&& belt[i]>=1) {
					robot[i] = 1;
					robot[i-1]=0;
					belt[i]--;
					if(belt[i]==0) cnt++;
				}
				
			}
			// 내리는 위치에서 로봇 내리기 
			robot[N-1]=0;
			
			// 내구성이 1이상이고, 로봇이 없으면 로봇 올리기 
			if(belt[0]>=1 && robot[0]==0) {
				robot[0]=1;
				belt[0]--;
				if(belt[0]==0) cnt++;
			}
		}
		System.out.println(level);

	}

}
