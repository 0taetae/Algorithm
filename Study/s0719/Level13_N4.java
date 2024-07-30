package s0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class LevelN13_N4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i]=n;
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			int ans = arr[i];
			bw.write(ans+"\n");
		}
		bw.close();

	}

}
