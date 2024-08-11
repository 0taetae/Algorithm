package s0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LoveGCD {
	
	static int N;
	static int[] arr;
	static int lsum;
	static int rsum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		larrS(0,N-1);
		rarrS(0,N-1);
		
		System.out.println(Math.max(lsum, rsum));

	}
	public static int larrS(int start, int end) {
		if(start == end) {
			return arr[start];
		}
		int mid = (end-start+1)/2;
		// 왼쪽
		int lgcd = arr[start];
		for(int i=start; i<=start+mid-1;i++) {
			lgcd = gcd(lgcd,arr[i]);
		}
		lsum = lgcd + larrS(start+mid,end);
		return lsum;
		
		
	}
	public static int rarrS(int start, int end) {
		if(start == end) {
			return arr[start];
		}
		int mid = (end-start+1)/2;
		
		// 오른쪽
		int rgcd = arr[end];
		for(int i=0; i<=end;i++) {
			rgcd = gcd(rgcd,arr[i]);
		}
		rsum = rgcd+ rarrS(start,start+mid-1);
		return rsum;
		
	}
	
	// gcd 구하기
	public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

}

/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] nums;
	
	public static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(cut(0,n-1));
		
	}
	
	public static int cut(int start, int end) {
		if(start == end) {
			return nums[start];
		}
		int mid = (end-start+1)/2;
		// 왼쪽
		int leftSum = 0;
		int index = start;
		int c = nums[start];
		while(index <= start+mid-1) {
			c = gcd(c,nums[index++]);
		}
		leftSum = c + cut(start+mid,end);
		
		// 오른쪽
		int rightSum = 0;
		c = nums[end];
		while(index <= end) {
			c = gcd(c,nums[index++]);
		}
		rightSum = c+ cut(start,start+mid-1);
		
		return Math.max(leftSum, rightSum);
		
		
		
	}
	// 유클리드 호제법
	public static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b,a%b);
	}
	
}
 */
/*
문제를 이해하기가 좀 힘들었음

1.한쪽 방향으로 쭉 가는게 아닌 한번 자르고 나면 다시 양쪽 중 하나를 선택 가능

1. 왼쪽은 홀수일때 2로나누고 .5를 버리고 오른쪽은 .5를 더해서 n/2+1로 확인함

1번 조건에서 쭉 가는줄 알고 2시간동안 저렇게 하다가 싹 갈아엎고 1번조건에 맞춰서함, 하다가 또 2번조건을 몰라서 틀리다가 고침

최대공약수는 유클리드호제법을 사용하며 2개씩 체크하고 gcd를 저장하면서 다음 인덱스와 체크해서 for문을 다 돌리는거보다 시간상 효율적이었던거 같고 함수 내에서는 단계별로 왼쪽 오른쪽 모두를 체크하며 확인했다. 재귀함수의 형태를 만드는데 애를 먹어서 구글링 해서 참고를 좀 하고 기존에 리턴값을 void로 하려했던걸 int형으로 바꿔서 풀었다.

순수 본인힘으로 푼건 아니라서 다음에 까먹을때 쯤 다시 한번 풀어봐야겠다.*/




