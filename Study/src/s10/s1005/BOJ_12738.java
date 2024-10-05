package s10.s1005;

import java.io.*;
import java.util.*;

public class BOJ_12738 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			int cur = arr[i];
			
			int idx = Collections.binarySearch(lst, cur);
			
			if(idx <0) {
				idx = - (idx + 1);
			}
			
			if(idx < lst.size()) {
				lst.set(idx, cur); // idx 번째에 있는 요소를 cur로 대체 
			}else {
				lst.add(cur);
			}
		}
		System.out.println(lst.size());
	}

}
