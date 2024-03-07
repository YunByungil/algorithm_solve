import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr, t, p;
    public static long[]dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer += k / arr[i];
            k %= arr[i];
        }
        
        System.out.println(answer);
    }
}
    
    
