import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        for (Integer money : stack) {
            result += money;
        }

        System.out.println(result);
    }
}