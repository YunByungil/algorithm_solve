import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t;
    public static int[][] arr, tmp;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[3][n + 1];
            dp = new int[3][n + 1];
            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            
            for (int i = 2; i <= n; i++) {
                dp[1][i] = Math.max(dp[2][i - 1], dp[2][i - 2]) + arr[1][i];
                dp[2][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[2][i];
            }
            
            // for (int i = 1; i <= 2; i++) {
            //     for (int j = 1; j <= n; j++) {
            //         System.out.print(dp[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            int answer = 0;
            answer = Math.max(dp[1][n], dp[2][n]);
            
            System.out.println(answer);
        }
        
        
        
    }
}
    
    
