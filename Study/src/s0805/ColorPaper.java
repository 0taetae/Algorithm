package s0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
	static int[][] paper;
	static int blue=0;
	static int white=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		part(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	// 해당 영역이 모두 같은 색인지 확인
	static boolean check(int row, int col, int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(paper[row][col]!=paper[i][j]) {
					return false;
				}
			}
		}
		return true;
		
	}
	static void part(int row, int col, int size) {
		// 색이 같으면 색종이 개수 세기
		if(check(row, col, size)) {
			if(paper[row][col]==1) {
				blue++;
			}
			else {
				white++;
			}
		}
		// 색이 다르면 4분할, 해당 영역의 색이 같은지 확인하고 다르면 분할하는 과정을 반복 
		else {
			for(int i=row; i<row+size; i+=(size/2)) {
				for(int j=col; j<col+size; j+=(size/2)) {
					part(i, j, size/2);
				}
			}
			
		}
	}
}
