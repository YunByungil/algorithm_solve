import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        dp[1][1] = arr[1][1];
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(dp[n][i], answer);
        }
        
        System.out.println(answer);
	}
}
    
    
