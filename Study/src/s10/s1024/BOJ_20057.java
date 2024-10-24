package s10.s1024;

import java.io.*;
import java.util.*;

public class BOJ_20057 {

    static int N;
    static int[][] map;
    // 방향이 바뀔 때 마다 비율 배열도 바뀌어야 함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    static int[][] sandSpread = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}
    }; // 모래 퍼지는 비율
    
    // 좌 하 우 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    // 격자의 밖으로 나간 모래의 양 
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 격자의 가운데 칸부터 토네이도의 이동이 시작 
        int startR = N / 2;
        int startC = N / 2;

        int dir = 0;
        int move = 1; 

        while (startR != 0 || startC != 0) {
            for (int i = 0; i < 2; i++) {
            	System.out.println(dir+"방향으로 "+move+"칸 이동 ");
                for (int j = 0; j < move; j++) {
                    int nextR = startR + dx[dir];
                    int nextC = startC + dy[dir];

                    if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                        continue;  
                    }
                    System.out.println("y: "+nextR+" "+nextC);
                    // startR, startC : x
                    // nextR, nextC : y
                    spread(nextR, nextC, dir);

                    startR = nextR;
                    startC = nextC;

                    if (startR == 0 && startC == 0) {
                    	System.out.println(res);
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }

        
    }

    private static void spread(int r, int c, int dir) {
    	System.out.println("퍼뜨리기 시작");
        // 모래가 없는 경우
        if (map[r][c] == 0) {
        	System.out.println("이 칸엔 모래가 없어");
        	return;
        }
        
        int cur = map[r][c];
        System.out.println("이 칸에는 "+cur+"이 있었어");
        int total = 0;
        
        if(dir==0) {
        	int targetR = r;
        	int targetC = c-2;
        	if(targetR<0 || targetC<0 || targetR>=N || targetC>=N) {
        		res+= cur*5/100;
        	}else {
        		total += cur*5/100;
        		map[targetR][targetC] += cur*5/100;
        	}
        	
        }else if(dir==1) {
        	
        }else if(dir==2) {
        	
        }else if(dir==3) {
        	
        }

//        for (int i = -2; i <= 2; i++) {
//            for (int j = -2; j <= 2; j++) {
//                if (sandSpread[i + 2][j + 2] > 0) {
//                    int spreadR = r + i;
//                    int spreadC = c + j;
//                    
//                    if (spreadR < 0 || spreadC < 0 || spreadR >= N || spreadC >= N) {
//                        res += (cur * sandSpread[i + 2][j + 2]) / 100;
//                        System.out.println("토네이도가 소멸됨 즉, 격자의 밖으로 나간 모래는?");
//                    	System.out.println((cur * sandSpread[i + 2][j + 2]) / 100);
//                    } else {
//                        int spreadSand = (cur * sandSpread[i + 2][j + 2]) / 100;
//                        total += spreadSand;
//                        map[spreadR][spreadC] += spreadSand;
//                    }
//                }
//            }
//        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		System.out.print(map[i][j]+" ");
        	}
        	System.out.println();
        }

        // 남은 모래
        int tempR = r + dx[dir];
        int tempC = c + dy[dir];
        int remainSand = cur - total;
        System.out.println(remainSand+"만큼 모래가 남았어 ");

        if (tempR < 0 || tempC < 0 || tempR >= N || tempC >= N) {
        	System.out.println("토네이도가 소멸됨 즉, 격자의 밖으로 나간 모래는?");
        	System.out.println(remainSand);
            res += remainSand;
        } else {
        	System.out.println("토네이도가 소멸되지 않았어");
            map[tempR][tempC] += remainSand;
            
            for(int i=0;i<N;i++) {
            	for(int j=0;j<N;j++) {
            		System.out.print(map[i][j]+" ");
            	}
            	System.out.println();
            }
        }
        

        // 현재 좌표의 모래는 전부 없어짐
        //map[r][c] = 0; 
    }
}
