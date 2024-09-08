package s09.s0907;

import java.io.*;
import java.util.*;

public class BOJ_17281 {

    static int[] order = new int[9];  // 타순(타자가 타석에 서는 순서)
    static int[][] score;  // 각 선수가 각 이닝에서 얻은 결과
    static boolean[] isSelected = new boolean[9];  // 타순을 정할 때 중복을 방지하는 배열
    static int N;  // 이닝 수
    static int maxScore;  // 최대 득점
    static int startPlayer, scoreSum;
    static boolean[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        score = new int[N][9];
        
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
        
        System.out.println(maxScore);  // 최대 득점
    }
    
    // 타순을 결정하는 순열
    static void perm(int cnt) {
        if (cnt == 9) { 
        	scoreSum = 0;
            startPlayer = 0;  // 첫 번째 타자는 0번 선수부터 시작
            
            // N이닝 동안 게임을 진행
            for (int inning = 0; inning < N; inning++) {
                game(inning);
            }
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }
        
        if (cnt == 3) {  // 4번 타자는 고정
            perm(cnt + 1);
            return;
        }
        
        for (int i = 1; i < 9; i++) {  // 1번 선수는 이미 선택되었으므로 2번 선수부터 순열을 생성
            if (!isSelected[i]) {
                isSelected[i] = true;
                order[cnt] = i;  
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
    
    // 각 이닝 진행 
    static void game(int inning) {
    	int outCnt=0;
    	state = new boolean[3]; // 1,2,3루에 주자 유무
    	
    	// 3아웃이면 이닝 종료
    	while(outCnt<3) {
    		int res = score[inning][order[startPlayer]];
    		// 아웃
    		if(res==0) {
    			outCnt++;
    		}
    		// 안타
    		else if(res ==1) {
    			scoreSum += move(1);
    		}
    		// 2루타
    		else if(res==2) {
    			scoreSum += move(2);
    		}
    		// 3루타
    		else if(res==3) {
    			scoreSum += move(3);
    		}
    		else if(res==4) {
    			scoreSum += move(4) + 1;
    		}
    		startPlayer = (startPlayer+1) % 9; // 9번 타자 다음 1번 타자로 
    		
    	}
    }
    
    // 주자를 이동
    static int move(int loc) {
        int score=0; 
        // 홈런인 경우, 모든 주자가 홈으로 들어옴 
        if(loc==4) {
        	// 1루에 주자가 있는 경우
        	if(state[0]) {
        		score++;
        		state[0] = false;  // 초기화
        	}
        	// 2루에 주자가 있는 경우
        	if(state[1]) {
        		score++;
        		state[1] = false;
        	}
        	// 3루에 주자가 있는 경우 
        	if(state[2]) {
        		score++;
        		state[2] = false;
        	}
        }
        // 3루에 있는 주자부터 차례로 루로 이동 
        else {
        	for(int i=2;i>=0;i--) {
        		if(state[i]) {
        			// 홈에 도착
        			if(i+loc >=3) {
        				score++;
        			}
        			else { // 상태 업데이트
        				state[i+loc] = true;
        			}
        			// 초기화
        			state[i] = false;
        		}
        	}
        	state[loc-1] = true;  // 해당 타자 해당 루로 이동
        }
        
        return score;
    }
}

