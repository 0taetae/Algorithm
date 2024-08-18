package s07.s0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wheel {
    public static int[][] wheel = new int[4][8];  // N극 0,S극 1 / 톱니바퀴 4개
    public static int[] turn = new int[4];     // 톱니바퀴 번호, 방향(1 시계방향, -1 반시계방향)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
        	String str = br.readLine();
			for(int j=0;j<8;j++) {
				wheel[i][j] = str.charAt(j)-'0';
			}
        }
        int K = Integer.parseInt(br.readLine());   
        for (int i = 0; i < K; i++) {  // K번 회전
            Arrays.fill(turn, 0);      //회전 방향 0으로 초기화
            String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int wheelnum = Integer.parseInt(st.nextToken())-1;
			turn[wheelnum] = Integer.parseInt(st.nextToken());

            right(wheelnum);  // 해당 톱니바퀴와 오른쪽 바퀴 비교
            left(wheelnum);  // 해당 톱니바퀴와 왼쪽 바퀴 비교

            for (int j = 0; j < 4; j++) {
            	if(turn[j]==1) {
					clock(j);  // 시계방향으로 회전
				}else if(turn[j]==-1) {
					nonclock(j);  // 반시계방향으로 회전
				} else {
                    continue;
                }
            }

        }
        int sum = 0;
		for(int i=0;i<4;i++) {
			if(wheel[i][0]==1) {  // 각 톱니바퀴의 12시 방향이 S극 일때
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);

    }

    static void left(int wheelnum) {
        if (wheelnum == 0) return;  // 1번 톱니바퀴이면, 비교할 필요없음

        if (wheel[wheelnum - 1][2] != wheel[wheelnum][6]) {
            if (turn[wheelnum] == 1) {
            	turn[wheelnum - 1] = -1;
            } else if(turn[wheelnum] == -1) {
            	turn[wheelnum - 1] = 1;
            }
            left(wheelnum - 1);  // 계속 왼쪽 톱니바퀴와 비교
        }
    }

    static void right(int wheelnum) {
        if (wheelnum == 3) return;      // 4번 톱니바퀴이면, 비교할 필요없음

        if (wheel[wheelnum][2] != wheel[wheelnum + 1][6]) {  
            if (turn[wheelnum] == 1) {
            	turn[wheelnum + 1] = -1;
            } else if(turn[wheelnum] == -1) {
            	turn[wheelnum + 1] = 1;
            }
            right(wheelnum+ 1);  // 계속 오른쪽 톱니바퀴와 비교
        }
    }

    static void nonclock(int n) {
		int temp = wheel[n][0];
		for (int i = 0; i <= 6; i++)
			wheel[n][i] = wheel[n][i + 1];
		wheel[n][7] = temp;
	}
 
	static void clock(int n) {
		int temp = wheel[n][7];
		for (int i = 6; i >= 0; i--)
			wheel[n][i + 1] = wheel[n][i];
		wheel[n][0] = temp;
	}
}

