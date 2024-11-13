package s11.s1112;

import java.io.*;
import java.util.*;

public class BOJ_17472 {
	
	static int N,M;
	static int[][] map;
	static int[][] island;
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int bridgeCnt = 0;
	
	static class Info implements Comparable<Info>{
		int a,b,len;
		Info(int a, int b, int len){
			this.a = a; // 연결할 섬 1
			this.b = b;  // 연결할 섬 2
			this.len = len;
		}
		@Override
		public int compareTo(Info o) {
			return this.len-o.len;
		}
		
	}
	static PriorityQueue<Info> pq = new PriorityQueue<>();
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		island = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bridgeCnt=0;  //  섬 번호 
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				// 땅인데, 섬 번호가 없는 곳 
				if(map[r][c]!=0 && island[r][c] ==0) {
					bridgeCnt++;
					bfs(r,c,bridgeCnt);
					
				}
			}
		}
//		for(int r=0;r<N;r++) {
//			for(int c=0;c<M;c++) {
//				
//				System.out.print(island[r][c]+" ");
//			}
//			System.out.println();
//		}
		
		// 가능한 다리 만들기
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				// 섬이 있는 위치 
				if(island[r][c]!=0) {
					//System.out.println(r+" "+c);
					makeBridge(r,c);
				}
			}
		}
		//System.out.println(pq.size());
		
		
		make();
		int res = 0;
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(union(cur.a,cur.b)) {
				res+=cur.len;
			}
		}
		int cnt=0;
		for(int i=1;i<=bridgeCnt;i++) {
			if(parent[i]<0) {
				cnt++;
			}
		}
		if(cnt>=2) {
			System.out.println(-1);
		}else if(res==0) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		
	}
	// 섬 번호 
	public static void bfs(int r,int c,int num) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		island[r][c] = num;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==0 || island[nx][ny]!=0) continue;
				island[nx][ny] = num;
				q.add(new Node(nx,ny));
				
			}
			
		}
	}
	// 다리 만들기 : pq에 담기
	// 모든 섬을 연결하는 다리 길이의 최솟값 -> 다리 길이를 기준으로 정렬 
	public static void makeBridge(int r, int c) {
		for(int dir=0;dir<2;dir++) {
			//System.out.println("dir "+dir);
			for(int i=1;i<=10;i++) {
				int nx = r + dx[dir]*i;
				int ny = c + dy[dir]*i;
				if(nx<0 || ny<0 || nx>=N || ny>=M) break;
				
				// 바다일 때
				if(island[nx][ny]==0) {
					//System.out.println("바다");
					continue;
				}
				// 같은 섬과 연결될 때
				else if(island[nx][ny]==island[r][c]) {
					//System.out.println("같은 섬");
					break;
				}
				// 다른 섬과 연결 
				else if(island[nx][ny]!=island[r][c]){
					//System.out.println("다른 섬 ");
					// 다리 길이 2 이상 
					if(i>=3) {
//						System.out.println("다리 만들어졌어");
						//System.out.println(island[r][c]+" "+island[nx][ny]+" "+(i-1));
						pq.add(new Info(island[r][c],island[nx][ny],i-1));
						break;
					}else {
						break;
					}
				}
			}
		}
	}
	static int[] parent ;
	public static void make() {
		parent = new int[bridgeCnt+1];
		Arrays.fill(parent, -1);
	}
	
	public static int findset(int a) {
		if(parent[a]<0) return a;
		
		return parent[a] = findset(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot == bRoot) return false;
		
		parent[aRoot] += parent[bRoot];
		parent[bRoot] = aRoot;
		return true;
		
	}
	
	
	

}
