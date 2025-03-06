import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> s = new Stack<>();
        String input = br.readLine();
        int num = 1;
        int sum = 0;
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '(') {
                s.push(c);
                num *= 2;
            }
            
            if (c == '[') {
                s.push(c);
                num *= 3;
            }
            
            if (c == ')') {
                
                if (s.isEmpty() || s.peek() != '(') {
                    result = false;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    s.pop();
                    sum += num;
                    num /= 2;
                } else {
                    s.pop();
                    num /= 2;                    
                }
            }
            
            if (c == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    result = false;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    s.pop();
                    sum += num;
                    num /= 3;
                } else {
                    s.pop();
                    num /= 3;
                }
            }
        }
        if (!s.isEmpty()) {
            result = false;
        }
        
        if (result) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}