package s0827;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GerryMandering {
    static int N;
    static boolean[] isSelected;
    static ArrayList<Integer> select, noselect;
    static ArrayList<Integer>[] lst;
    static int result;
    static int[] population;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        population = new int[N]; // 구역마다 인구수
        isSelected = new boolean[N]; // 선거구를 나누기 위한 부분집합을 구할 때 사용 
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2차원 ArrayList 생성
        lst = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int K = Integer.parseInt(st.nextToken()) - 1; 
                lst[i].add(K);
                lst[K].add(i);
            }
        }
        result = Integer.MAX_VALUE;
        powerSet(0);
        
        // 두 선거구로 나눌 수 없는 경우 -1 출력
        if(result==Integer.MAX_VALUE) {
        	System.out.println(-1);
        }else {
        	System.out.println(result);
        }
        
    }
    // 두 선거구로 나누기 위해, 부분집합 
    public static void powerSet(int cnt) {
        if (cnt == N) {
            select = new ArrayList<Integer>();
            noselect = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    select.add(i);
                } else {
                    noselect.add(i);
                }
            }
            // 한쪽 선거구에 구역이 몰려 있지 않고, 해당 선거구의 구역들이 서로 인접해 있으면, 인구수의 차이 구하기 
            if (!select.isEmpty() && !noselect.isEmpty() && adjCheck(select) && adjCheck(noselect)) {
                count();
            }
            return;
        }
        // 선택
        isSelected[cnt] = true;
        powerSet(cnt + 1);

        // 비선택
        isSelected[cnt] = false;
        powerSet(cnt + 1);
    }

    // 각 구역이 인접해 있는지 확인, BFS
    public static boolean adjCheck(ArrayList<Integer> target) {
        Queue<Integer> q = new LinkedList<Integer>();
        visit = new boolean[N];
        visit[target.get(0)] = true;
        q.offer(target.get(0));

        int count = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < lst[current].size(); i++) {
                int temp = lst[current].get(i);
                // current와 인접한 요소가 target(해당 선거구)에 포함되어 있으며 방문하지 않은 경우 
                if (target.contains(temp) && !visit[temp]) {
                    q.offer(temp);
                    visit[temp] = true;
                    count++;
                }
            }
        }
        // 인접해 있는 요소의 수가 해당 선거구의 구역수와 같다면, 해당 선거구의 구역은 인접해 있음 
        if(count == target.size()) {
        	return true;
        }else {
        	return false;
        }
    }

    // 인구 차 구하기
    public static void count() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            if (isSelected[i]) {
                sumA += population[i];
            } else {
                sumB += population[i];
            }
        }
        result = Math.min(result, Math.abs(sumA - sumB));
    }
}
