import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Character> left;
    public static Stack<Character> right;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
//        int n = 1;

        for (int i = 0; i < n; i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char input = str.charAt(j);

                if (input == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (input == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (input == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(input);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}