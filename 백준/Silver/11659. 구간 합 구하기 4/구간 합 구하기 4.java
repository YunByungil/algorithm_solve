import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr, red, green, blue;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 0;
            result = dp[b] - dp[a - 1];
            
            System.out.println(result);
        }
	}
}
    
    
