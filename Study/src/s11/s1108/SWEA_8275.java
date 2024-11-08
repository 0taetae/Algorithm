package s11.s1108;

import java.io.*;
import java.util.*;

public class SWEA_8275 {
	
	// 햄스터 우리 개수 : N
	// 각 우리의 햄스터 수 : X이하
	// 기록 수 : M
	// l번 우리에서 r번 우리까지의 햄스터 수 -> s 마리
	
	static int N,X,M; 
	static int[][] rec;  // 기록
	static int[] cage;  // 각 우리의 햄스터 수
	static boolean isOk;  // 조건을 만족할 수 있는지 
	static int res;  // 햄스터 수의 합
	static int[] ans;  // 정답 배열
	
	// 가능한 방법이 여러 가지 일 경우, 햄스터 수가 가장 많은 것
	// 가능한 방법이 여러가지 일 경우, 사전순으로 가장 앞선 것 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			res = 0;
			isOk = false;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 햄스터 우리 수
			X = Integer.parseInt(st.nextToken());  // 각 우리에 최대 X마리
			M = Integer.parseInt(st.nextToken());  // 기록수 
			rec = new int[M][3];
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				// a번 우리에서 b번 우리까지의 햄스터 수 s
				rec[i][0] = Integer.parseInt(st.nextToken());
				rec[i][1] = Integer.parseInt(st.nextToken());
				rec[i][2] = Integer.parseInt(st.nextToken());
				
			}
			cage = new int[N+1];
			ans = new int[N+1];
			
			perm(1);
			
			if(!isOk) {
				System.out.println("#"+tc +" "+(-1));
			}else {
				System.out.print("#"+tc +" ");
				for(int idx=1;idx<=N;idx++) {
					System.out.print(ans[idx]+" ");
				}
				System.out.println();
			}
		}
		
	}
	// 중복순열 
	public static void perm(int idx) {
		
		if(idx==N+1) {
			// 조건을 충족하는지 확인 
			if(check()) {
				isOk = true;
				int sum=0;
				for(int i=1;i<=N;i++) {
					sum+=cage[i];
				}
				// 조건을 충족하는 경우 중, 햄스터 수가 많은 경우 
				if(res<sum) {
					for(int i=1;i<=N;i++) {
						ans[i]=cage[i];
					}
					res = sum;
				}
			}
			return;
		}
		for(int i=0;i<=X;i++) {
			cage[idx] = i;
			perm(idx+1);
		}
	}
	
	// 조건 충족 확인 
	public static boolean check() {
		int res = 0;
		for(int i=0;i<M;i++) {
			int sum=0;
			for(int j=rec[i][0];j<=rec[i][1];j++) {
				sum+=cage[j];
			}
			if(sum==rec[i][2]) {
				res++;
			}
		}
		if(res==M) return true;
		return false;
	}

}
