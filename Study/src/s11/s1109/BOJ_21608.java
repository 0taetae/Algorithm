package s11.s1109;

import java.io.*;
import java.util.*;

public class BOJ_21608 {
	
	static int N;
	static int[] numArr;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<ArrayList<Integer>> likelist = new ArrayList<>();
	static ArrayList<Info> list;

    static class Info {
        int x, y, likeCnt, noCnt;
        Info(int x, int y, int likeCnt, int noCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;  // 인접한 칸에 있는 좋아하는 학생 수
            this.noCnt = noCnt;  // 인접한 칸에 있는 비어있는 칸 수 
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numArr = new int[N*N];
		map = new int[N][N];
        for (int i = 0; i <= N * N; i++) {
        	likelist.add(new ArrayList<>());
        }
		for(int r=0;r<N*N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());  // 자리 정할 학생 번호 
			numArr[r] = num;
			for(int c=0;c<4;c++) {
				int like = Integer.parseInt(st.nextToken());  // 해당 학생이 좋아하는 학생의 번호 
				likelist.get(num).add(like); 
			}
		}
		for(int i=0;i<N*N;i++) {
			check(i);
			if (list.size() > 1) {
                Collections.sort(list, (o1, o2) -> {
                	
                    if (o1.likeCnt == o2.likeCnt) {
                        if (o1.noCnt == o2.noCnt) {
                            if (o1.x == o2.x) {
                            	// 열의 번호가 작은 칸 
                            	return o1.y - o2.y;
                            }
                            // 행의 번호가 작은 칸
                            return o1.x - o2.x;
                        }
                        // 인접한 칸 중에서 비어있는 칸이 많은 칸 
                        return o2.noCnt - o1.noCnt;
                    }
                    // 좋아하는 학생이 인접한 칸에 많은 칸
                    return o2.likeCnt - o1.likeCnt;
                });
            }
			map[list.get(0).x][list.get(0).y] = numArr[i];
		}
		System.out.println(cal());
	}
	public static void check(int idx) {
		list = new ArrayList<>();
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				// 이미 학생이 있는 자리 
				if(map[r][c] != 0) continue;
				
				int noCnt = 0;
				int likeCnt = 0;
				
				// 인접한 4방향 탐색
				for(int dir=0;dir<4;dir++) {
					int nx = r + dx[dir];
					int ny = c + dy[dir];
					
					// 범위 벗어남
					if(nx<0 || ny<0 || nx>=N || ny>= N) continue;
					
					// 비어있는 칸
					if(map[nx][ny] ==0 ) {
						noCnt++;
					}
					// 좋아하는 학생이 있는 칸 
					else if(likelist.get(numArr[idx]).contains(map[nx][ny])) {
						likeCnt++;
					}
				}
				
				list.add(new Info(r,c,likeCnt, noCnt));
			}
		}
	}
	
	// 학생의 만족도의 총합 
	public static int cal() {
		int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    
                    // 인접한 칸에 해당 학생이 좋아하는 학생이 있는지 
                    if (likelist.get(map[i][j]).contains(map[nx][ny])) {
                        cnt++;
                    }
                }
                switch (cnt) {
                    case 0:
                        res += 0;
                        break;
                    case 1:
                        res += 1;
                        break;
                    case 2:
                        res += 10;
                        break;
                    case 3:
                        res += 100;
                        break;
                    case 4:
                        res += 1000;
                        break;
                }
            }
        }
        return res;
	}

}
