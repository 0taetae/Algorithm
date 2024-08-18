package s07.s0728;

import java.util.Scanner;

/**
 * 가위,바위,보 게임을 하는 클래스
 */
public class GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 로컬 컴퓨터로 수행시 주석을 제거하고, 아래 라인을 주석처리하여 직접 키보드 입력으로 실행하세요.
		// 게임 메뉴 출력
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");

		int menu = sc.nextInt(); // 사용자가 선택한 메뉴 변수
		int comWin = 0; // 컴퓨터가 승리한 카운트 변수
		int userWin = 0; // 사용자가 승리한 카운트 변수
		int totalCnt = 0; // 총 치뤄야 하는 게임 카운트 변수
		int winCnt = 0; // 승리조건을 충족하는 카운트 변수
		int gameCnt = 0; // 진행중인 게임 카운트 변수
		int comNo = 0; // 컴퓨터가 선택한 가위,바위,보 숫자
		int userNo = 0; // 사용자가 선택한 가위,바위,보 숫자

		// 사용자가 선택한 메뉴에 따라 총치뤄야하는 게임 카운트와 승리조건을 충족하는 카운트를 결정한다.
		if (menu == 1) {
			totalCnt = 5;
			winCnt = 3;
		} else if (menu == 2) {
			totalCnt = 3;
			winCnt = 2;
		} else {
			totalCnt = 1;
			winCnt = 1;
		}

		// 진행중인 게임 횟수가 총 게임 카운트를 넘지 않으며 컴퓨터,사용자의 승리 카운트가 승리조건을 만족하지 못한다면 반복
		while (gameCnt++ < totalCnt && (comWin < winCnt && userWin < winCnt)) {
			System.out.println("가위바위보 중 하나 입력: ");
			comNo = (int) (Math.random() * 3) + 1; // 난수로 컴퓨터 가위,바위,보 선택
			userNo = sc.nextInt(); // 입력으로 사용자 가위,바위,보 선택

			// 컴퓨터와 사용자가 선택한 가위,바위,보 여부에 따라 이겼을 경우에만 해당 승리 카운트 증가
			// 사용자 입장에서 승/패/무승부 결과 출력
			if (comNo == 1) { // 컴퓨터가 가위를 선택했을 경우
				if (userNo == 1) {
					System.out.println("비겼습니다.");
				} else if (userNo == 2) {
					System.out.println("이겼습니다.");
					userWin++;
				} else {
					System.out.println("졌습니다.");
					comWin++;
				}
			} else if (comNo == 2) { // 컴퓨터가 바위를 선택했을 경우
				if (userNo == 1) {
					System.out.println("졌습니다.");
					comWin++;
				} else if (userNo == 2) {
					System.out.println("비겼습니다.");
				} else {
					System.out.println("이겼습니다.");
					userWin++;
				}
			} else { // 컴퓨터가 보를 선택했을 경우
				if (userNo == 1) {
					System.out.println("이겼습니다.");
					userWin++;
				} else if (userNo == 2) {
					System.out.println("졌습니다.");
					comWin++;
				} else {
					System.out.println("비겼습니다.");
				}
			}
		}

		// 사용자 승리횟수와 컴퓨터 승리횟수 비교하여 최종 결과 출력
		if (userWin > comWin) {
			System.out.println("### 사용자 승!!!");
		} else if (userWin < comWin) {
			System.out.println("### 컴퓨터 승!!!");
		} else {
			System.out.println("### 무승부!!!");
		}
		sc.close();
	}
}
