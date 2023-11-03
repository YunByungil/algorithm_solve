import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            
            if (input.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (input.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (input.equals("front")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peekFirst()).append("\n");
                }
            } else if (input.equals("back")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            } else {
                int num = Integer.parseInt(input.substring(5));
                q.offer(num);
                // sb.append(num).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}
