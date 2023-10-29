import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            // if (stack.isEmpty()) {
            //     for (int j = 1; j <= num; j++) {
            //         System.out.println("j = " + j);
            //         stack.push(j);
            //         sb.append("+").append("\n");
            //     }
            //     stack.pop();
            //     sb.append("-").append("\n");
            // } else if (stack.peek().equals(num)) {
            //     stack.pop();
            //     sb.append("-").append("\n");
            // } else {
            //     if (num > max) {
            //         for (int j = max + 1; j <= num; j++) {
            //             stack.push(j);
            //             sb.append("+").append("\n");
            //         }
            //         stack.pop();
            //         sb.append("-").append("\n");
            //     }
            // }
            
            if (!stack.isEmpty() && stack.peek().equals(num)) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                if (num > max) {
                    for (int j = max + 1; j <= num; j++) {
                        stack.push(j);
                        sb.append("+").append("\n");
                    }
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
            max = Math.max(max, num);
        }
        
        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
