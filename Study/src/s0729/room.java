package s0729;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class room {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];  // 회의실 사용표
		
		for(int i=0;i<N;i++) {
			int start = sc.nextInt();  // 회의 시작 시간
			int end = sc.nextInt();  // 회의 끝나는 시간

			arr[i][0] = start;
			arr[i][1] = end;
		}
		Arrays.sort(arr, new Comparator<int[]>() { 
		    @Override
		    public int compare(int[] o1, int[] o2) {  // 회의가 끝나는 시간을 기준으로 오름차순 정렬
		        if(o1[1]==o2[1]) {
		        	return o1[0]-o2[0];  // 끝나는 시간이 같으면 시작시간을 기준으로 오름차순 정렬
		        }
		        return o1[1]-o2[1];
		    }
		});
		
		int count =1;  // 첫번째 회의 포함, 회의실을 사용할 수 있는 회의의 개수 
		int check = arr[0][1];
		
		for(int i=1;i<N;i++) {  // 이전 회의의 끝나는 시간과 다음 회의 시작 시간 비교 
			if(arr[i][0]<check) {  // 회의실 사용 시간 겹칠 때 제외 
				continue;
			}
			else {
				check = arr[i][1];
				count++;
			}
		}
		System.out.println(count);

	}

}
