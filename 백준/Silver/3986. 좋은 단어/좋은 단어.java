import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char word = input.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(word);
                } else {
                    if (stack.peek() == word) {
                        stack.pop();
                    } else {
                        stack.push(word);
                    }
                }
            }
            
            if (stack.size() == 0) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}