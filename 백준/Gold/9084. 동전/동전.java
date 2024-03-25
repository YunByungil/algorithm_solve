import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            dp = new int[m + 1];
            dp[0] = 1;
            
            for (int i = 0; i < n; i++) {
                for (int j = arr[i]; j <= m; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            
            System.out.println(dp[m]);
        }
        
    }
}
    
    
