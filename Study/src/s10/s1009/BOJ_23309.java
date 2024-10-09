package s10.s1009;

import java.io.*;
import java.util.*;

public class BOJ_23309 {

    static int N, M;
    static Node head;
    static Map<Integer, Node> map = new HashMap<>();
    static BufferedWriter bw; 

    static class Node {
        private int num;
        public Node pre;
        public Node next;

        public Node(int num) {
            this.num = num;
            this.pre = null;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 역의 개수
        M = Integer.parseInt(st.nextToken()); // 공사 횟수

        st = new StringTokenizer(br.readLine());
        Node preNode = null;
        for (int i = 0; i < N; i++) {
            Node newNode = new Node(Integer.parseInt(st.nextToken()));
            map.put(newNode.num, newNode);
            if (head == null) {
                head = newNode;
            } else {
                preNode.next = newNode;
                newNode.pre = preNode;
            }
            preNode = newNode;
        }
        preNode.next = head; 
        head.pre = preNode;

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
    public static void bn(int a, int b) throws IOException {
        Node cur = map.get(a);
        bw.write(cur.next.num + "\n");  

        Node newNode = new Node(b);
        map.put(b, newNode);
        Node nextNode = cur.next;

        newNode.pre = cur;
        newNode.next = nextNode;
        nextNode.pre = newNode;
        cur.next = newNode;
    }

    // 고유 번호 a를 가진 역의 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 b인 역을 설립
    private static void bp(int a, int b) throws IOException {
        Node cur = map.get(a);
        bw.write(cur.pre.num + "\n"); 

        Node newNode = new Node(b);
        map.put(b, newNode);
        Node preNode = cur.pre;

        newNode.pre = preNode;
        newNode.next = cur;
        preNode.next = newNode;
        cur.pre = newNode;
    }

    // 고유 번호 a를 가진 역의 다음 역을 폐쇄하고 그 역의 고유 번호를 출력
    private static void cn(int a) throws IOException {
        Node cur = map.get(a);
        bw.write(cur.next.num + "\n"); 

        Node nextNode = cur.next.next;

        map.remove(cur.next.num); 

        cur.next = nextNode; 
        nextNode.pre = cur; 

        if (cur.next == head) {
            head = nextNode;
        }
    }

    // 고유 번호 a를 가진 역의 이전 역을 폐쇄하고 그 역의 고유 번호를 출력
    private static void cp(int a) throws IOException {
        Node cur = map.get(a);
        bw.write(cur.pre.num + "\n");  

        Node preNode = cur.pre.pre; 

        map.remove(cur.pre.num); 

        preNode.next = cur; 
        cur.pre = preNode; 

        if (cur.pre == head) { 
            head = cur; 
        }
    }
}
