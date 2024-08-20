package s0820;

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
			up=0;
			down=0;
			status=true;
			sum=0;
			for(int r=0;r<N;r++) {
				if(r==N-1) {
					sum += up*down;
					break;
				}
				if(status==false && arr[r]<arr[r+1]) {
					sum += up*down ;
					up=1;
					down=0;
					status = true;

				}else if(status==true && arr[r]>arr[r+1]) {
					status=false;
					down++;
				}
				else if(arr[r] < arr[r+1]) {
					status=true;
					
					up++;
				}else if(arr[r]> arr[r+1]) {
					status=false;
					down++;
				}
				
			}
			System.out.println("#"+i+" "+sum);
			
		}

	}

}
