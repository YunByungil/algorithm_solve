import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(arr);
        
        int answer = Integer.MAX_VALUE;
        int end = 0;
        int num = arr[0];
        
        for (int start = 0; start < n; start++) {
            while (end < n && num < s) {
                end++;
                if (end != n) {
                    num += arr[end];
                }
            }
            
            if (end == n) {
                break;
            }
            
            answer = Math.min(answer, (end - start) + 1);
            num -= arr[start];
        }
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);
    }
}