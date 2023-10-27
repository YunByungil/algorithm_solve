import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            
            if (input.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (input.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (input.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            } else {
                int num = Integer.parseInt(input.substring(5));
                stack.push(num);
            }
        }
        
        System.out.println(sb);
    }
}
