import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char pk = stack.peek();
                    if (pk == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
