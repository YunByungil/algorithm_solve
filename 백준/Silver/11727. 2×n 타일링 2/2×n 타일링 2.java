import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + dp[i - 2]) % 10_007;
        }
        
        System.out.println(dp[n]);
        
	}
}
    
    
