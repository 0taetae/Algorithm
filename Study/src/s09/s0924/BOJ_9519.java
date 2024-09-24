package s09.s0924;

import java.io.*;
import java.util.*;

public class BOJ_9519 { 
	
	static int X;
	static ArrayList<String> lst = new ArrayList<String>();  // 문자열의 각 문자를 담은 리스트 
	static String str;
	static ArrayList<String> changelst = new ArrayList<String>();  // 섞은 문자열을 담은 리스트

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());  // 문자열을 섞을 횟수 
		str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			lst.add(str.substring(i,i+1));
		}
		changelst.add(String.join("", lst));  // 시작 문자열 넣기 
		
		int moveCnt=0;  // 옮겨야할 문자 개수
		if(str.length()%2==0) {  // 문자열 개수가 짝수인 경우
			moveCnt = str.length()/2-1;
		}else {  // 문자열 개수가 홀수인 경우 
			moveCnt = str.length()/2;
		}
		
		int cnt=0;
		boolean cal=false;  // X만큼 섞기 전에 주기 발견 
		while(cnt<X) {
			
			// 문자 옮기기 
			for(int i=2*moveCnt-1;i>=0;i-=2) {
				String move = lst.get(i);
				lst.remove(i);
				lst.add(move);
			}
			cnt++;
			if(check()) {  // 섞인 문자열이 처음 문자열과 같다면 
				cal=true;
				break;
			}
			changelst.add(String.join("", lst));  // 섞인 문자열을 넣기 
		}
		if(cal) {
			System.out.println(changelst.get(X%cnt));
		}else {
			System.out.println(changelst.get(changelst.size()-1));
		}

	}
	// 처음의 문자열과 같은지 확인
	static boolean check() {
		for(int i=0;i<str.length();i++) {
			if(!str.substring(i,i+1).equals(lst.get(i))) {
				return false;
			}
		}
		return true;
	}

}
