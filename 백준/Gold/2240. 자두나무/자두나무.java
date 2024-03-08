import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, p;
    public static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[t + 1];
        dp = new int[t + 1][w + 1][3];
        
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= t; i++) {
            dp[i][0][1] = dp[i - 1][0][1] + (arr[i] == 1 ? 1 : 0);
            
            for (int j = 1; j <= w; j++) {
                if (i < j) {
                    break;
                }
                
                if (arr[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                } else if (arr[i] == 2) {
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= w; i++) {
            answer = Math.max(dp[t][i][1], dp[t][i][2]);
        }
        
        System.out.println(answer);
    }
}
    
    
