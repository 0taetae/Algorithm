package s08.s0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Balance {
	static int N, res;
	static int[] weight,sorted;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int T = 1 ; T<=tc ; T++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			sorted = new int[N];
			isSelected = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0 ; i < N ; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			res = 0;
			per(0);
			
			sb.append("#").append(T).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static void per(int cnt) {
		if(cnt == N) {
			bal(0,0,0);
		}
		for(int i=0;i<N;i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				sorted[cnt] = weight[i];
				per(cnt+1);
				isSelected[i] = false;
			}
		}
		
	}
	public static void bal(int cnt, int left, int right) {
		if(right>left) return;
		
		if(cnt==N) {
			res++;
			return;
		}
		bal(cnt+1, left, right+sorted[cnt]);
		bal(cnt+1, left+sorted[cnt], right);
	}
	
	
}


// 처음에는 최종 무게로 봤을 때 오른쪽 무게가 왼쪽 무게를 넘지만 않으면 된다고 생각했다. 


