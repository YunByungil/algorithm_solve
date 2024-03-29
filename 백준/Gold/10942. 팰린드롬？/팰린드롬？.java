import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[] arr, tmp;
    public static boolean[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
            if (arr[i] == arr[i - 1]) {
                dp[i - 1][i] = true;
            }
        }
        
        for (int gap = 2; gap < n; gap++) {
            for (int i = 1; i <= n - gap; i++) {
                int s = i, e = i + gap;
                if (arr[s] == arr[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (dp[s][e]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        
        System.out.println(sb);
        
    }
}
    
    
