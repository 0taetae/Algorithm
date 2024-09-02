package s09.s0902;

import java.io.*;
import java.util.*;

public class SWEA_2115 {
	
	// N*N 개의 벌통
	// 각 칸의 숫자는 각각의 벌통에 있는 꿀의 양
	
	// 선택한 벌통 정보 저장(시작 끝 인덱스, 총수익) -> 총 수익으로 내림차순 정렬 , 인덱스 안겹치게 하기
	// 
	static int N, M, C;
	static int[][] honey;
	static int sum, profit;
	static int startX, startY;
	static ArrayList<Info> lst = new ArrayList<>();
	static int result;
	
	static class Info{
		int x,y;
		int profit;
		Info(int x, int y, int profit){
			this.x = x;
			this.y = y;
			this.profit = profit;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());  // 선택할 수 있는 벌통의 개수 
			C = Integer.parseInt(st.nextToken());
			honey = new int[N][N];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					honey[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			find();
			//System.out.println("정렬해보자");
			Collections.sort(lst, new Comparator<Info>() {

				@Override
				public int compare(Info o1, Info o2) {
					return o2.profit- o1.profit;
				}			
			});
			//System.out.println("정렬 끝");
//			for(int j=0;j<lst.size();j++) {
//				System.out.println(lst.get(j).profit);
//			}
			result = 0;
			for(int j=0;j<lst.size();j++) {
				maxFind(j);
			}
			System.out.println("#"+i+" "+result);
		}
		

	}
	public static void find() {
		//System.out.println("찾아보자");
		for(int r=0;r<N;r++) {
			//System.out.println(r);
			for(int c=0;c<N;c++) {
				if(c+M>N) continue;
				//System.out.println("c "+c);
				profit=0;
				sum=0;
				startX = r;
				startY = c;
				for(int i=c;i<c+M;i++) {
					profit += (honey[r][i] * honey[r][i]);
					sum += honey[r][i];
					if(sum>C) {
						sum -= honey[r][i];
						profit -= (honey[r][i] * honey[r][i]);
						break;
					}
				}
				//System.out.println(sum);
				if(sum<=C) {
					//System.out.println(profit);
					lst.add(new Info(startX, startY, profit));
				}
				
			}
		}
	}
	public static void maxFind(int idx) {
		for(int i=idx+1;i<lst.size();i++) {
			if(((lst.get(i).y < lst.get(idx).y) && (lst.get(i).y+M-1 < lst.get(idx).y)) || ((lst.get(i).y > lst.get(idx).y+M-1) && (lst.get(i).y+M-1 > lst.get(idx).y+M-1))){
				result = Math.max(result, (lst.get(idx).profit + lst.get(i).profit));
				
			}
		}
	}

}
