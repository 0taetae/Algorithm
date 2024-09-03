package s09.s0903;

import java.io.*;
import java.util.*;

public class BOJ_1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, L, D;
        int[] arr;

        N = Integer.parseInt(st.nextToken());  // 노래 개수
        L = Integer.parseInt(st.nextToken());  // 노래 길이 
        D = Integer.parseInt(st.nextToken());  // 전화벨 울리는 시간 주기 

        arr = new int[N*L+5*(N-1)];   // 노래 조용 노래 조용 노래 

        for(int i = 0; i < N; i++) {
            int s = (L+5) * i;  // 노래 + 조용 
            for(int j = s; j < s+L; j++) { // 노래 구간 
                arr[j] = 1;
            }
        }
        int cnt = 0;
        while(cnt < arr.length) { 
            if(arr[cnt] == 0)   // 전화벨 울리는 시간에 조용한 구간이면 break
                break;
            cnt += D; // 모든 앨범 수록곡을 다 듣고 난 후에 전화벨을 들을 수 있는 경우 고려 


        }
        System.out.println(cnt);
    }
}