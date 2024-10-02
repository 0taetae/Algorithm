package s10.s1002;

import java.io.*;
import java.util.*;

public class BOJ_2461_sol2 {
	
	static int N,M;
	static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
	static class Info implements Comparable<Info> {
        int row, col, score;
        
        Info(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }
        
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.score, o.score); 
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 2차원 리스트 
		for(int i=0;i<N;i++) {
			lst.add(new ArrayList<>());
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				lst.get(i).add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(lst.get(i));
		}
		int maxScore=Integer.MIN_VALUE;
		PriorityQueue<Info> q = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int cur = lst.get(i).get(0);
			q.add(new Info(i,0,cur));
			maxScore = Math.max(cur, maxScore);
		}
		int minDiff = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Info temp = q.poll();  // 최솟값
			minDiff = Math.min(minDiff, maxScore - temp.score);
			
			if(temp.col +1>=M) break;
			
			int nextScore = lst.get(temp.row).get(temp.col+1);
			q.add(new Info(temp.row, temp.col+1,nextScore));
			maxScore = Math.max(maxScore, nextScore);
		}
		System.out.println(minDiff);

	}

}
