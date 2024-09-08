package s09.s0907;

import java.io.*;
import java.util.*;

public class BOJ_17281_solution {

	static int[] order = new int[9];  // 타순(타자가 타석에 서는 순서)
    static int[][] score;  // 각 선수가 각 이닝에서 얻은 결과
    static boolean[] isSelected = new boolean[9];  // 타순을 정할 때 중복을 방지하는 배열
    static int N;  // 이닝 수
    static int maxScore;  // 최대 득점
    static int startPlayer, scoreSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        score = new int[N][9];
        
        // 각 이닝마다 선수의 결과를 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        maxScore = 0;
        order[3] = 0;  // 1번 선수를 4번 타자로 고정
        isSelected[0] = true;  // 1번 선수는 선택되었으므로 true로 설정
        
        perm(0);  // 타순을 결정하는 순열 생성
        
        System.out.println(maxScore);  // 최종 최대 득점 출력
    }
    
    // 타순을 결정하는 순열을 생성하는 함수
    static void perm(int cnt) {
        if (cnt == 9) {  // 타순이 모두 결정되면
        	scoreSum = 0;
            startPlayer = 0;  // 첫 번째 타자는 0번 선수부터 시작
            
            // N이닝 동안 게임을 진행
            for (int inning = 0; inning < N; inning++) {
                game(inning);
            }
            maxScore = Math.max(maxScore, scoreSum);  // 게임을 시뮬레이션하여 최대 점수 갱신
            return;
        }
        
        if (cnt == 3) {  // 4번 타자는 이미 고정이므로 스킵
            perm(cnt + 1);
            return;
        }
        
        for (int i = 1; i < 9; i++) {  // 1번 선수는 이미 선택되었으므로 2번 선수부터 순열을 생성
            if (!isSelected[i]) {
                isSelected[i] = true;
                order[cnt] = i;  // 현재 순서에 i번 선수를 배치
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
    
    // 게임을 시뮬레이션하여 점수를 계산하는 함수
    static void game(int inning) {
    	int outCnt = 0;
        boolean[] state = new boolean[3];  // 1루, 2루, 3루 주자 상태
        
        // 3아웃이 될 때까지 계속 타격
        while (outCnt < 3) {
            int result = score[inning][order[startPlayer]];  // 현재 타자의 결과 가져오기
            
            if (result == 0) {  // 아웃
                outCnt++;
            } else if (result == 1) {  // 안타
                scoreSum += move(state, 1);  
            } else if (result == 2) {  // 2루타
                scoreSum += move(state, 2);  
            } else if (result == 3) {  // 3루타
                scoreSum += move(state, 3);  
            } else if (result == 4) {  // 홈런
                scoreSum += move(state, 4) + 1;  
            }
            
            startPlayer = (startPlayer + 1) % 9;  // 다음 타자로 순환
        }
    }
    
    // 주자를 이동시키고 득점을 반환
    static int move(boolean[] state, int loc) {
        int score = 0;
        
        // 홈런의 경우 
        if (loc == 4) {
            score += (state[0] ? 1 : 0) + (state[1] ? 1 : 0) + (state[2] ? 1 : 0);  // 모든 주자가 득점
            state[0] = state[1] = state[2] = false;  // 모든 루 초기화
        }
        // 안타, 2루타, 3루타 
        else {
            for (int i = 2; i >= 0; i--) {
                if (state[i]) {
                    if (i +loc >= 3) {  // 홈에 들어오면 득점
                        score++;
                    } else {
                    	state[i + loc] = true;  // 주자 이동
                    }
                    state[i] = false;
                }
            }
            if (loc < 4) state[loc - 1] = true;  // 타자는 해당 루로 이동
        }
        
        return score;
    }

}
