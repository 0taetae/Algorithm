package s11.s1105;

import java.io.*;
import java.util.*;

public class BOJ_1911 {

	static int N, L;

	static class Info {
		int left, right;

		Info(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static ArrayList<Info> list = new ArrayList<>(); // 물웅덩이 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물웅덩이 수
		L = Integer.parseInt(st.nextToken()); // 널빤지 길이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			list.add(new Info(a, b));
		}
		Collections.sort(list, (o1, o2) -> (o1.left - o2.left));
		int res = 0; // 필요한 널빤지 수
		int len = 0; // 위치
		for (int i = 0; i < N; i++) {
			if (len <= list.get(i).left) {
				len = list.get(i).left;
			}

			while (true) {
				if (len > list.get(i).right) {
					break;
				}
				len += L;
				res++;
			}
		}
		System.out.println(res);

	}

}
