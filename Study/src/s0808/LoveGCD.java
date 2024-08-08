package s0808;

import java.util.ArrayList;
import java.util.Scanner;

public class LoveGCD {
	
	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] visit;
	static ArrayList<Integer> larr = new ArrayList<>();
	static ArrayList<Integer> rarr = new ArrayList<>();
	static int gcd;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			arr.add(sc.nextInt());
		}

	}
	// 배열 S의 원소를 왼쪽부터 N/2개 선택
	public static void leftarr(int count) {
		for(int i=0;i<count;i++) {
			larr.get(arr.get(0));
			arr.remove(0);
		}
	}
	// 배열 S의 원소를 오른쪽부터 N/2개 선택
	public static void rightarr(int count) {
		for(int i=arr.size()-1;i>=arr.size()-count;i--) {
			larr.get(arr.get(arr.size()-1));
			arr.remove(arr.size()-1);
		}
	}
	// 선택한 원소들의 GCD 구함
	public static void GCD(ArrayList<Integer> check) {
		for(int i=0;i<check.size()-2;i++) {
			if(check.get(i)>check.get(i+1)) {
				for(int j=check.get(i+1);j>=1;j++) {
					if(check.get(i)%j==0 && check.get(i+1)%j==0) {
						gcd = j;
						break;
					}
				}
			}
		}
	}

}
