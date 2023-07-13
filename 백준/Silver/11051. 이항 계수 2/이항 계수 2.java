import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[1002][1002];
        
        for (int i = 1; i <= 1000; i++) {
            dp[i][0] = 1; // 하나도 안 뽑기
            dp[i][i] = 1; // 1C1, 2C2, 3C3, .... 
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10_007;
            }
        }
        
        System.out.println(dp[n][k]);
    }
}
