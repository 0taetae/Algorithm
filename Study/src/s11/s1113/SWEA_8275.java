package s11.s1113;

import java.io.*;
import java.util.*;

public class SWEA_8275 {
	
	static int N,X,M;
	static int[][] note;
	static int[] selected;
	static boolean isOk;
	static int maxSum;
	static int[] res;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 우리 개수
			X = Integer.parseInt(st.nextToken());  // 최대 마리 수
			M = Integer.parseInt(st.nextToken());  // 기록 수 
			isOk = false;
			
			// 기록 
			note = new int[M][3];
			res = new int[N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				note[i][0] = l;
				note[i][1] = r;
				note[i][2] = s;
			}
			selected = new int[N+1];
			maxSum=0;
			perm(1);
			sb.append("#").append(tc).append(" ");
			if(isOk) {
				for(int i=1;i<=N;i++) {
					sb.append(res[i]).append(" ");
				}
			}else {
				sb.append(-1);
			}
			
			
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	// 중복 순열
	public static void perm(int cnt) {
		//System.out.println("순열 !!");
		
		if(cnt==N+1) {
			
			if(check()) {
				//System.out.println("통과------------------ ");
				isOk = true;
				int sum=0;
				for(int i=0;i<=N;i++) {
					sum+=selected[i];
					//System.out.print(selected[i]+" ");
				}
				//System.out.println();
				
				if(maxSum < sum) {
					maxSum = sum;
					for(int i=0;i<=N;i++) {
						res[i]=selected[i];
					}
				}
			}
			return;
		}
		
		
		for(int i=0;i<=X;i++) {
			selected[cnt] = i;
			perm(cnt+1);
		}
	}
	
	// 조건을 충족하는지 
	public static boolean check() {
		//System.out.println("확인 ");
		for(int i=0;i<M;i++) {
			int sum=0;
			for(int j=note[i][0];j<=note[i][1];j++) {
				sum+=selected[j];
			}
			if(sum!= note[i][2]) {
				//System.out.println("조건 만족 안해!!!!!!!!!!!");
				return false;
			}
		}
		return true;
	}

}
