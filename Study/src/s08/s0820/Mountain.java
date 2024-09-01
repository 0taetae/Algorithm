package s08.s0820;

import java.util.Scanner;

public class Mountain {
	static int[] arr;
	static boolean status;
	static int up;
	static int down;
	static int sum;

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			arr = new int[N];
			for(int r=0;r<N;r++) {
				arr[r] = sc.nextInt();
			}
			int up=0;  // 왼쪽 높이 개수
			int down=0;  // 오른쪽 높이 개수
			boolean status=true;  // 높이 증감 상태 
			int sum=0;  // 구간 개수 
			
			for(int r=0;r<N;r++) {
				if(r==N-1) {  // 마지막 높이가 구간에 해당되는 경우를 고려
					sum += up*down;
					break;
				}if(status==false && arr[r]<arr[r+1]) {  // 이전까지 감소 & 이후에는 증가 -> 구간 개수 구하기 
					sum += up*down ;
					up=1;
					down=0;
					status = true;
				}else if(status==true && arr[r]>arr[r+1]) {  // 이전까지 증가 & 이후에는 감소 -> 우뚝 선 산
					status=false;
					down++;
				}else if(arr[r] < arr[r+1]) {  // 증가하는 구간
					status=true;
					up++;
				}else if(arr[r]> arr[r+1]) {  // 감소하는 구간
					status=false;
					down++;
				}
				
			}
			System.out.println("#"+i+" "+sum);
			
		}

	}

}
