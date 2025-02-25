import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for (int count = 0; count < n; count++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) {
                for (int i = max + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                max = num;
                stack.pop();
                sb.append("-").append("\n");
            } else {
                if (stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append("\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println(sb);
        
    }
}