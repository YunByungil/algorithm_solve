import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[][] arr, tmp;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 
                        Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j- 1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(answer * answer);
        
    }
}
    
    
