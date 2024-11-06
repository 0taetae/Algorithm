package s11.s1106;

import java.io.*;
import java.util.*;

public class BOJ_14567 {
	
	static int N,M;
	static ArrayList<Integer>[] list ;
	static int[] depth,cnt;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		depth = new int[N+1];  // 진입 차수 
		cnt = new int[N+1];
		
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // 선수과목
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			depth[b]++;
		}
		// 진입차수가 0인 과목을 큐에 담기 
		for(int i=1;i<=N;i++) {
			if(depth[i] == 0) {
				q.add(i);
				cnt[i]=1;
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<list[cur].size();i++) {
				int temp = list[cur].get(i);
				depth[temp]--;
				if(depth[temp]==0) {
					q.add(temp);
					cnt[temp] = cnt[cur]+1;
				}
			}
			
		}
		for(int i=1;i<=N;i++) {
			System.out.print(cnt[i]+" ");
		}

	}

}
