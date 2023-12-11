import java.util.*;
import java.io.*;

public class Main {
    public static int result;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        dfs(n, 1, 2, 3);
        // sb.append(result).append("\n");
        System.out.println(result);
        System.out.println(sb);
        
    }
    
    public static void dfs(int n, int start, int mid, int end) {
        result++;
        if (n == 1) {
            // System.out.println(start + " " + end);
            sb.append(start + " " + end).append("\n");
            return;
        }
        
        dfs(n - 1, start, end, mid);
        // System.out.println(start + " " + end);
        sb.append(start + " " + end).append("\n");
        dfs(n - 1, mid, start, end);
    }
    
}
