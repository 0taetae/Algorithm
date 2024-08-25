package s0825;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		int N = 20;
		Queue<int[]> queue = new ArrayDeque<>();  // 사람의 번호, 받아야 하는 마이쮸 개수 -> 큐에 넣어서 관리
		int person = 1;
		queue.offer(new int[] {person, 1});
		
		while(N>0) {
			int[] p = queue.poll();
			int availableCnt = N >=p[1] ? p[1] : N;
			N -= availableCnt;
			if(N==0) { // 마지막 마이쮸를 받아가는 상황
				System.out.println("마지막 마이쮸를 포함해서 가져가는 사람은 "+p[0]+"번이며 "+availableCnt+"만큼 가져갑니다.");
			}else {
				System.out.println(p[0]+"번의 사람이 "+availableCnt+"만큼 가져갑니다.");
				p[1]++; // 받을 마이쮸 개수 증가
				queue.offer(p);
				queue.offer(new int[] {++person,1});
			}
		}
		

	}

}
