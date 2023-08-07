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
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        while (end < n && start < n) {
            int sum = arr[end] - arr[start];
            if (sum >= m) {
                min = Math.min(min, sum);
                start++;
            } else if (sum < m) {
                end++;
            }
        }
        
        System.out.println(min);
    }
}