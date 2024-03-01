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
        arr = new int[n + 100];
        t = new int[n + 100];
        p = new int[n + 100];
        dp = new int[n + 100];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int numT = Integer.parseInt(st.nextToken());
            int numP = Integer.parseInt(st.nextToken());
            t[i] = numT;
            p[i] = numP;
        }
        
        int answer = 0;
        for (int i = n; i >= 1; i--) {
            if (t[i] + i <= n + 1) {
                dp[i] += Math.max(dp[t[i] + i] + p[i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
            // System.out.println(dp[i]);
        }
        System.out.println(answer);
        
    }
}
    
    
