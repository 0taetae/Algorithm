package s11.s1108;

import java.io.*;
import java.util.*;

public class BOJ_16935 {
	
	static int N,M,R;
	static int[][] arr;
	static int height,width;
	//static int[] com;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		height = N;
		width = M;
		//com = new int[R];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int com = Integer.parseInt(st.nextToken());
			switch(com) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		for(int r=0;r<height;r++) {
			for(int c=0;c<width;c++) {
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
	}
	
	// 상하 반전
	private static void one() {
		for(int c=0;c<width;c++) {
			for(int r=0;r<height/2;r++) {
				int temp = arr[r][c];
				arr[r][c] = arr[height-1-r][c];
				arr[height-1-r][c] = temp;
			}
		}
		
	}
	
	// 좌우 반전
	private static void two() {
		for(int r=0;r<height;r++) {
			for(int c=0;c<width/2;c++) {
				int temp = arr[r][c];
				arr[r][c] = arr[r][width-1-c];
				arr[r][width-1-c] = temp;
			}
		}
	}
	
	// 오른쪽으로 90도 회전
	private static void three() {
		int newHeight = width;
		int newWidth = height;
		
		int[][] temp = new int[newHeight][newWidth];
		for(int r=0;r<newHeight;r++) {
			for(int c=0;c<newWidth;c++) {
				temp[r][c] = arr[height-1-c][r];
			}
		}
		arr = new int[newHeight][newWidth];
		for(int r=0;r<newHeight;r++) {
			for(int c=0;c<newWidth;c++) {
				arr[r][c] = temp[r][c];
			}
		}
		height = newHeight ;
		width = newWidth;
	}
	
	// 왼쪽으로 90도 회전
	private static void four() {
		int newHeight = width;
		int newWidth = height;
		int[][] temp = new int[newHeight][newWidth];
		
		for(int r=0;r<newHeight;r++) {
			for(int c=0;c<newWidth;c++) {
				temp[r][c] = arr[c][width-1-r];
			}
		}
		
		
		arr = new int[newHeight][newWidth];
		for(int r=0;r<newHeight;r++) {
			for(int c=0;c<newWidth;c++) {
				arr[r][c] = temp[r][c];
			}
		}
		height = newHeight ;
		width = newWidth;
		
	}
	
	// 부분배열
	// 1 2  => 4 1
	// 4 3     3 2
	private static void five() {
		// 1번 배열 복사
		int[][] temp = new int[height/2][width/2];
		for(int r=0;r<height/2;r++) {
			for(int c=0;c<width/2;c++) {
				temp[r][c] = arr[r][c];
			}
		}
		// 4번 배열 1번 위치로 이동
		for(int c=0;c<width/2;c++) {
			for(int r=0;r<height/2;r++) {
				arr[r][c] = arr[r+(height/2)][c];
			}
		}
		
		// 3번 배열 4번 위치로 이동
		for(int r=height/2;r<height;r++) {
			for(int c=0;c<width/2;c++) {
				arr[r][c] = arr[r][c+(width/2)];
			}
		}
		
		// 2번 배열 3번 위치로 이동
		for(int c=width/2;c<width;c++) {
			for(int r=height/2;r<height;r++) {
				arr[r][c] = arr[r-(height/2)][c];
			}
		}
		
		// 1번 배열 2번 위치로 이동 
		for(int r=0;r<height/2;r++) {
			for(int c=width/2;c<width;c++) {
				arr[r][c] = temp[r][c-(width/2)];
			}
		}
	}
	
	// 부분배열
	// 1 2 => 2 3
	// 4 3    1 4
	private static void six() {
		// 1번 배열 복사
		int[][] temp = new int[height/2][width/2];
		for(int r=0;r<height/2;r++) {
			for(int c=0;c<width/2;c++) {
				temp[r][c] = arr[r][c];
			}
		}
		
		// 2번 배열 1번 위치로 이동
		for(int r=0;r<height/2;r++) {
			for(int c=0;c<width/2;c++) {
				arr[r][c] = arr[r][width/2+c];
			}
		}
		
		// 3번 배열 2번 위치로 이동
		for(int c=width/2;c<width;c++) {
			for(int r=0;r<height/2;r++) {
				arr[r][c] = arr[height/2+r][c];
			}
		}
		
		// 4번 배열 3번 위치로 이동
		for(int r=height/2;r<height;r++) {
			for(int c=width/2;c<width;c++) {
				arr[r][c] = arr[r][c-width/2];
			}
		}
		
		// 1번 배열 4번 위치로 이동 
		for(int c=0;c<width/2;c++) {
			for(int r=height/2;r<height;r++) {
				arr[r][c] = temp[r-height/2][c];
			}
		}
	}

}
