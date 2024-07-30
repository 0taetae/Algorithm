package s0728;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t <= TC; t++){
			int N = sc.nextInt();					// 신도시 부지의 크기 변수	
			char[][] area=new char[N][N];			// 신도시 부지 정보를 저장하는 2차원 배열
			// 신도시 부지 정보를 입력받아 저장한다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {     	//신도시 부지의 모든 구획을 검색
				for(int j=0; j<N; j++) {
					int bCount=0;			// 가능한 빌딩 크기 변수
					boolean isPark=false;	// 8방에 공원이 있는 지 여부 변수
					
					if(area[i][j]=='B')	{   // 현구획이 빌딩이면
						// 8방이 경계내에 있고  해당 방향이 공원(G)인지 확인
						if(i-1>=0 && area[i-1][j]=='G') 				isPark=true; //상 
						else if(i-1>=0 && j+1<N && area[i-1][j+1]=='G')	isPark=true; //우상
						else if(j+1<N && area[i][j+1]=='G')				isPark=true; //우
						else if(i+1<N && j+1<N &&area[i+1][j+1]=='G')	isPark=true; //우하
						else if(i+1<N && area[i+1][j]=='G')				isPark=true; //하
						else if(i+1<N && j-1>=0 && area[i+1][j-1]=='G')	isPark=true; //좌하
						else if(j-1>=0 && area[i][j-1]=='G')			isPark=true; //좌
						else if(i-1>=0 && j-1>=0 && area[i-1][j-1]=='G')isPark=true; //좌상

						if(!isPark){				// 8방 내에 공원이 없다면  가로행, 세로열에 있는 B구획을 count
							for(int k=0; k<N; k++){ // 세로열 B구획 세기
								if(area[k][j]=='B'){
									bCount++;
								}
								if(area[i][k]=='B'){// 가로행 B구획 세기
									bCount++;
								}
							}
							bCount--;				// 자신 중복제거
						}else {						// 8방 내에 공원이 있다면 가능한 빌딩 높이는 2
							bCount = 2;
						}
						if(bCount>ans) ans=bCount;	// 최대값 갱신
					}
					
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}