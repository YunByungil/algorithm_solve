import java.util.*;
import java.io.*;

public class Main {
    public static int result;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        dfs(n, 1, 3);
        System.out.println(result);
        System.out.println(sb);
        
    }
    
    public static void dfs(int n, int start, int end) {
        result++;
        if (n == 1) {
            sb.append(start + " " + end).append("\n");
            return;
        }
        
        dfs(n - 1, start, 6 - start - end); // n - 1개의 원판을 1 -> 2로 옮긴다.
        sb.append(start + " " + end).append("\n");
        dfs(n - 1, 6 - start - end, end); // n - 1개의 원판을 2 -> 3로 옮긴다.
    }
    
}
