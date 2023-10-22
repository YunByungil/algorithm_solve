import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            
            if (input.equals("L")) {
                if (left.size() == 0) {
                    continue;
                }
                right.push(left.pop());
            } else if (input.equals("D")) {
                if (right.size() == 0) {
                    continue;
                }
                left.push(right.pop());
            } else if (input.equals("B")) {
                if (left.size() == 0) {
                    continue;
                }
                left.pop();
            } else {
                left.push(input.charAt(2));
            }
        }
        
        int size = right.size();
        for (int i = 0; i < size; i++) {
            left.push(right.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (char i : left) {
            sb.append(i);
        }
        
        System.out.print(sb);
    }
}
