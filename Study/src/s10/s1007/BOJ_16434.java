package s10.s1007;

import java.io.*;
import java.util.*;

public class BOJ_16434 {
	static int N, hAtk;
	static int[][] room;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 방의 개수
		hAtk = Integer.parseInt(st.nextToken());  // 용사의 공격력
		room = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());  
			// t - 1이면, 공격력이 a이고, 생명력이 h인 몬스터가 있음을 나타냄, 
			//2이면, 용사의 공격력을 a만큼 증가시켜주고, 용사의 현재 생명력을 h만큼 회복시켜줌
			int a = Integer.parseInt(st.nextToken());  // a
			int h = Integer.parseInt(st.nextToken());  // h
			room[i][0] = t;
			room[i][1] = a;
			room[i][2] = h;
		}
		int start =1; 
		int end = Integer.MAX_VALUE;
		int mid=0;
		while(start <= end) {
			mid = (start + end)/2;
			if(check(mid)) {
				end = mid-1;
			}else {
				start = mid +1;
			}
		}
		System.out.println(mid);
	}
	static boolean check(int maxHP) {
		int curhAtk = hAtk;  // 용사의 공격력
		int curHP = maxHP;  // 용사의 최대 생명력
		
		for(int i=0;i<N;i++) {
			int t = room[i][0];
			int a = room[i][1];
			int h = room[i][2];
			
			if(t==1) {
				if((h+curhAtk-1)/curhAtk > (curHP + a - 1)/a){
					return false;
				}
				curHP -= a * ((h+curhAtk-1)/curhAtk -1 ); 
			}
			else if(t==2) {
				curhAtk += a;  // 용사의 공격력 a만큼 증가
				curHP = Math.min(maxHP, curHP+h);  // 용사의 현재 생명력을 h만큼 회복 , 최대 생명력은 넘지 않게 
			}
		}
		return true;
	}

}
