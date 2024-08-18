package s0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProtectFilm {
	static int D, W, K;
	static int result;
	static int[][] film;
	static int[][] filmCopy;

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			filmCopy = new int[D][W];
			
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					film[r][c] = filmCopy[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			
			test(0, 0);
			sb.append("#").append(i).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);

	}
	public static void test(int r, int count) {
		if(check()) {
			result = Math.min(result, count);
			return;
		}
		for(int i=r;i<D;i++) {
			Arrays.fill(film[i], 0);
			test(i+1,count+1);
			Arrays.fill(film[i], 1);
			test(i+1,count+1);
			film[i] = Arrays.copyOf(filmCopy[i], W);
		}
	}
	public static boolean check() {
		for(int c=0;c<W;c++) {
			int count = 1;
			boolean isPass = false;
			for(int r=0;r<D-1;r++) {
				if(count == K) {
					isPass=true;
					break;
				}
				if(film[r][c] == film[r+1][c]) {
					count++;
				}
				// 같지 않으면 다시 세기 
				else {
					count = 1;
				}
			}
			if(!isPass) {
				return false;
			}
		}
		return true;
	}

}
