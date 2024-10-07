package s10.s1007;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class BOJ_14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] visited = new int[N]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            visited[i] = -1;
        }

        int maxLen = 1;
        int idx = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    visited[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                idx = i;
            }
        }

        System.out.println(maxLen);

        ArrayList<Integer> lst = new ArrayList<>();
        while (idx != -1) {
        	lst.add(arr[idx]);
        	idx = visited[idx];
        }

        for(int i=lst.size()-1;i>=0;i--) {
        	System.out.print(lst.get(i)+" ");
        }
    }
}

