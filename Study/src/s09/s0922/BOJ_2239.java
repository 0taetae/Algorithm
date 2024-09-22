package s09.s0922;

import java.io.*;
import java.util.*;

public class BOJ_2239 {
	
	static int[][] board = new int[9][9];
	static boolean[][] visitedRow = new boolean[9][10];  // 몇번째 행, 해당 숫자가 있는지
	static boolean[][] visitedCol = new boolean[9][10];  // 몇번째 열, 해당 숫자가 있는지
	static boolean[][][] visited33 = new boolean[3][3][10];  // 3*3 영역에 해당 숫자가 있는지 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				board[i][j] = str.charAt(j)-'0';
				if (board[i][j] != 0) {
                    visitedRow[i][board[i][j]] = true;
                    visitedCol[j][board[i][j]] = true;
                    visited33[i / 3][j / 3][board[i][j]] = true;
                }
			}
		}
		
		check(0,0);
	}
	// 해당 열, 행에 없는 숫자 하나씩 넣어봄 -> 백트래킹 
	static void check(int r, int c) {
		if(c==9) {
			r++;
			c=0;
		}
		if(r==9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}
		if(board[r][c]==0) {
			for(int i=1;i<=9;i++) {
				if(!visitedRow[r][i] && !visitedCol[c][i] && !visited33[r/3][c/3][i]) {
					board[r][c] = i;
					visitedRow[r][i] = true;
					visitedCol[c][i] = true;
					visited33[r/3][c/3][i] = true;
					
					check(r,c+1);
					
					board[r][c] = 0;
					visitedRow[r][i] = false;
					visitedCol[c][i] = false;
					visited33[r/3][c/3][i] = false;
					
				}
			}
		}else {
			check(r,c+1);
		}
		
	}

}
