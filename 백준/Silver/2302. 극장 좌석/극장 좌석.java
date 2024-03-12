import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        arr = new int[1_000_001];
        dp = new int[41];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        
        int answer = 1;
        int before = 0;
        for (int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - before - 1];
            before = vip;
        }
        
        answer *= dp[n - before];
        
        System.out.println(answer);
    }
}
    
    
