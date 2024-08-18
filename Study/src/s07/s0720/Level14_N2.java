package s07.s0720;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Level14_N2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arrn = new String[N];
		//String[] arrm = new String[M];
		
		for(int i=0;i<N;i++) {
			arrn[i] = br.readLine();
		}
		
		Arrays.sort(arrn);
		int count =0;
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			if(Arrays.binarySearch(arrn, str) < 0) continue; 
			else count++;
		}
		System.out.println(count);
		

	}

}
