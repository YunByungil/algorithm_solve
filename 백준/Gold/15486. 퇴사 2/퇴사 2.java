import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr, t, p;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 2];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int numT = Integer.parseInt(st.nextToken());
            int numP = Integer.parseInt(st.nextToken());
            t[i] = numT;
            p[i] = numP;
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            // System.out.println("dp[" + i + "] = " + dp[i]);
            
            if (i + t[i] - 1 <= n) {
                // System.out.println("i + t[i] = " + (i + t[i]));
                // System.out.println("dp[i] + p[i] = " + (dp[i] + p[i]));
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            // break;
        }
        
        
        for (int i = 1; i <= n + 1; i++) {
            answer = Math.max(answer, dp[i]);
            // System.out.println(dp[i]);
        }
        System.out.println(answer);
        
    }
}
    
    
