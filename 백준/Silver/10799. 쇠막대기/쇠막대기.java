import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> s = new Stack<>();
        String input = br.readLine();
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '(') {
                s.push(c);
            }
            
            if (c == ')') {
                s.pop();
                if (input.charAt(i - 1) == ')') {
                    answer++;
                } else {
                    answer += s.size();
                }
            }
            
        }
        
        System.out.println(answer);
        
    }
}