import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char peek = stack.peek();
                    
                    if (peek == '(') {
                        if (c == ')') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }
            
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
