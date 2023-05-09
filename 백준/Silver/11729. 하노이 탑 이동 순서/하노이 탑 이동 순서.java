// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;
public class Main {
    public static int result;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
                
        func(n, 1, 2, 3);
        System.out.println(result);
        System.out.println(sb);
        
    }
    
    public static void func(int n, int start, int mid, int end) {
        result++;
        if (n == 1) {
            sb.append(start + " " + end).append("\n");
            return;
        }
        
        func(n - 1, start, end, mid);
        sb.append(start + " " + end).append("\n");
        func(n - 1, mid, start, end);
    }
}