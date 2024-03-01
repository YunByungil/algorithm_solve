import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        // dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        int answer = 0;
        for (int i : dp) {
            // System.out.println(i);
            answer = Math.max(answer, i);
        }
        
        System.out.println(answer);
        
    }
}
    
    
