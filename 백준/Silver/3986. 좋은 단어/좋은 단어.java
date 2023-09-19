import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            
            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else {
                    if (stack.peek().equals(str.charAt(j))) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
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
