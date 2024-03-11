import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[10_001];
        dp = new int[10_001];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
        }
        
        System.out.println(dp[n]);
        
    }
}
    
    
