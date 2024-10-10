package s10.s1010;

import java.io.*;
import java.util.*;

public class BOJ_23309 {

    static int N, M;
    static int[] preLst = new int[1000001];
    static int[] nextLst = new int[1000001];
    static int head;
    static BufferedWriter bw; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 역의 개수
        M = Integer.parseInt(st.nextToken()); // 공사 횟수

        st = new StringTokenizer(br.readLine());
        
        int pre = Integer.parseInt(st.nextToken());
        nextLst[pre] = pre;
        preLst[pre] = pre;
        head = pre;
        for (int i = 1; i < N; i++) {
        	int next = Integer.parseInt(st.nextToken());
            nextLst[pre] = next;
            preLst[next] = pre;
            pre = next;
        }
        nextLst[pre] = head;
        preLst[head] = pre;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());

            switch (command) {
                case "BN":
                    int b = Integer.parseInt(st.nextToken());
                    bn(a, b);
                    break;
                case "BP":
                    b = Integer.parseInt(st.nextToken());
                    bp(a, b);
                    break;
                case "CP":
                    cp(a);
                    break;
                case "CN":
                    cn(a);
                    break;
            }
        }

        bw.flush(); 
        bw.close();
    }

    // 고유 번호 a를 가진 역의 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 b인 역을 설립
    public static void bn(int a, int b) throws IOException {  // a b next
        bw.write(nextLst[a] + "\n");  

        preLst[b] = a;  // b의 이전 역은 a
        nextLst[b] = nextLst[a];  // b의 다음 역은 a의 다음 역
        preLst[nextLst[a]] = b;  // a의 다음 역의 이전역은 b
        nextLst[a] = b;  // a의 다음역은 b
    }

    // 고유 번호 a를 가진 역의 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 b인 역을 설립
    private static void bp(int a, int b) throws IOException {  // pre b a
        bw.write(preLst[a] + "\n"); 
        
        preLst[b] = preLst[a]; // b의 이전 역은 a의 이전 역
        nextLst[b] = a;  // b의 다음 역은 a
        nextLst[preLst[a]] = b;  // a의 이전역의 다음역은 b
        preLst[a] = b;  // a의 이전 역은 b
    }

    // 고유 번호 a를 가진 역의 다음 역을 폐쇄하고 그 역의 고유 번호를 출력
    private static void cn(int a) throws IOException {  // a next next.next -> a next.next
        bw.write(nextLst[a] + "\n");
        
        preLst[nextLst[nextLst[a]]] = a;
        nextLst[a] = nextLst[nextLst[a]];
    }

    // 고유 번호 a를 가진 역의 이전 역을 폐쇄하고 그 역의 고유 번호를 출력
    private static void cp(int a) throws IOException {  // pre.pre pre a -> pre.pre a
        bw.write(preLst[a] + "\n");  

        nextLst[preLst[preLst[a]]] = a;
        preLst[a] = preLst[preLst[a]];
    }
}
