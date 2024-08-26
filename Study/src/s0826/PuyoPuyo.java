package s0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PuyoPuyo {
	static ArrayList<Info> lst;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	static char[][] arr;
	
	// 해당 요소의 x, y 인덱스 저장
	static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new char[12][6];
		
		for(int r=0;r<12;r++) {
			String str = br.readLine();
			for(int c=0;c<6;c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		// 연쇄 횟수 
		int count =0;
		
		while(true) {
			// 연쇄가 끝났는지 여부 
			boolean isOk = true;
			visit = new boolean[12][6];
			for(int r=0;r<12;r++) {
				for(int c=0;c<6;c++) {
					// 빈공간이 아닌 경우 
					if(arr[r][c] != '.') {
						lst = new ArrayList<>();
						bfs(r, c, arr[r][c]);
						
						// 같은 색 뿌요가 4개 이상 연결되어 있음
						if(lst.size()>=4) {
							// 연쇄가 또 일어날 가능성이 있음
							isOk = false;
							// 해당 색의 뿌요를 빈칸으로 만들어주기 
							for(int i=0;i<lst.size();i++) {
								arr[lst.get(i).x][lst.get(i).y] = '.';
							}
						}
					}
				}
			}
			// 연쇄가 끊김 
			if(isOk) break;
			// 뿌요가 없어지고 나서 중력의 영향을 받아 아래로 떨어짐 
			downPuyo();
			count++;
		}
		System.out.println(count);

	}
	public static void bfs(int r, int c, char target) {
		Queue<Info> q = new LinkedList<>();
        lst.add(new Info(r,c));
        q.offer(new Info(r,c));
        visit[r][c] = true;
        
        while(!q.isEmpty()) {
        	Info temp = q.poll();
        	
        	for(int i=0;i<4;i++){
        		int x = temp.x + dx[i];
        		int y = temp.y + dy[i];
        		if(x<0 || y<0 || x>=12 || y>=6 || visit[x][y] || arr[x][y] != target) continue;
        		visit[x][y] = true;
        		lst.add(new Info(x,y));
        		q.offer(new Info(x,y));
        	}
        }
	}
	public static void downPuyo() {
		for(int c=0;c<6;c++) {
			for(int r=11;r>=0;r--) {
				// 빈칸을 만나면 빈칸이 아닌 것과 바꿈 
				if(arr[r][c]=='.') {
					for(int f=r-1;f>=0;f--) {
						if(arr[f][c] != '.') {
							arr[r][c] = arr[f][c];
							arr[f][c] = '.';
							break;
						}
					}
				}
			}
		}
	}
}

