import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t;
    public static int[] arr, red, green, blue;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }
        
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
        
	}
}
    
    
