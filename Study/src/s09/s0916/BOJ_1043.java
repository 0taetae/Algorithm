package s09.s0916;

import java.io.*;
import java.util.*;

public class BOJ_1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 사람 수
        int M = Integer.parseInt(st.nextToken());  // 파티 수
        boolean[] visited = new boolean[M];

        // 진실을 아는 사람들 리스트
        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        HashSet<Integer> knowSet = new HashSet<>();
        for (int i = 0; i < knowCnt; i++) {
            knowSet.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 참석 2차원 리스트 생성
        ArrayList<ArrayList<Integer>> partyMember = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            partyMember.add(new ArrayList<>());
        }

        // 각 파티의 참석자 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyCnt; j++) {
                int mem = Integer.parseInt(st.nextToken());
                partyMember.get(i).add(mem);
            }
        }

        
        Queue<Integer> q = new LinkedList<>();

        // 진실을 아는 사람이 속한 파티 찾기 
        for (int i = 0; i < M; i++) {
            for (int mem : partyMember.get(i)) {
                if (knowSet.contains(mem)) {
                    q.add(i);
                    visited[i] = true;
                    break;
                }
            }
        }

        // 진실을 아는 사람이 속한 파티에 참석하는 모든 사람들을 진실을 아는 사람들 리스트에 추가
        while (!q.isEmpty()) {
            int partyIdx = q.poll();
            for (int mem : partyMember.get(partyIdx)) {
                if (!knowSet.contains(mem)) {
                    knowSet.add(mem);                }
            }

            for (int i = 0; i < M; i++) {
                if (!visited[i]) {
                    for (int mem : partyMember.get(i)) {
                        if (knowSet.contains(mem)) {
                            q.add(i);
                            visited[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        // 진실을 아는 사람들이 없는 파티 구하기 -> 과장된 이야기를 할 수 있는 파티 개수 
        int res = 0;
        for (int i = 0; i < M; i++) {
            boolean check = true;
            for (int mem : partyMember.get(i)) {
                if (knowSet.contains(mem)) {
                	check = false;
                    break;
                }
            }
            if (check) {
                res++;
            }
        }

        System.out.println(res);
    }
}
