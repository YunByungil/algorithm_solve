import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            if (input.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                q.offerLast(num);
            } else if (input.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                q.offerFirst(num);
            } else if (input.equals("front")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else if (input.equals("back")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (input.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (input.equals("pop_front")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.pollFirst()).append("\n");
                }
            } else if (input.equals("pop_back")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.pollLast()).append("\n");
                }
            }
        }
        
        System.out.println(sb);
    }
}
