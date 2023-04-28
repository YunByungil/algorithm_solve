import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 명령의 수
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());
//        n = 1;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("push")) {
                stack.push(Integer.parseInt(input.substring(5, input.length())));
            } else if (input.equals("pop")) {
                if (!stack.isEmpty()) { // 비어있지 않음
                    System.out.println(stack.pop());
                } else { // 비어있음
                    System.out.println(-1);
                }
            } else if (input.equals("size")) {
                System.out.println(stack.size());
            } else if (input.equals("empty")) {
                if (!stack.isEmpty()) { // 비어있지 않음
                    System.out.println(0);
                } else { // 비어있음
                    System.out.println(1);
                }
            } else if (input.equals("top")) {
                if (!stack.isEmpty()) { // 비어있지 않음
                    System.out.println(stack.peek());
                } else { // 비어있음
                    System.out.println(-1);
                }
            }
        }
    }
}