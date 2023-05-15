// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, answer;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        if (m == 0) {
            answer--;
        }
        System.out.println(answer);
    }
    
    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == m) {
                answer++;
            }
            return;   
        }
        
        dfs(depth + 1, sum);
        dfs(depth + 1, sum + arr[depth]);
        
        
    }
    
}