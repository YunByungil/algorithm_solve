import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            
            for (int i = 0; i < input.length(); i++) {
                char word = input.charAt(i);
                if (word != '(' && word != ')' && word != '[' && word != ']') {
                    continue;
                }
                if (stack.isEmpty()) {
                    stack.push(word);
                } else {
                    if (stack.peek() == '(') {
                        if (word == ')') {
                            stack.pop();
                        } else {
                            // System.out.println("word =" + word);
                            stack.push(word);
                        }
                    } else if (stack.peek() == '[') {
                        if (word == ']') {
                            stack.pop();
                        } else {
                            stack.push(word);
                        }
                    } else {
                        stack.push(word);
                    }
                }
            }
            
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
