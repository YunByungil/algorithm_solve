import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (true) {
            Stack<Character> stack = new Stack<>();
            str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            
            for (int i = 0; i < str.length(); i++) {
                char input = str.charAt(i);
                if (input == '(' || input == '[') {
                    stack.push(input);
                } else if (input == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(input);
                        }
                    } else {
                        stack.push(input);
                    }
                } else if (input == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(input);
                        }
                    } else {
                        stack.push(input);
                    }
                }
            }
            
            if (stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            
            
        }
    }
}