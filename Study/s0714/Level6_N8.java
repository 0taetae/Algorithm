package s0714;

import java.util.Scanner;

public class Level6_N8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum=0;
		double div =0;
		for(int i=0; i<20;i++) {
			String title = sc.next();
			double score = sc.nextDouble();  // 학점
			String grade = sc.next();  //등급 
			if (grade!="P") {
				switch(grade) {
					case "A+": 
						sum+=score*4.5;
						div+=score;
						break;
					case "A0": 
						sum+=score*4.0; 
						div+=score;
						break;
					case "B+": 
						sum+=score*3.5;
						div+=score;
						break;
					case "B0": 
						sum+=score*3.0; 
						div+=score;
						break;
					case "C+": 
						sum+=score*2.5; 
						div+=score;
						break;
					case "C0": 
						sum+=score*2.0; 
						div+=score;
						break;
					case "D+": 
						sum+=score*1.5; 
						div+=score;
						break;
					case "D0": 
						sum+=score*1.0; 
						div+=score;
						break;
					case "F" : 
						sum+=score*0.0; 
						div+=score;
						break;
					case "P":
						sum+=0;
						div+=0;
				}
			}
			
		}
		System.out.println(sum/div);
		sc.close();

	}

}
