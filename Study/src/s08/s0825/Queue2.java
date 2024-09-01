package s08.s0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        int back = 0;

        for (int i = 0; i < T; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    int num = Integer.parseInt(command[1]);
                    back = num;
                    q.offer(num);
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(q.poll() + "\n");
                    }
                    break;

                case "size":
                    bw.write(q.size() + "\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(q.peek() + "\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(back + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();

	}

}
