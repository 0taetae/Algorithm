package s07.s0723;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Score{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		super();
	}
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		return name;
	}
	
}

public class k_e_m {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Score> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String name = sc.next();
			int kor = sc.nextInt();  // 내림차순
			int eng = sc.nextInt();  // 오름차순
			int math = sc.nextInt();  // 내림차순
			// 이름 오름차순
			list.add(new Score(name, kor, eng, math));
		}
		list.sort((a,b)->{
			if(a.getKor() > b.getKor()) return  -1;  // 내림차순
			else if(a.getKor() < b.getKor()) return 1;  // return 1일때 순서 뒤집기
			
			if(a.getEng()>b.getEng()) return 1;
			else if(a.getEng() < b.getEng()) return -1;

			if(a.getMath()>b.getMath()) return -1;
			else if(a.getMath()<b.getMath()) return 1;

			return a.toString().compareTo(b.toString());		
			});
		for(Score s :list) {
			System.out.println(s);
		}

	}

}
