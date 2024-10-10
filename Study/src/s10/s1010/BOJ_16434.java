package s10.s1010;

import java.io.*;
import java.util.*;

public class BOJ_16434 {
	
	static int N, atk;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long start = 1;
		long end = Long.MAX_VALUE;
		long res = end;

		while (start <= end) {
			long mid = (start + end) / 2;

			if (check(mid)) { 
				res = mid; 
				end = mid - 1;
			} else {
				start = mid + 1; 
			}
		}

		System.out.println(res);
	}

	private static boolean check(long maxHp) {
		long curHP = maxHp;  // 용사의 현재 생명력
		long curAtk = atk;   // 용사의 현재 공격력 

		for (int i = 0; i < N; i++) {
			long t = arr[i][0]; 
			long a = arr[i][1];  // t=1, 몬스터의 공격력 
			long h = arr[i][2];  // t=1, 몬스터의 생명력 

			// 몬스터
			if (t == 1) {
				// 몬스터를 쓰러뜨리기 위한 용사의 공격 횟수
				long atkCnt = (h + curAtk - 1) / curAtk;  // 몬스터를 쓰러뜨리는 데 필요한 공격 횟수 (올림연산)
				long cnt = atkCnt - 1;  // 몬스터가 공격하는 횟수
				curHP -= cnt * a;  // 몬스터가 공격한 만큼 용사의 체력 감소

				// 용사가 죽음
				if (curHP <= 0) {
					return false;
				}
			}
			// 포션
			else if (t == 2) {
				curAtk += a;  // 용사의 공격력을 a만큼 증가
				curHP = Math.min(curHP + h, maxHp);  // 용사의 생명력 회복 
			}
		}

		return true; 
	}
}
