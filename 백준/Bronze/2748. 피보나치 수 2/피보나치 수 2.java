import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr, t, p;
    public static long[]dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i < 91; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        
        System.out.println(dp[n]);
    }
}
    
    
