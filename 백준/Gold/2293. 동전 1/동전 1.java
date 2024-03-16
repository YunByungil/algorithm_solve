import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
    
    
