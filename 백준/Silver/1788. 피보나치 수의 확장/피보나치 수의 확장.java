import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[] arr, tmp;
    public static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        dp = new long[1_000_001];
        
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= Math.abs(n); i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_000;
        }
        
        if (n < 0) {
            n = Math.abs(n);
            if (n % 2 == 0) {
                System.out.println(-1);
                System.out.println(dp[n] % 1_000_000_000);
            } else {
                System.out.println(1);
                System.out.println(dp[n] % 1_000_000_000);
            }
        } else {
            System.out.println(1);
            System.out.println(dp[n] % 1_000_000_000);
        }
        
    }
}
    
    
