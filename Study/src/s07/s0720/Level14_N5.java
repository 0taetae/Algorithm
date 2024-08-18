package s07.s0720;

import java.io.*;
import java.util.*;

public class Level14_N5 {
	static StringBuilder sb = new StringBuilder();
    static int arr[];
    static HashMap<Integer, Integer> hm = new HashMap<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
 
        st = new StringTokenizer(br.readLine());
 
        for(int i = 0; i < N; i++) {
            int arr_num = Integer.parseInt(st.nextToken());
            arr[i] = arr_num;
            if(hm.containsKey(arr_num))
                hm.put(arr_num,hm.get(arr_num)+1);
            else
                hm.put(arr_num,1);
        }
 
        Arrays.sort(arr);
 
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(num);
        }
 
        System.out.println(sb);
	}
	public static void binarySearch(int num){
        int st,mid,ed;
        st = 0;
        ed = arr.length-1;
        while(st <= ed){
            mid = (st + ed) / 2;
            if(arr[mid] == num) {
                sb.append(hm.get(num) + " ");
                return;
            }
            else if(arr[mid] > num) ed = mid - 1;
            else st = mid + 1;
        }
        sb.append(0 + " ");
    }
}
