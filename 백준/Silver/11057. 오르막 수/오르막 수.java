import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t;
    public static int[][] arr, tmp;
    public static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += (dp[i - 1][k]) % 10_007;
                }
            }
        }
        
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        
        System.out.println(answer % 10_007);
    }
}
    
    
