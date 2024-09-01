package s08.s0829;

import java.io.*;
import java.util.*;

public class BOJ_16235 {

    static int N, M, K;
    static int[][] A;
    static int[][] nut;
    static ArrayList<Info> tree = new ArrayList<>(); // 살아있는 나무
    static ArrayList<Info> deadTree = new ArrayList<>();  // 죽은 나무
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Info {
        int x;
        int y;
        int age;

        public Info(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        nut = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
                nut[r][c] = 5;  // 처음에 양분은 모든 칸에 5만큼 들어있음
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree.add(new Info(r, c, age));
        }

        // 나이가 어린 나무부터 양분을 먹음
        Collections.sort(tree, (t1, t2) -> t1.age - t2.age);

        for (int i = 1; i <= K; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(tree.size());
    }
    public static void spring() {
        ArrayList<Info> aliveTree = new ArrayList<>();
        for(int i=0;i<tree.size();i++) {
			Info target = tree.get(i);
			// 자신의 나이보다 양분이 부족한 경우 
        	if(nut[target.x][target.y] < target.age) {
        		// 죽은 나무 추가
                deadTree.add(target);
        	}
        	else {
        		// 자신의 나이만큼 양분을 먹음
                nut[target.x][target.y] -= target.age;
                // 나이 1 증가
                target.age++;
                aliveTree.add(target);
        	}
        }
        tree = aliveTree; // 살아있는 나무 리스트로 갱신
    }
    // 봄에 죽은 나무의 나이를 2로 나눈 값이 양분으로 추가 
    public static void summer() {
    	for(int i=0;i<deadTree.size();i++) {
			Info target = deadTree.get(i);
            nut[target.x][target.y] += target.age / 2;
        }
        deadTree.clear(); // 죽은 나무 리스트 초기화
    }

    public static void autumn() {
        ArrayList<Info> newTrees = new ArrayList<>();
        for(int i=0;i<tree.size();i++) {
			Info target = tree.get(i);
			// 나이가 5의 배수이면 번식 
            if (target.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int r = target.x + dx[j];
                    int c = target.y + dy[j];
                    if (r >= 1 && c >= 1 && r <= N && c <= N) {
                        newTrees.add(new Info(r, c, 1));
                    }
                }
            }
        }
        tree.addAll(newTrees); // 번식한 나무를 기존 나무 리스트에 추가
        // 나무가 새로 추가되었으므로 정렬
        Collections.sort(tree, (t1, t2) -> t1.age - t2.age);
    }
    // 땅에 양분 추가
    public static void winter() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                nut[r][c] += A[r][c];
            }
        }
    }
}
