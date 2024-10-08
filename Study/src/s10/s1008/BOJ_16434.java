package s10.s1008;

import java.io.*;
import java.util.*;

public class BOJ_16434 {
	/*
	maxHp : 용사의 최대 생명력, 1이상, 던전에 들어간 이후로 변하지 않음
	curHp : 현자 용사의 생명력, 던전에 들어가기전에는 mapHp>=curHp
	atk : 용사의 공격력
	방 - 포션 or 몬스터(몬스터를 쓰러트려야 다음방으로 이동 가능)
	몬스터가 있는 방 - 1. 용사의 공격력만큼 몬스터의 생명력을 깎음 2. 몬스터의 생명력이 0 이하이면 전투 종료, 용사는 다음 방으로 이동 3. 몬스터의 공격력만큼 용사의 생명력을 깎음
					4. 용사의 생명력이 0이하 -> 전투 종료, 용사 사망
					5. 다시 1부터 진행 
	포션이 있는 방 - 현재 용사의 생명력이 일정량 회복, 공격력도 일정량 증가
				회복된 생명력이 > mapHp -> curHp == maxHp
	 */
	
	static int N, atk;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		arr = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long start = 1;
		long end = Long.MAX_VALUE;
		long mid=0;
		while(start<=end) {
			mid = (start + end)/2;
			
			if(check(mid)) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(mid);
		
		
		

	}

	private static boolean check(long maxHp) {
		long curHP = maxHp;  // 용사의 현재 생명력
		long curAtk = atk;
		
		for(int i=0;i<N;i++) {
			long t = arr[i][0];  
			long a = arr[i][1];  // t=1, 몬스터의 공격력
			long h = arr[i][2];  // t=1, 몬스터의 생명력
			
			// 몬스터
			if(t==1) {
				boolean isOk = false;
				while(true) {
					h -= curAtk;
					if(h<0) {
						isOk = true;
						break;
					}
					curHP -= a;
					if(curHP <0) {
						return false;
					}
				}
				if(isOk) {
					continue;
				}
			}
			// 포션
			else if(t==2) {
				curAtk+=a;  // 용사의 공격력을 a만큼 증가
				curHP = Math.min(curHP+h, maxHp);  // 용사의 현재 생명력을 h만큼 회복 
			}
		}
		
		return true;
	}

}
