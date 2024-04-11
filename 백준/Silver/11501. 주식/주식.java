import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            int buy = 0;
            int count = 0;
            long answer = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[n - 1];
            
            for (int i = n - 2; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                } else {
                    answer += max - arr[i];
                }
            }
            
            System.out.println(answer);
        }
        
    }
}
    
    
