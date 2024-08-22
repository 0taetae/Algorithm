package s0822;


import java.util.Scanner;

// 같은 행에 퀸을 두지 않는 방식
public class NQueen {
	
	static int N, ans;
	static int[] col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		ans=0;
		setQueens(1);
		System.out.println(ans);
		
	}
	public static void setQueens(int rowNo) {
		
		// 직전 요소에서 놓을 수 없는 경우 
		if(!isAvailable(rowNo-1)) return;
		if(rowNo>N) {
			ans++;
			return;
		}
		
		for(int c=1;c<=N;c++) {
			col[rowNo] = c;
			setQueens(rowNo+1);
		}
	}
	private static boolean isAvailable(int rowNo) {
		// 이전 요소중에 같은 열에 있는 경우, 대각선에 존재하는 경우 false 리턴
		for(int k=1;k<rowNo;k++) {
			if(col[rowNo]==col[k] || rowNo-k == Math.abs(col[rowNo]-col[k])) return false;
		}
		return true;
	}
	

}
