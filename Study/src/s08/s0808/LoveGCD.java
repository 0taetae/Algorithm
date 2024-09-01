package s08.s0808;

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
		
		arrS(0,N-1);

	}
	public static int arrS(int start, int end) {
		if(start == end) return arr.get(start);
		
		return 0;
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
	/*
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
	}*/
	// gcd 구하기
	public static int GCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return GCD(num2, num1 % num2);
    }

}

/*
import java.io.*;
import java.util.*;

public class Main {

    static int sum;
    static LinkedList<Integer> room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        room = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            room.add(Integer.parseInt(st.nextToken()));
        }

        func(0, n-1);
        System.out.println(sum);
    }

    public static int func(int start, int end) {
        if(start == end) return room.get(start);
        else if(start+1 == end) return room.get(start) + room.get(end);

        int mid = (end - start + 1) / 2;
        int gcd = room.get(start);

        int leftSum = 0;
        for(int i = start; i < mid; i++) {
            gcd = gcd(gcd, room.get(i));
        }
        leftSum = gcd + func(start + mid, end);

        gcd = room.get(end);
        int rightSum = 0;
        for(int i = mid; i < end; i++) {
            gcd = gcd(gcd, room.get(i));
        }
        rightSum = gcd + func(start, start + mid - 1);

        return Math.max(leftSum, rightSum);
    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}*/





