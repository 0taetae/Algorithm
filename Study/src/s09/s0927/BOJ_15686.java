package s09.s0927;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
	
	static int N,M;
	static int[][] map;
	static ArrayList<Info> house = new ArrayList<Info>();
	static ArrayList<Info> chicken = new ArrayList<Info>();
	static int res = Integer.MAX_VALUE;
	static boolean[] selected;
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 도시의 정보
		M = Integer.parseInt(st.nextToken());  // 치킨집 최대 개수
		map = new int[N][N];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {
					house.add(new Info(r,c));  // 집의 위치 저장 
				}
				if(map[r][c]==2) {
					chicken.add(new Info(r,c));  // 치킨집의 위치 저장
				}
			}
		}
		selected = new boolean[chicken.size()];  // 치킨집 선택 
		
		Comb(0,0);
		System.out.println(res);
	}
	// 치킨집 최대 M개 선택하기 
	static void Comb(int start, int cnt) {
		if (cnt == M) {
            res = Math.min(res, check());  // 도시의 치킨 거리의 최솟값 
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                Comb(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
	}
	
	static int check() {
		int total = 0;
		
		for(int i=0;i<house.size();i++) {
			int minDist = Integer.MAX_VALUE;
			Info cur = house.get(i);
			for(int j=0;j<chicken.size();j++) {
				if(selected[j]) {  // 치킨집 중에 선택된 치킨집인 경우 
					Info temp = chicken.get(j);
					int dist = Math.abs(cur.x - temp.x) + Math.abs(cur.y - temp.y);  
					minDist = Math.min(minDist, dist);  // 치킨 거리 
				}
			}
			total += minDist;
		}
		
		return total;   // 도시의 치킨 거리
	}

}
