import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String str;
    public static int M;

    public static Stack<Character> left = new Stack<>();
    public static Stack<Character> right = new Stack<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            left.add(str.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (input.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (input.equals("D")) { // 커서를 오른쪽으로 이동
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (input.equals("B")) { // 왼쪽에 있는 문자를 삭제
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (input.length() == 3) {
               left.push(input.charAt(2));
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);



    }
}