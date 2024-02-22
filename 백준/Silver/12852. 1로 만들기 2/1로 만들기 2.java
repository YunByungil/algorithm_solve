import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr, red, green, blue;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            arr[i] = i - 1;
            
            if (i % 2 == 0 && dp[i / 2] + 1 <= dp[i]) {
                dp[i] = dp[i / 2] + 1;
                // dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                arr[i] = i / 2;
            }
            
            if (i % 3 == 0 && dp[i / 3] + 1 <= dp[i]) {
                dp[i] = dp[i / 3] + 1;
                arr[i] = i / 3;
            }
        }
        
        System.out.println(dp[n]);
        System.out.print(n + " ");
        // System.out.println("gd = " + arr[n]);
        while (true) {
            if (arr[n] == 0) {
                break;
            }
            System.out.print(arr[n] + " ");
            n = arr[n];
        }
	}
}
    
    
