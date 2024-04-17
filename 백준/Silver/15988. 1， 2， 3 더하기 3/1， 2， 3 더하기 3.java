import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static long[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        arr = new long[1_000_001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            arr[i] = (arr[i - 3] + arr[i - 2] + arr[i - 1]) % 1_000_000_009;
        }
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
        
    }
}
    
    
