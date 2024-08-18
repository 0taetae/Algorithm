package s07.s0720;
import java.io.*;
import java.util.*;

public class Level14_N3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String name = st2.nextToken();
			String op = st2.nextToken();
			if(op.equals("enter")) set.add(name);
			if(op.equals("leave")) set.remove(name);
		}

		ArrayList<String> sorted = new ArrayList<String>(set);
		Collections.sort(sorted);
		
		for(int i = sorted.size()-1;  i >= 0; i--){
			bw.write(sorted.get(i) + "\n");
        }
		bw.close();

	}

}
