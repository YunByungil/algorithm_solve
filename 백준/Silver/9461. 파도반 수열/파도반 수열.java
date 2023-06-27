import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[] arr = new int[101];
        long[] dp = new long[101];
        
        
        
        for (int count = 0; count < t; count++) {
            int n = Integer.parseInt(br.readLine());
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            for (int i = 6; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
            
            System.out.println(dp[n]);
        }
        
    }
}
