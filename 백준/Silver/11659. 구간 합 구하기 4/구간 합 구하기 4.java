import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        
        for (int count = 0; count < m; count++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = 0;
            
            result = Math.abs(dp[start - 1] - dp[end]);
            
            System.out.println(result);
        }
        
    }
}