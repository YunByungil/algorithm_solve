import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = arr[i];
        }

        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int now = arr[i];
            while (now >= max) {
                now--;
            }
            arr[i] = now;
            max = now;
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.abs(dp[i] - arr[i]);
        }
        System.out.println(answer);
        // for (int i : arr) {
        //     System.out.println(i);
        // }
        
    }
}
    
    
