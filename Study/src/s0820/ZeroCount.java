package s0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroCount {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt( br.readLine() );
		System.out.println( (N/5)+(N/25)+(N/125) );

	}

}
