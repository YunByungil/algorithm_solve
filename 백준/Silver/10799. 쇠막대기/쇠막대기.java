import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                
                if (input.charAt(i - 1) == ')') {
                    answer++;
                } else {
                    answer += stack.size();
                }
            }
        }
        
        System.out.println(answer);
    }
}
