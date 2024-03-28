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
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                if (i % 2 == 0) {
                    dp[i] = 0;
                } else {
                    dp[i] = 1;
                }
            }
        }
        
        String answer = dp[n] == 1 ? "SK" : "CY";
        System.out.println(answer);
        
    }
}
    
    
