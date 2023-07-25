import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, max;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        max++;
        
        binarySearch(m);
    }
    
    public static void binarySearch(int num) {
        int start = 0;
        int end = max;
        
        while (start < end) {
            int count = 0;
            int mid = (start + end) / 2;
            
            for (int i = 0; i < n; i++) {
                if (mid == 0) {
                    System.out.println(0);
                    return;
                }
                count += arr[i] / mid;
            }
            
            if (count == num) {
                start = mid + 1;
            } else if (count > num) {
                start = mid + 1;
            } else if (count < num) {
                end = mid;
            }
        }
        
        System.out.println(start - 1);
    }
}    
