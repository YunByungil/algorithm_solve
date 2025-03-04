import java.util.*;
import java.io.*;


public class Main {
    public static Deque<Integer> q;
    public static boolean answer = true;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // R = 순서 뒤집기, D = 버리기
        for (int count = 0; count < t; count++) {
            answer = true;
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            boolean result = true; // true일 경우 정방향
            String number = br.readLine();
            number = number.replace("[", "").replace("]", "");
            String[] str = number.split(",");

            for (int i = 0; i < n; i++) {
                q.offer(Integer.parseInt(str[i]));
            }

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == 'R') {
                    result = !result;
                }

                if (c == 'D') {
                    if (result) {
                        left();
                    } else {
                        right();
                    }
                }
            }

            if (!answer) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");

                if (result) {
                    while (q.size() > 1) {
                        sb.append(q.poll()).append(",");
                    }
                    if (!q.isEmpty()) {
                        sb.append(q.poll());
                    }
                    sb.append("]").append("\n");
                } else {
                    while (q.size() > 1) {
                        sb.append(q.pollLast()).append(",");
                    }
                    if (!q.isEmpty()) {
                        sb.append(q.pollLast());
                    }
                    sb.append("]").append("\n");
                }
            }
        }



        System.out.println(sb);


    }

    public static void left() {
        if (q.isEmpty()) {
            answer = false;
        } else {
            q.poll();
        }
    }

    public static void right() {
        if (q.isEmpty()) {
            answer = false;
        } else {
            q.pollLast();
        }
    }
}
