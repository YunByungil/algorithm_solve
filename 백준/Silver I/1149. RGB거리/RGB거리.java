import java.util.*;
import java.io.*;

public class Main {
    public static int n, t;
    public static int[] arr, red, green, blue;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        red = new int[n];
        green = new int[n];
        blue = new int[n];
        dp = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int redColor = Integer.parseInt(st.nextToken());
            int greenColor = Integer.parseInt(st.nextToken());
            int blueColor = Integer.parseInt(st.nextToken());
            
            red[i] = redColor;
            green[i] = greenColor;
            blue[i] = blueColor;
        }
        dp[0][0] = red[0];
        dp[0][1] = green[0];
        dp[0][2] = blue[0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue[i];
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int answer = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        System.out.println(answer);
	}
}
    
    
