import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr, t, p;
    public static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                dp[i][j] %= 1_000_000_000;
            }
        }
        
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        
        System.out.println(answer % 1_000_000_000);
    }
}
    
    
