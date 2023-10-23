import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            
            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                if (inputChar == '>') {
                    if (right.isEmpty()) {
                        continue;
                    }
                    left.push(right.pop());
                } else if (inputChar == '<') {
                    if (left.isEmpty()) {
                        continue;
                    }
                    right.push(left.pop());
                } else if (inputChar == '-') {
                    if (left.isEmpty()) {
                        continue;
                    }
                    left.pop();
                } else {
                    left.push(inputChar);
                }
            }
            
            int size = right.size();
            for (int i = 0; i < size; i++) {
                left.push(right.pop());
            }
            
            for (char i : left) {
                sb.append(i);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
