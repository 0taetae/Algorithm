package s07.s0728;

/**
 * 직각삼각형 모양의 숫자 출력하는 클래스
 */
public class DigitTest1 {

	public static void main(String[] args) {
		int count = 0;// 도형에 출력할 숫자 변수

		// 5행 5열의 원리를 이용하여 직각삼각형 모양으로 숫자를 출력한다.
		// 첫행은 숫자 5개 출력하고 두번째 행부터 앞쪽열부터 공백문자를 하나씩 늘려서 출력한다.
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (j < i) {// 숫자 앞쪽 공백 출력 부분
					System.out.printf("%3s", " ");// 3칸의 너비로 공백 출력
				} else { // 숫자 출력 부분
					System.out.printf("%3d", ++count);// 3칸의 너비로 숫자 출력
				}
			}
			System.out.println();
		}
	}

}