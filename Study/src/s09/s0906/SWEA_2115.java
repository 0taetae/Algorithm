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
    static boolean[] selected;

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
            selected = new boolean[M];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    honey[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            res = 0;
            for(int r=0;r<N;r++) {
            	for(int c=0;c<=N-M;c++) {
            		//System.out.println("sumA 시작 "+r+" "+c);
            		subSet1(0,r,c);
            	}
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
    static void pick(int r, int c) {
    	for(int j=c;j<=N-M;j++) {
			if(j>N-M) {
				//System.out.println("범위 넘음");
				break;
			}
			//System.out.println("sumB 시작");
			subSet2(0,r,j);
		}
    	//System.out.println("같은 줄 끝");
    	for(int i=r+1;i<N;i++) {
    		for(int j=0;j<=N-M;j++) {
    			if(j>N-M) continue;
    			//System.out.println("sumB 시작");
    			subSet2(0,i,j);
    		}
    	}
    }
    static void subSet1(int cnt, int r,int k) {
    	if(cnt==M) {
    		sumA=0;
    		powA=0;
    		int count = 0;
    		for(int i=0;i<M;i++) {
    			if(selected[i]) {
    				//System.out.println("선택 ");
    				sumA += honey[r][k+i];
    				//System.out.print(honey[r][k+i]+" ");
    				powA += honey[r][k+i]*honey[r][k+i];
    			}
    		}
    		//System.out.println();
    		//System.out.println("sumA "+sumA);
    		//System.out.println("powA "+powA);
    		if(sumA<=C) {
    			//System.out.println("sumA는 C넘지 않음");
    			pick(r,k+M);
    		}
    		return;
    	}
    	selected[cnt] = true;
    	subSet1(cnt+1,r, k);
    	selected[cnt] = false;
    	subSet1(cnt+1,r, k);
    }
    static void subSet2(int cnt, int r,int k) {
    	if(cnt==M) {
    		sumB=0;
			powB=0;
    		for(int i=0;i<M;i++) {
    			if(selected[i]) {
    				sumB += honey[r][k+i];
    				powB += honey[r][k+i]*honey[r][k+i];
    				//System.out.print(honey[r][k+i]+" ");
    			}
    		}
    		//System.out.println();
    		//System.out.println("sumB "+sumB);
    		///System.out.println("powB "+powB);
    		if(sumB<=C && powB + powA > res) {
				res = powB + powA;
				//System.out.println("발견");
				//System.out.println("sumB는 C넘지 않음");
				//System.out.println("res: "+res);
			}
    		return;
    	}
    	selected[cnt] = true;
    	subSet2(cnt+1,r, k);
    	selected[cnt] = false;
    	subSet2(cnt+1,r, k);
    }

    
}
/*
package s09.s0903;

import java.io.*;
import java.util.*;

public class SWEA_2115 {
    
    static int N, M, C;
    static int[][] honey;
    static int[][] maxProfit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수 
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            maxProfit = new int[N][N]; // 각 위치에서의 최대 수익 저장

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    honey[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 위치에서 최대 수익을 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    maxProfit[r][c] = calculateMaxProfit(r, c);
                }
            }

            // 두 구간이 겹치지 않게 최대 수익을 계산
            result = 0;
            findMaxCombinedProfit();

            System.out.println("#" + i + " " + result);
        }
    }

    // (r, c)부터 M개의 벌통을 선택했을 때의 최대 수익 계산
    public static int calculateMaxProfit(int r, int c) {
        int[] selectedHoney = new int[M];
        for (int i = 0; i < M; i++) {
            selectedHoney[i] = honey[r][c + i];
        }
        return getMaxProfit(selectedHoney, 0, 0, 0);
    }

    // 재귀적으로 최대 수익을 계산 (부분집합을 활용)
    public static int getMaxProfit(int[] honey, int idx, int currentSum, int currentProfit) {
        if (currentSum > C) {
            return 0;
        }
        if (idx == M) {
            return currentProfit;
        }
        // 선택하거나 선택하지 않거나
        int include = getMaxProfit(honey, idx + 1, currentSum + honey[idx], currentProfit + honey[idx] * honey[idx]);
        int exclude = getMaxProfit(honey, idx + 1, currentSum, currentProfit);
        return Math.max(include, exclude);
    }

    public static void findMaxCombinedProfit() {
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 <= N - M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    int startCol = (r1 == r2) ? c1 + M : 0;
                    for (int c2 = startCol; c2 <= N - M; c2++) {
                        result = Math.max(result, maxProfit[r1][c1] + maxProfit[r2][c2]);
                    }
                }
            }
        }
    }
}

 */


