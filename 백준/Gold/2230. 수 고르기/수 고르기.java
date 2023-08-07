import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static long answer = 0;
    public static int[] arr, sorted;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        // int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        for (int start = 0; start < n; start++) {
            while (end < n && arr[end] - arr[start] < m) {
                end++;
            }
            
            if (end == n) {
                break;
            }
            
            min = Math.min(min, arr[end] - arr[start]);
        }
        
        
        System.out.println(min);
    }
}