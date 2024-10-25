package s10.s1025;

import java.io.*;
import java.util.*;

public class BOJ_1759 {
	
	static int L,C;
	static ArrayList<String> vowel = new ArrayList<>(Arrays.asList("a","e","i","o","u"));  // 모음 리스트 
	static String[] arr;
	static String[] select;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());  // 암호로 사용된 알파벳 수
		C = Integer.parseInt(st.nextToken());  // 암호로 사용했을 법한 문자 개수
		arr = new String[C];  // 암호로 사용했을 법한 문자
		select = new String[L];  // 암호로 택한 알파벳
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		comb(0,0,0,0);
		
		
	}
	public static void comb(int idx, int start,int consonantCnt, int vowelCnt) {
		if(idx == L) {
			if(consonantCnt>=2 && vowelCnt>=1) {
				for(int i=0;i<L;i++) {
					System.out.print(select[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start;i<C;i++) {
			select[idx] = arr[i];
			if(vowel.contains(arr[i])) {
				vowelCnt++;
				comb(idx+1,i+1, consonantCnt, vowelCnt);
				vowelCnt--;
			}else {
				consonantCnt++;
				comb(idx+1,i+1, consonantCnt, vowelCnt);
				consonantCnt--;
			}
			
			
		}
	}

}
