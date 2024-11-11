package s11.s1106;

import java.io.*;
import java.util.*;

public class SWEA_1824 {
	static int R, C;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visit;
    static boolean res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new char[R][C];
            for (int r = 0; r < R; r++) {
                String str = br.readLine();
                for (int c = 0; c < C; c++) {
                    arr[r][c] = str.charAt(c);
                }
            }
            // @가 없는 경우 바로 끝내기 
            visit = new boolean[R][C][4][16]; // 행, 열, 방향, 메모리
            res = false;

            ver(0, 0, 1, 0); 
            if(res) {
            	sb.append("#").append(i).append(" YES").append("\n");
            }else {
            	sb.append("#").append(i).append(" NO").append("\n");
            }
            
        }
        System.out.print(sb);
    }

    static void ver(int r, int c, int dir, int memory) {
        if (res) return;

        if (r < 0) r = R - 1;
        if (r >= R) r = 0;
        if (c < 0) c = C - 1;
        if (c >= C) c = 0;

        if (visit[r][c][dir][memory]) return;
        visit[r][c][dir][memory] = true;

        int nextDir = dir;
        int nextMemory = memory;

        switch (arr[r][c]) {
            case '<':
                nextDir = 3;
                break;
            case '>':
                nextDir = 1;
                break;
            case '^':
                nextDir = 0;
                break;
            case 'v':
                nextDir = 2;
                break;
            case '_':
            	if(memory==0) {
            		nextDir = 1;
            	}else {
            		nextDir = 3;
            	}
                break;
            case '|':
            	if(memory==0) {
            		nextDir = 2;
            	}else {
            		nextDir = 0;
            	}
                break;
            case '?':
            	// 4방향중 랜덤
                for (int i = 0; i < 4; i++) {
                    int newDir = (dir + i) % 4;
                    ver(r + dx[newDir], c + dy[newDir], newDir, memory);
                }
                return;
            case '.':
                break;
            case '@':
                res = true;
                return;
            case '+':
            	if(memory==15) {
            		nextMemory = 0;
            	}else {
            		nextMemory = memory+1;
            	}
                break;
            case '-':
            	if(memory==0) {
            		nextMemory = 15;
            	}else {
            		nextMemory = memory-1;
            	}
                break;
            default:
                nextMemory = arr[r][c] - '0';
                break;
        }

        ver(r + dx[nextDir], c + dy[nextDir], nextDir, nextMemory);
    }

}

