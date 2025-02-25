import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        
        int answer = 0;
        for (Integer i : stack) {
            answer += i;
        }
        
        System.out.println(answer);
    }
}