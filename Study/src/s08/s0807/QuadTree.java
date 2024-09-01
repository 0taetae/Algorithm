package s08.s0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuadTree {
	static StringBuilder sb = new StringBuilder();
	static char[][] quadtree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		quadtree = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				quadtree[i][j] = str.charAt(j);
			}
		}
		
		part(0,0,N);
		System.out.println(sb);
	}
	
	// 해당 영역이 모두 같은 문자 인지 확인
	static boolean check(int row, int col, int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(quadtree[row][col]!=quadtree[i][j]) {
					return false;
				}
			}
		}
		return true;
		
	}
	static void part(int row, int col, int size) {
		// 문자 같으면 해당 문자 넣기
		if(check(row, col, size)) {
			if(quadtree[row][col]=='0') {
				sb.append('0');
			}
			else {
				sb.append('1');
			}
		}
		// 문자가 다르면 4분할, 해당 영역의 문자가 같은지 확인하고 다르면 분할하는 과정을 반복 
		else {
			sb.append('(');
			for(int i=row; i<row+size; i+=(size/2)) {
				for(int j=col; j<col+size; j+=(size/2)) {
					part(i, j, size/2);
				}
			}
			sb.append(')');
			
		}
	}
}


