package s11.s1109;

import java.io.*;
import java.util.*;

public class BOJ_17471 {

	static int N; 
	static int[] population;
	static ArrayList<Integer>[] lst;
	static boolean[] isSelected;
	static ArrayList<Integer> secA,secB;
	static int res;
	static int total;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N];  // 각 구역의 인구 수 
		total=0;  // 모든 지역의 총 인구수 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total += population[i];
		}
		lst = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<Integer>();
        }
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int j=0;j<K;j++) {
				int num = Integer.parseInt(st.nextToken())-1;
				lst[i].add(num);
				lst[num].add(i);
			}
		}
		isSelected = new boolean[N];
		res = Integer.MAX_VALUE;
		subSet(0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		

	}
	
	// 부분집합으로 구역 선택
	static void subSet(int cnt) {
		if(cnt==N) {
			secA = new ArrayList<>();
			secB = new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					secA.add(i);
				}else {
					secB.add(i);
				}
			}
			// 한 선거구에 치우지지 않고, 해당 선거구의 모든 구역이 인접한다면 
			if(!secA.isEmpty() && !secB.isEmpty() && check(secA) && check(secB)) {
				res = Math.min(cal(), res);
			}
			return;
		}
		isSelected[cnt]=true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	static boolean check(ArrayList<Integer> select) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		int target = select.get(0);
		q.offer(target);
		visited[target] = true;
		
		int count=1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<lst[cur].size();i++) {
				int temp = lst[cur].get(i);
				if(select.contains(temp) && !visited[temp]) {
					visited[temp]= true;
					q.offer(temp);
					count++;
				}
			}
		}
		if(count == select.size()) {
			return true;
		}else {
			return false;
		}
	}
	static int cal() {
		int sumA = 0;
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				sumA += population[i];
			}
		}
		int sumB = total - sumA;
		return Math.abs(sumB-sumA);
	}
}
