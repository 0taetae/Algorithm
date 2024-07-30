package s0728;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		int target = 5 / 2; // 모양이 반전되는 목표개수 변수
		int blank = 0; // 공백출력 카운트 변수
		boolean isIncrease = true; // 공백증가여부 변수
		int no = 1; // 출력 숫자 변수

		// 마지막 숫자 출력까지 반복
		while (no <= 17) {
			for (int j = 0; j < blank; ++j) { // 숫자 앞쪽 공백 출력 부분
				System.out.printf("%3s", " "); // 3칸의 너비로 공백 출력
			}
			for (int j = 0; j < 5 - 2 * blank; ++j) { // 숫자 출력 부분
				System.out.printf("%3d", no++); // 3칸의 너비로 숫자 출력
			}
			System.out.println();
			// 공백증가모드 이면 카운트 증가 아니면 카운트 감소 처리
			if (isIncrease) {
				++blank;
			} else {
				--blank;
			}

			if (blank == target) { // 공백카운트가 반전이 되는 목표개수와 일치하면 공백감소여부로 변경
				isIncrease = false;
			}
		}

	}
}