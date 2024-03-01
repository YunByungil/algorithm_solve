import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long[] arr;
    public static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine());
        arr = new long[101];
        dp = new long[n + 1];
        
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        
        for (int i = 4; i <= 100; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}
    
    
