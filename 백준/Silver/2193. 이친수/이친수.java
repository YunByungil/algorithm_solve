import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new long[91];
        
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i <= 90; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        
        System.out.println(dp[n]);
    }
    
}
    
    
