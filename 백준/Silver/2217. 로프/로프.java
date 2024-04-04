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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        int answer = arr[n - 1];
        int count = 0;
        for (int i = n; i > 0; i--) {
            // System.out.println(arr[count++] * i);
            answer = Math.max(answer, arr[count++] * i);
        }
        
        System.out.println(answer);
        
    }
}
    
    
