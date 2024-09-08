package s09.s0906;

import java.io.*;
import java.util.*;

public class SWEA_2115 {

    static int N, M, C;
    static int[][] honey;
    static int startX, startY;
    static int startR, startC;
    static int sumA, sumB, res;
    static int powA, powB;
    static boolean[] selected1, selected2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수 
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            selected1 = new boolean[M];
            selected2 = new boolean[M];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    honey[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            res = 0;
            // 첫번째 일꾼이 채취할 벌통 선택
            for(int r=0;r<N;r++) {
            	for(int c=0;c<=N-M;c++) {
            		subSet1(0,r,c);
            	}
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
    // 두번째 일꾼이 채취할 벌통 선택 
    static void pick(int r, int c) {
    	for(int j=c;j<=N-M;j++) {
			subSet2(0,r,j);
		}
    	for(int i=r+1;i<N;i++) {
    		for(int j=0;j<=N-M;j++) {
    			subSet2(0,i,j);
    		}
    	}
    }
    // 선택한 벌통에서 채취할 꿀 선택 (첫번째 일꾼)
    static void subSet1(int cnt, int r,int k) {
    	if(cnt==M) {
    		sumA=0;
    		powA=0;
    		int count = 0;
    		for(int i=0;i<M;i++) {
    			if(selected1[i]) {
    				sumA += honey[r][k+i];
    				powA += honey[r][k+i]*honey[r][k+i];
    			}
    		}
    		if(sumA<=C) {
    			pick(r,k+M);
    		}
    		return;
    	}
    	selected1[cnt] = true;
    	subSet1(cnt+1,r, k);
    	selected1[cnt] = false;
    	subSet1(cnt+1,r, k);
    }
    // 선택한 벌통에서 채취할 꿀 선택 (두번째 일꾼)
    static void subSet2(int cnt, int r,int k) {
    	if(cnt==M) {
    		sumB=0;
			powB=0;
    		for(int i=0;i<M;i++) {
    			if(selected2[i]) {
    				sumB += honey[r][k+i];
    				powB += honey[r][k+i]*honey[r][k+i];
    			}
    		}
    		if(sumB<=C && powB + powA > res) {
				res = powB + powA;
			}
    		return;
    	}
    	selected2[cnt] = true;
    	subSet2(cnt+1,r, k);
    	selected2[cnt] = false;
    	subSet2(cnt+1,r, k);
    }
}
