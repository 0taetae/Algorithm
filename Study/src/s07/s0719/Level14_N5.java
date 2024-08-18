package s07.s0719;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException; 
//import java.util.StringTokenizer;
import java.util.Scanner;
public class Level14_N5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String n = sc.nextLine();
		String[] arr = n.split(" ");
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int count=0;
			String t = sc.next();
			System.out.println(t);
			for(int j=0;j<arr.length;j++) {
				if(t==arr[j]) {
					count++;
				}
				else {
					continue;
				}
			}
			//System.out.print(count+" ");
		}

	}

}
