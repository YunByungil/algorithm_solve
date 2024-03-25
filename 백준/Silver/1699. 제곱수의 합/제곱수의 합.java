import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[][] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        System.out.println(dp[n]);
    }
}
    
    
