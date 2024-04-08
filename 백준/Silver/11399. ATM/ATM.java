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
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // System.out.println("arr = " + arr[j] + " ");
                answer += arr[j];
            }
        }
        
        System.out.println(answer);
        
    }
}
    
    
