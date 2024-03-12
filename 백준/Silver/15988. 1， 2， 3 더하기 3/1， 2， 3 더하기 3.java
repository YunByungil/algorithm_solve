import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, tmp;
    public static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[1_000_001];
        dp = new long[1_000_001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }
        
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num] % 1_000_000_009);
        }
        
    }
}
    
    
